package com.sips.cellar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Regions")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subRegion;
}
