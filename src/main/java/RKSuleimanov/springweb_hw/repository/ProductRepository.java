package RKSuleimanov.springweb_hw.repository;

import RKSuleimanov.springweb_hw.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(List.of(
                new Product(1L, "Milk", 49.99F),
                new Product(2L, "Bread", 56.69F),
                new Product(3L, "Apples", 128.59F),
                new Product(4L, "Soda", 35.9F),
                new Product(5L, "Carrot", 15.39F)
        ));
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return  products.stream().filter(p -> p
                .getId()
                .equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
