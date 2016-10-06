package Dao;

import POJO.Slide;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface SlideDao {
    public int pesist(Slide slide);

    public void delete(int id);

    public List<Slide> findAll();

    public Slide getById(int id);
}
