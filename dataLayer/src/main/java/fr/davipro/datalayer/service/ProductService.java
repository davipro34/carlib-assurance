package fr.davipro.datalayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.davipro.datalayer.model.Product;
import fr.davipro.datalayer.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

}
