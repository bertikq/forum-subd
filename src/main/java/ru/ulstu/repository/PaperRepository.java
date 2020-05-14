package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.model.Paper;
import ru.ulstu.model.PaperStatistic;
import ru.ulstu.model.UserStatistic;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper, Integer> {

    List<Paper> findByCountSearch(int countSearch);

    @Query("SELECT new ru.ulstu.model.PaperStatistic(paper.name, paper.body) FROM Paper paper Where paper.countSearch = :countSearch")
    List<PaperStatistic> getPaperStatisticByCountSearch(@Param("countSearch") int countSearch);
}
