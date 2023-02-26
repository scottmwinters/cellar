package com.sips.cellar.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

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

    @Nullable
    private Integer bit_shift;
}
