package Dao;

/**
 * Created by mm on 2016/10/3.
 */
public interface BaseDao {
    public Object persist(Object bean);

    public void delete(Object bean);

    public void update(Object bean);

    public Object findById(int i,Class clazz);
}
