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

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));

		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getContent()));

		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));
		
	}

}
