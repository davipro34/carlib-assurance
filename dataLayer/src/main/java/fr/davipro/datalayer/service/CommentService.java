package fr.davipro.datalayer.service;

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
}
