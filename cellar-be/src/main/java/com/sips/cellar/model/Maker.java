package com.sips.cellar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Makers")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Maker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
