package com.sips.cellar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Locations")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int bit_shift;
}
