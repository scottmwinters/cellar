package com.sips.cellar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Variants")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
