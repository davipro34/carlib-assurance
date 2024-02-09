package fr.davipro.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.davipro.datalayer.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    public Iterable<Product> findByName(String name);

    public Iterable<Product> findByCategoriesName(String name);
}
