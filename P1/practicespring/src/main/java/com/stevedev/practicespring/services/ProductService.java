package com.stevedev.practicespring.services;

import com.stevedev.practicespring.models.Product;
import com.stevedev.practicespring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save (Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
    }

    public Product update(Long id, Product product) {
        Optional<Product> productExists = productRepository.findById(id);
        if(productExists.isPresent()) {
            return productRepository.save(product);
        }

        return null;
    }

    public boolean delete(Long id) {
        Optional<Product> productExists = productRepository.findById(id);
        if(productExists.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
