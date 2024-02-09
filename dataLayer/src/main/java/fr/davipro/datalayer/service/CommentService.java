package fr.davipro.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.davipro.datalayer.model.Comment;
import fr.davipro.datalayer.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }

    public Iterable<Comment> getCommentContaining(String expression) {
		return commentRepository.findByContentContaining(expression);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }
}
