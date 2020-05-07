package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Moderator;

public interface ModeratorRepository extends JpaRepository<Moderator, Integer> {
}
