package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
