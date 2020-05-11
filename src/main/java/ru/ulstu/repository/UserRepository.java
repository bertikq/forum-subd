package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.model.UserForum;
import ru.ulstu.model.UserStatistic;

import java.util.List;

public interface UserRepository extends JpaRepository<UserForum, Integer> {

    List<UserForum> findByStatus(String status);

    @Query("SELECT new ru.ulstu.model.UserStatistic(u.login) FROM Theme theme JOIN theme.parent u WHERE theme.name = :themeName")
    List<UserStatistic> getLoginUsersByThemeName(@Param("themeName") String themeName);
}
