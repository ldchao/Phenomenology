package Dao;

import POJO.Scientificachievement;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface ScientificachievementDao {
    public int pesist(Scientificachievement scientificachievement);

    public void delete(int id);

    public void update(Scientificachievement scientificachievement);

    public List<Scientificachievement> findAll();


    public List<Scientificachievement> find(String type, String language);

    public Scientificachievement getById(int id);
}
