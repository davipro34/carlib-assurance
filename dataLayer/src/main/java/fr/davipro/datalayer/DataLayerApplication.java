package fr.davipro.datalayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.davipro.datalayer.model.Category;
import fr.davipro.datalayer.model.Comment;
import fr.davipro.datalayer.model.Product;
import fr.davipro.datalayer.service.CategoryService;
import fr.davipro.datalayer.service.CommentService;
import fr.davipro.datalayer.service.ProductService;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		categoryService.getCategories().forEach(
			category -> System.out.println(category.getName())
		);

		Category newCategory = new Category();
		newCategory.setName("Promotion");

		newCategory = categoryService.addCategory(newCategory);

		categoryService.getCategories().forEach(
			category -> System.out.println(category.getName())
		);

	}

}
