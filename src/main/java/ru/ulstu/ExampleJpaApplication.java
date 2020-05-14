package ru.ulstu;

import org.dom4j.rule.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.ulstu.model.*;
import ru.ulstu.service.CrudService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ExampleJpaApplication {
    private final CrudService crudService;

    public ExampleJpaApplication(CrudService crudService) {
        this.crudService = crudService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExampleJpaApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() {
        UserForum userForum1 = crudService.createUser("alba", "test", "test", "user", null);
        UserForum userForum2 = crudService.createUser("alba2", "test1", "test", "user", null);
        UserForum moderatorUserForum = crudService.createUser("alba3", "test2", "test", "moderator", null);
        UserForum userForum4 = crudService.createUser("alba4", "test3", "test", "user", null);

        Moderator moderator = crudService.createModerator(moderatorUserForum);
        moderatorUserForum.setModerator(moderator);
        crudService.updateUser(moderatorUserForum);

        Theme theme1 = crudService.createTheme("Main", userForum2);
        Theme theme2 = crudService.createTheme("Game", userForum2);
        Theme theme3 = crudService.createTheme("Program", userForum2);

        HashSet<Moderator> moderators = new HashSet<Moderator>();
        moderators.add(moderator);
        Set<Theme> themesModerator = new HashSet<Theme>();

        themesModerator.add(theme1);
        themesModerator.add(theme2);
        themesModerator.add(theme3);
        theme1.setModerators(moderators);
        theme2.setModerators(moderators);
        theme3.setModerators(moderators);

        moderator.setThemes(themesModerator);

        crudService.updateModerator(moderator);
        crudService.updateTheme(theme1);
        crudService.updateTheme(theme2);
        crudService.updateTheme(theme3);

        userForum2.setThemes(themesModerator);
        crudService.updateUser(userForum2);

        Paper paper = crudService.createPaper("paperName", "paperBody", theme1, userForum1, 5);
        Paper paper2 = crudService.createPaper("paperName2", "paperBody2", theme2, userForum2, 10);
        Paper paper3 = crudService.createPaper("paperName3", "paperBody3", theme3, userForum4, 15);

        for (int i = 0; i < 5; i++){
            crudService.createComment("comment" + i, "body", paper, userForum1);
        }

        crudService.showAllComments();
        crudService.showAllModerators();
        crudService.showAllPapers();
        crudService.showAllThemes();
        crudService.showAllUsers();

        crudService.showFirstPageOfRecords();

        crudService.showFilteredRecords();

        crudService.showStatistic();
    }
}
