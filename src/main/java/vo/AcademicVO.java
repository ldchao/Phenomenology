package vo;

import POJO.Essay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lvdechao on 2016/9/30.
 */

public class AcademicVO {

    private Integer id;
    private String title;
    private String time;
    private String author;
    private String location;
    private String language;
    private int pageView;
    private String type;
    private List<String> tags;

    public AcademicVO() {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageView() {
        return pageView;
    }

    public void setPageView(int pageView) {
        this.pageView = pageView;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void update(Essay essay){
        this.id=essay.getId();
        this.author=essay.getAuthor();
        this.location=essay.getLocation();
        this.title=essay.getTitle();
        this.language=essay.getLanguage().toString();
        this.pageView=essay.getPageView();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        this.time=sdf.format(essay.getTime());
    }
}
