package Dao;

import POJO.Essay;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface EssayDao {
    public int pesist(Essay essay);

    public void delete(int id);

    public void update(Essay essay);

    public List<Essay> findAll();

    public List<Essay> findTop5(String type,String language);

    public List<Essay> find(String type,String language);

    public Essay getById(int id);
}
