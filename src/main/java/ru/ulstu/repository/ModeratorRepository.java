package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.model.Moderator;
import ru.ulstu.model.ModeratorStatistic;

import java.util.List;

public interface ModeratorRepository extends JpaRepository<Moderator, Integer> {

    @Query("SELECT new ru.ulstu.model.ModeratorStatistic(u.name) FROM UserForum u JOIN u.moderator m")
    List<ModeratorStatistic> getModeratorStatisticByNameTheme(@Param("themeName") String nameTheme);
}
