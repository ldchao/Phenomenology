package vo;

/**
 * Created by lvdechao on 2016/9/30.
 */
public class AccessoryVO {

    private Integer accessoryId;
    private Integer textId;
    private String location;

    public AccessoryVO() {
    }

    public Integer getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
