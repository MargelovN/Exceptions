package ru.netology.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String brand;

    public Smartphone(int id, int price, String brand, String name) {
        super(id, price, name);
        this.brand = brand;
    }
}