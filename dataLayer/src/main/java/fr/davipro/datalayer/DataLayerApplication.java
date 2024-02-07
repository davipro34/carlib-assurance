package fr.davipro.datalayer;

import java.util.Optional;

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
		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();
 
		System.out.println(productId1.getName());	
 
		productId1.getCategories().forEach(
				category -> System.out.println(category.getName()));
		
		productId1.getComments().forEach(
				comment -> System.out.println(comment.getContent()));	
		
		Optional<Category> optCategory = categoryService.getCategoryById(1);
		Category categoryId1 = optCategory.get();
		
		System.out.println(categoryId1.getName());	
 
		categoryId1.getProducts().forEach(
				product -> System.out.println(product.getName()));
		
		Optional<Comment> optComment = commentService.getCommentById(1);
		Comment commentId1 = optComment.get();
		
		System.out.println(commentId1.getContent());
		System.out.println(commentId1.getProduct().getName());

	}

}
