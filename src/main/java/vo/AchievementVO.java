package vo;

import POJO.Scientificachievement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lvdechao on 2016/10/3.
 */
public class AchievementVO {

    private Integer id;
    private String title;
    private String type;
    private String language;
    private String thumbnailLocation;
    private String descriptionLocation;
    private String time;
    private List<String> tags;

    public AchievementVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getThumbnailLocation() {
        return thumbnailLocation;
    }

    public void setThumbnailLocation(String thumbnailLocation) {
        this.thumbnailLocation = thumbnailLocation;
    }

    public String getDescriptionLocation() {
        return descriptionLocation;
    }

    public void setDescriptionLocation(String descriptionLocation) {
        this.descriptionLocation = descriptionLocation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void update(Scientificachievement scientificachievement){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.id=scientificachievement.getId();
        this.title=scientificachievement.getTitle();
        this.thumbnailLocation=scientificachievement.getThumbnailLocation();
        this.descriptionLocation=scientificachievement.getDescriptionLocation();
        this.time=sdf.format(scientificachievement.getTime());
        this.language=scientificachievement.getLanguage().toString();
    }
}
