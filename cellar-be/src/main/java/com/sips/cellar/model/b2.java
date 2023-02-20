package com.sips.cellar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="b2")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class b2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "style")
    private String style;

    @Column(name = "barrel")
    private Integer barrel;

    @Column(name = "region")
    private Integer region;

    @Column(name = "abv")
    private Double abv;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "storage_loc")
    private Integer storageLoc;

    @Column(name = "vintage")
    private Integer vintage;

    @Column(name = "size")
    private Integer size;
}
