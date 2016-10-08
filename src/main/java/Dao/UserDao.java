package Dao;

import POJO.User;

/**
 * Created by mm on 2016/10/8.
 */
public interface UserDao {
    public User persist(User user);

    public void delete(int id);

    public void update(User user);

    public User findById(int id);

    public User findByUserName(String name);
}
