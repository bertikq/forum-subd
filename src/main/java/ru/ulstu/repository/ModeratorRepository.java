package ru.ulstu.repository;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.model.Moderator;
import ru.ulstu.model.UserForum;

import java.util.List;

public interface ModeratorRepository extends JpaRepository<Moderator, Integer> {

    @Query("SELECT user.name FROM UserForum user JOIN user.moderator m JOIN m.themes t " +
            "WHERE :themeName IN (SELECT name FROM t) GROUP BY user.name")
    List<String> getNameModeratorsControllerTheme(@Param("themeName") String themeName);
}
