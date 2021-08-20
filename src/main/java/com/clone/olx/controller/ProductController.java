package com.clone.olx.controller;

import com.clone.olx.enums.Category;
import com.clone.olx.enums.Currency;
import com.clone.olx.enums.Status;
import com.clone.olx.model.AppUser;
import com.clone.olx.model.Product;
import com.clone.olx.service.AppUserService;
import com.clone.olx.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final AppUserService appUserService;

    public ProductController(ProductService productService, AppUserService appUserService) {
        this.productService = productService;
        this.appUserService = appUserService;
    }

    //test method
    @GetMapping("/{uuid}")
    public String showProduct(@PathVariable String uuid, Model model) {
        UUID productUUID = UUID.fromString(uuid);
//        Product product = productService.getProductById(productUUID);
//        model.addAttribute("product", product);
//        model.addAttribute("title", product.getTitle());
        Product showedProduct = new Product(
                UUID.fromString("5bd1e73d-d99e-4330-9c07-6cbed90b4329"),
                "BMW 420d",
                BigDecimal.valueOf(5000),
                Currency.EUR,
                Category.Cars,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n" +
                        "            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco\n" +
                        "            laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit\n" +
                        "            esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa\n" +
                        "            qui officia deserunt mollit anim id est laborum.",
                Status.AVAILABLE,
                UUID.fromString("3ebca2c6-80e4-40c8-8e67-1911ab85ab31"));

        model.addAttribute("product1",showedProduct);
        model.addAttribute("user", appUserService.getAppUserByUUID(showedProduct.getAppUserId()));

        return "product-page";
    }
}