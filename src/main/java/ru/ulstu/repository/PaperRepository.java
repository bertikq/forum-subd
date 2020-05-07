package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Paper;

public interface PaperRepository extends JpaRepository<Paper, Integer> {
}
