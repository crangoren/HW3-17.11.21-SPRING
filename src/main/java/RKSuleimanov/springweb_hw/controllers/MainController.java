package RKSuleimanov.springweb_hw.controllers;

import RKSuleimanov.springweb_hw.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productRepository.getProductList());
        return "products_page";
    }
}
