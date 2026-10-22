package com.budiluhur.product_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.budiluhur.product_catalog.controller.ProductController;
import com.budiluhur.product_catalog.model.Product;
import com.budiluhur.product_catalog.repository.ProductRepository;
import com.budiluhur.product_catalog.service.DiscountService;
import com.budiluhur.product_catalog.service.ProductService;

class ProductSearchTests {

    @Test
    void searchProductsMatchesNameCaseInsensitively() {
        ProductController controller = new ProductController(
                new ProductService(new ProductRepository(), new DiscountService()));

        List<Product> results = controller.searchProducts("KEYBOARD");

        assertEquals(1, results.size());
        assertEquals("PRD-01", results.get(0).getId());
    }

    @Test
    void searchProductsReturnsEmptyListWhenNoNameMatches() {
        ProductController controller = new ProductController(
                new ProductService(new ProductRepository(), new DiscountService()));

        List<Product> results = controller.searchProducts("monitor");

        assertTrue(results.isEmpty());
    }
}
