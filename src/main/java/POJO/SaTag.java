package POJO;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by mm on 2017/5/14.
 */
@Entity
@Table(name = "sa_tag", schema = "phenomenology", catalog = "")
public class SaTag {
    private int views;
    private String tagName;
    private Set<Scientificachievement> scientificachievements;

    @Basic
    @Column(name = "views")
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Id
    @Column(name = "tagName")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaTag saTag = (SaTag) o;

        if (views != saTag.views) return false;
        if (tagName != null ? !tagName.equals(saTag.tagName) : saTag.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = views;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }

    @ManyToMany(cascade= {CascadeType.ALL})
    @JoinTable(name = "sa_tag_constraint",joinColumns = @JoinColumn(name = "tagName"),inverseJoinColumns = @JoinColumn(name = "scientificAchievementId"))
    public Set<Scientificachievement> getScientificachievements() {
        return scientificachievements;
    }

    public void setScientificachievements(Set<Scientificachievement> scientificachievements) {
        this.scientificachievements = scientificachievements;
    }
}
