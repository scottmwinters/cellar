package com.sips.cellar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "Beverages")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "name_id")
    private Name name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "maker_id")
    private Maker maker;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "style_id")
    private Style style;

    private Double abv;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "variant_id")
    private Variant variant;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "size_id")
    private Size size;

    private Integer vintage;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    private Region region;

    public Beverage(Name name, Maker maker, Style style, Double abv, Variant variant, Size size, Integer vintage, Region region) {
        this.name = name;
        this.maker = maker;
        this.style = style;
        this.abv = abv;
        this.variant = variant;
        this.size = size;
        this.vintage = vintage;
        this.region = region;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maker, style, variant, size, vintage);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Beverage other)) {
            return false;
        }
        return Objects.equals(name, other.name) &&
                Objects.equals(maker, other.maker) &&
                Objects.equals(style, other.style) &&
                Objects.equals(variant, other.variant) &&
                Objects.equals(size, other.size) &&
                Objects.equals(vintage, other.vintage);
    }
}
