package ru.ulstu.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends BaseEntity {

    private String name;

    private String body;

    @ManyToOne
    @JoinColumn(name = "paper_id", nullable = false)
    private Paper paper;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserForum userForum;

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

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public UserForum getUserForum() {
        return userForum;
    }

    public void setUserForum(UserForum userForum) {
        this.userForum = userForum;
    }

    @Override
    public String toString() {
        return name;
    }
}
