package vo;

/**
 * Created by lvdechao on 2016/10/3.
 */
public class PictureVO {

    private Integer id;
    private String url;
    private String location;

    public PictureVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
