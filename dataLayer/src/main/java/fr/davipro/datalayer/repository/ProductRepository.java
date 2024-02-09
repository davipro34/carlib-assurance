package fr.davipro.datalayer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.davipro.datalayer.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    public Iterable<Product> findByName(String name);

    public Iterable<Product> findByCategoriesName(String name);

    /**
     * Retrieves a list of products with the specified name using JPQL.
     *
     * @param name the name of the product to search for
     * @return an iterable collection of products matching the specified name
     */
	@Query("FROM Product WHERE name = ?1")
    public Iterable<Product> findByNameJPQL(String name);
	
    /**
     * Retrieves all products with a specific cost using a native SQL query.
     *
     * @param cost the cost of the products to retrieve
     * @return an iterable collection of products with the specified cost
     */
	@Query(value = "SELECT * FROM produit WHERE cout = :cout", nativeQuery = true)
	public Iterable<Product> findByCostNative(@Param("cout") Integer cost);

    public Iterable<Product> findByCostLessThan(Integer cost);

}