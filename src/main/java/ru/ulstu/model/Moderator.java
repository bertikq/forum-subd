package ru.ulstu.model;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Moderator extends BaseEntity {

    @OneToOne(mappedBy = "moderator")
    @JoinColumn(name = "user_id", nullable = true)
    private UserForum userForum;

    @ManyToMany
    private Set<Theme> themes;

    @Override
    public String toString() {
        return userForum.toString();
    }

    public UserForum getUserForum() {
        return userForum;
    }

    public void setUserForum(UserForum userForum) {
        this.userForum = userForum;
    }

    @ OrderColumn(name = "themes_index")
    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }
}
