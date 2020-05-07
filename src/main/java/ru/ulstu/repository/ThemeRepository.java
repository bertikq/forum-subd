package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
}
