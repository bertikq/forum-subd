package ru.ulstu.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(indexes = {@Index(columnList = "countSearch")})
public class Paper extends BaseEntity {

    private String name;

    private String body;

    private int countSearch;

    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    @OneToMany(mappedBy = "paper")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserForum userForum;

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCountSearch() {
        return countSearch;
    }

    public void setCountSearch(int countSearch) {
        this.countSearch = countSearch;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public UserForum getUserForum() {
        return userForum;
    }

    public void setUserForum(UserForum userForum) {
        this.userForum = userForum;
    }
}
