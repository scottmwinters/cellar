import Navbar from "./Navbar"
import Wine from "./pages/Wine"
import Home from "./pages/Home"
import Beer from "./pages/Beer"
import { Route, Routes } from "react-router-dom"

function App() {
  return (
    <>
      <link href="https://fonts.googleapis.com/css?family=Cuprum&display=swap" rel="stylesheet"></link>
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/" element={<Wine />} />
          <Route path="/wine" element={<Wine />} />
          <Route path="/beer" element={<Beer />} />
        </Routes>
      </div>
    </>
  )
}

export default App