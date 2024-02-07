package fr.davipro.datalayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.davipro.datalayer.model.Category;
import fr.davipro.datalayer.model.Product;
import fr.davipro.datalayer.service.CategoryService;
import fr.davipro.datalayer.service.ProductService;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Optional<Category>optCategory = categoryService.getCategoryById(1);
		Category categoryId1 = optCategory.get();
		
		System.out.println(categoryId1.getName());

		categoryId1.getProducts().forEach(
			product -> System.out.println(product.getName())
		);
		
		Optional<Product> optProduct = productService.getProductById(4);
		Product productId4 = optProduct.get();

		System.out.println(productId4.getName());

		productId4.getCategories().forEach(
			category -> System.out.println(category.getName())
		);

	}

}
