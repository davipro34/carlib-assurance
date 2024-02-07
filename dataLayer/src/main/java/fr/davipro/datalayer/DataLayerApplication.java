package fr.davipro.datalayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.davipro.datalayer.model.Product;
import fr.davipro.datalayer.service.ProductService;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {
	
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<Product> optProduct = productService.getProductById(1);
		Product productId1 = optProduct.get();

		System.out.println(productId1.getName());

		productId1.getComments().forEach(
			comment -> System.out.println(comment.getContent())
		);


	}

}
