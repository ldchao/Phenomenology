package Dao;

import POJO.Person;
import POJO.Position;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface PositionDao {
    public int pesist(Position position);

    public void delete(int id);

    public void update(Position position);

    public List<Position> findAll();

    public List<Person> find(String type, String language);
}
