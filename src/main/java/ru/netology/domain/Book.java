package ru.netology.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Book extends Product {
    private String author;

    public Book(int id, int price, String author, String name) {
        super(id, price, name);
        this.author = author;
    }
}
