package ru.ulstu.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Moderator extends BaseEntity {

    @OneToOne(mappedBy = "moderator")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    private Set<Theme> themes;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }
}
