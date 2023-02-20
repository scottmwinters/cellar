package com.sips.cellar.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name="beverages_old")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Beverage_old {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "style")
    private String style;

    @Column(name = "substyle")
    private String substyle;

    @Column(name = "barrel")
    private String barrel;

    @Column(name = "region")
    private String region;

    @Column(name = "abv")
    private Double abv;

    @Column(name = "maker")
    private String maker;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "variant")
    private String variant;

    @Column(name = "size")
    private Double size;

    @Column(name = "size_units")
    private String sizeUnits;

    @Column(name = "storage_loc")
    private String storageLocation;

    @Column(name = "color")
    private String color;

    @Column(name = "vintage")
    private Integer vintage;



    //TODO: convert several of these fields to enums
    //TODO: add timestamps

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Beverage_old beverageOld = (Beverage_old) o;
        return id != null && Objects.equals(id, beverageOld.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
