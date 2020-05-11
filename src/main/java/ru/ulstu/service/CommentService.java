package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.Comment;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.UserForum;
import ru.ulstu.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements Crud<Comment> {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment get(Integer id) {
        return commentRepository.getOne(id);
    }

    @Override
    public Optional<Comment> find(Integer id) {
        return commentRepository.findById(id);
    }

    @Override
    public PageableItems<Comment> findAll(int offset, int count) {
        final Page<Comment> page = commentRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Comment update(Comment comment) {
        if (comment.getId() == null) {
            throw new RuntimeException("Comment id is null");
        }
        return commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public List<Comment> findByName(String name){
        return commentRepository.findByName(name);
    }
    public List<Comment> findByUser(UserForum userForum){
        return commentRepository.findByUserForum(userForum);
    }
}
