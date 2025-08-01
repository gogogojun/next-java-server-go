package com.next.app.api.user.controller;

import com.next.app.api.user.entity.Product;
import com.next.app.api.user.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Controller", description = "상품 관리 API")
@CrossOrigin(origins = "http://localhost")

public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "모든 상품 조회", description = "등록된 모든 상품을 반환합니다.")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "상품 조회", description = "ID로 특정 상품을 조회합니다.")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    @Operation(summary = "상품 생성", description = "새로운 상품을 생성합니다.")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "상품 수정", description = "기존 상품 정보를 수정합니다.")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "상품 삭제", description = "상품 정보를 삭제합니다.")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
