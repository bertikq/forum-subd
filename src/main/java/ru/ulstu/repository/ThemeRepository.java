package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Theme;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    List<Theme> findByName(String name);
}
