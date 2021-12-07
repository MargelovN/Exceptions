package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private Product item1 = new Book(1, 1000, "Lewis Carroll", "Alice in Wonderland");
    private Product item2 = new Book(2, 118, "Darya Dontsova", "Apple");
    private Product item3 = new Smartphone(3, 119999, "Apple", "13 Pro Max");
    private Product item4 = new Smartphone(4, 1999, "Nokia", "3310");
    private Product item5 = new Product(5, 1000, "Something");

    @BeforeEach
    public void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
        Product[] expected = {
                item2,
                item3,
                item4,
                item5,
        };
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByWrongId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(9));
    }
}