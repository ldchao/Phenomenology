package POJO;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mm on 2017/5/13.
 */
@Entity
@Table(name = "essay_tag", schema = "phenomenology", catalog = "")
public class EssayTag {
    private String tagName;
    private int views;
    private Set<Essay> essays=new HashSet<Essay>();

    @Id
    @Column(name = "tagName")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Basic
    @Column(name = "views")
    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EssayTag essayTag = (EssayTag) o;

        if (views != essayTag.views) return false;
        if (tagName != null ? !tagName.equals(essayTag.tagName) : essayTag.tagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagName != null ? tagName.hashCode() : 0;
        result = 31 * result + views;
        return result;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "essay_tag_constraint",joinColumns = @JoinColumn(name = "tagName"),inverseJoinColumns =@JoinColumn(name = "essayId") )
    public Set<Essay> getEssays() {
        return essays;
    }

    public void setEssays(Set<Essay> essays) {
        this.essays = essays;
    }
}
