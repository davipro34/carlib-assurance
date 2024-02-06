package fr.davipro.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.davipro.datalayer.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
