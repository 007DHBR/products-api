package uk.ac.westminster.productsapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;

    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
    public ProductService() {
        Product digitalProduct = new DigitalProduct(
                nextId++,
                "Clean Code (E-Book)", 100.00,
                "downloads/cleancode.pdf", 12.00);

        Product physicalProduct = new PhysicalProduct(
                nextId++,
                "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm");

        products.add(digitalProduct);
        products.add(physicalProduct);
    }
}
