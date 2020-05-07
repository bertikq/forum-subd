package ru.ulstu.model;

import org.dom4j.rule.Mode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class User extends BaseEntity {

    private String name;

    private String login;

    private String password;

    private String status;

    @OneToMany(mappedBy = "user")
    private Set<Paper> papers;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "parent")
    private Set<Theme> themes;

    @OneToOne
    @JoinColumn(nullable = true, name = "moderator_id")
    private Moderator moderator;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Paper> getPapers() {
        return papers;
    }

    public void setPapers(Set<Paper> papers) {
        this.papers = papers;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }

    public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderator) {
        this.moderator = moderator;
    }
}
