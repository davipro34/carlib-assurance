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
	
		Iterable<Product> searchResults = productService.getProductsByName("AssuranceTousRisques");
		searchResults.forEach(product -> System.out.println(product.getProductId()));

		searchResults = productService.getProductsByCategoryName("Standard");
		searchResults.forEach(product -> System.out.println(product.getName()));

		Iterable<Category> searchCategory = categoryService.getCategoryByName("Standard");
		searchCategory.forEach(category -> System.out.println(category.getCategoryId()));
		
		searchCategory = categoryService.getCategoriesByProductName("AssuranceTousRisques");
		searchCategory.forEach(category -> System.out.println(category.getName()));

		searchResults = productService.getProductsByCostLessThan(1000);
		searchResults.forEach(product -> System.out.println(product.getName()));

		Iterable<Comment> searchComments = commentService.getCommentContaining("deçu");
		searchComments.forEach(comment -> System.out.println(comment.getContent()));

	}
}
