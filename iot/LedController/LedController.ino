#include <SPI.h>
#include <WiFiNINA.h>
#include <FastLED.h>
#include <bitset>

#define LED_COUNT 90
#define DATA_PIN 10
#define CLOCK_PIN 12

CRGB leds[LED_COUNT];

char ssid[] = "winternet"; // your network SSID (name)
char pass[] = "8039938853"; // your network password
int status = WL_IDLE_STATUS; // the WiFi radio's status

WiFiServer server(80); // create a server at port 80

void setup() {
  Serial.begin(9600);
  // while (!Serial) {
  //   ; // wait for serial port to connect. Needed for native USB port only
  // }

  // initialize LEDs
  FastLED.addLeds<APA102, DATA_PIN, CLOCK_PIN, BGR>(leds, LED_COUNT);

  // initialize WiFi
  while (status != WL_CONNECTED) {
    Serial.print("Attempting to connect to network...");
    status = WiFi.begin(ssid, pass);
    delay(5000);
  }
  Serial.println("Connected to wifi");

  // start the server
  server.begin();
  Serial.println("Server started");
}

void loop() {
  // listen for incoming clients
  WiFiClient client = server.available();
  if (client) {
    Serial.println("New client");
    // read the first line of the request
    String request = client.readStringUntil('\r');
    Serial.println(request);
    client.flush();
    int bit_array[16];

    // parse the query string
    int startLed = 0;
    int endLed = 0;
    if (request.indexOf("GET /?") != -1) {
      int queryStart = request.indexOf("GET /?") + 6;
      int queryEnd = request.indexOf(" HTTP/");
      String queryString = request.substring(queryStart, queryEnd);
      if (queryString.length() >= 4) {
        startLed = hexToBits(queryString.charAt(0)) * 6 + hexToBits(queryString.charAt(1));
        endLed = hexToBits(queryString.charAt(2)) * 6 + hexToBits(queryString.charAt(3));


         unsigned long hex_val = strtoul(queryString.c_str(), nullptr, 16);

        // convert unsigned long to bitset
        std::bitset<16> bits(hex_val);

        /* the LEDs snake back-and-forth in the shelves, such that the 4th slot is directly below the 3rd, not below the first.
        0 | 1 | 2
        3 | 4 | 5
        8   7   6
        9   10  11
        14  13 12        
    
        // // swap bits 3 and 5
        // int temp = bits[3];
        // bits[3] = bits[5];
        // bits[5] = temp;

        // // swap bits 9 and 11
        // temp = bits[9];
        // bits[9] = bits[11];
        // bits[11] = temp;

        for (int i = 0; i < 16; i++) {
            bit_array[i] = bits[i];
            Serial.print(bits[i]);
        }
      }
      request = "0";
    }

    // set the requested LEDs to blue
    for (int i = 0; i <= 16; i++) {
      if(bit_array[i] == 1) {
        int startLed = i * 6;
        for(int j = 0; j < 6; j++) {
          leds[startLed + j] = CRGB::Purple;
        }
      }
    }
    FastLED.show();

    // wait for 10 seconds or until a new query
    unsigned long startTime = millis();
    while (client.connected() && millis() - startTime < 10000) {
      if (client.available()) {
        // discard any remaining input from the client
        client.read();
      }
    }

    // turn off all LEDs
    for (int i = 0; i < LED_COUNT; i++) {
      leds[i] = CRGB(0, 0, 0);
    }
    FastLED.show();

    // close the connection
    client.stop(); 
    Serial.println("Client disconnected");
  }
}

int hexToBits(char hex) {
  if (hex >= '0' && hex <= '9') {
    return hex - '0';
  } else if (hex >= 'A' && hex <= 'F') {
    return hex - 'A' + 10;
  } else if (hex >= 'a' && hex <= 'f') {
    return hex - 'a' + 10;
  } else {
    return 0;
  }
}
