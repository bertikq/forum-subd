package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByStatus(String status);
}
