package Dao;

import POJO.Essay;
import POJO.Homepage;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface HomepageDao {
    public int pesist(Homepage homepage);

    public void delete(int id);

    public void update(Homepage homepage);

    public List<Homepage> findAll();

    public List<Essay> findTop5(String type,String Language);

    public List<Essay> find(String type, String language);

    public Homepage getById(int id);
}
