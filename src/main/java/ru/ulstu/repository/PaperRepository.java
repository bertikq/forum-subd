package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Paper;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper, Integer> {

    List<Paper> findByCountSearch(int countSearch);
}
