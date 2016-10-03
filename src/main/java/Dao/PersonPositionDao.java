package Dao;

import POJO.PersonPosition;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public interface PersonPositionDao {
    public int pesist(PersonPosition personPosition);

    public void delete(int id);

    public void update(PersonPosition personPosition);

    public List<PersonPosition> findAll();
}
