package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor
@Data

public class ProductManager {
    private ProductRepository repository;

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getBrand().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
        }
        return false;
    }
}
