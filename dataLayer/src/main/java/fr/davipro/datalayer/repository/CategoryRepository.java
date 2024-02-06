package fr.davipro.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.davipro.datalayer.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
