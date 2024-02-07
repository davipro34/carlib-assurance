package fr.davipro.datalayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.davipro.datalayer.model.Category;
import fr.davipro.datalayer.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
