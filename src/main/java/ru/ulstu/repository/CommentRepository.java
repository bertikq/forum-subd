package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Comment;
import ru.ulstu.model.UserForum;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByName(String name);

    List<Comment> findByUserForum(UserForum userForum);
}
