package ru.ulstu.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Theme extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "theme")
    private Set<Paper> papers;

    @ManyToMany
    private Set<Moderator> moderators;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private UserForum parent;

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

    public Set<Paper> getPapers() {
        return papers;
    }

    public void setPapers(Set<Paper> papers) {
        this.papers = papers;
    }

    public Set<Moderator> getModerators() {
        return moderators;
    }

    public void setModerators(Set<Moderator> moderators) {
        this.moderators = moderators;
    }

    public UserForum getParent() {
        return parent;
    }

    public void setParent(UserForum parent) {
        this.parent = parent;
    }
}
