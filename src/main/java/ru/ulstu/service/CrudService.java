package ru.ulstu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ulstu.model.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CrudService {
    private static final Logger log = LoggerFactory.getLogger(CrudService.class);
    private final static int PAGE_OF_RECORDS_SIZE = 10;

    private final CommentService commentService;
    private final ModeratorService moderatorService;
    private final PaperService paperService;
    private final ThemeService themeService;
    private final UserService userService;

    public CrudService(CommentService commentService,
                       ModeratorService moderatorService,
                       PaperService paperService,
                       ThemeService themeService,
                       UserService userService) {
        this.commentService = commentService;
        this.moderatorService = moderatorService;
        this.paperService = paperService;
        this.themeService = themeService;
        this.userService = userService;
    }

    public User createUser(String name, String login, String password, String status, Moderator moderator){
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);
        if (moderator != null && moderator.getId() != null){
            user.setModerator(moderator);
        }
        return userService.create(user);
    }

    public User updateUser(User user){
        return userService.update(user);
    }

    public void deleteUser(User user){
        userService.delete(user);
    }

    public void showAllUsers(){
        log.info("All users:\n");
        log.info(userService.findAll().toString());
    }

    public Theme createTheme(String name, User parent){
        if (parent == null)
            return null;

        Theme theme = new Theme();
        theme.setName(name);
        theme.setParent(parent);
        return themeService.create(theme);
    }

    public Theme updateTheme(Theme theme){
        return themeService.update(theme);
    }

    public void deleteTheme(Theme theme){
        themeService.delete(theme);
    }

    public void showAllThemes(){
        log.info("All themes:\n");
        log.info(themeService.findAll().toString());
    }

    public Paper createPaper(String name, String body, Theme themeParent, User user){
        if (themeParent.getId() == null || user.getId() == null)
            return null;

        Paper paper = new Paper();
        paper.setName(name);
        paper.setBody(body);
        paper.setUser(user);
        paper.setTheme(themeParent);

        return paperService.create(paper);
    }

    public Paper updatePaper(Paper paper){
        return paperService.update(paper);
    }

    public void deletePaper(Paper paper){
        paperService.delete(paper);
    }

    public void showAllPapers(){
        log.info("All papers:\n");
        log.info(paperService.findAll().toString());
    }

    public Moderator createModerator(User user){
        if (user.getId() == null)
            return null;
        Moderator moderator = new Moderator();
        moderator.setUser(user);
        return  moderatorService.create(moderator);
    }

    public Moderator updateModerator(Moderator moderator){
        return moderatorService.update(moderator);
    }

    public void deleteModerator(Moderator moderator){
        moderatorService.delete(moderator);
    }

    public void showAllModerators(){
        log.info("All moderators:\n");
        log.info(moderatorService.findAll().toString());
    }

    public Comment createComment(String name, String body, Paper paper, User user){
        if (paper.getId() == null || user.getId() == null)
            return null;
        Comment comment = new Comment();
        comment.setBody(body);
        comment.setName(name);
        comment.setPaper(paper);
        comment.setUser(user);

        return commentService.create(comment);
    }

    public Comment updateComment(Comment comment){
        return  commentService.update(comment);
    }

    public void deleteComment(Comment comment){
        commentService.delete(comment);
    }

    public void showAllComments(){
        log.info("All comments:\n");
        log.info(commentService.findAll().toString());
    }
    public void showFirstPageOfRecords() {
        log.info("First page of records:\n");
        log.info(userService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(themeService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(paperService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(moderatorService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(commentService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
    }

    public void showFilteredRecords() {
        log.info("Filtered records:\n");

        List<User> users = userService.findByStatus("user");
        log.info(users.toString());

        List<Theme> themes = themeService.findByName("Programs");
        log.info(themes.toString());
    }

}
