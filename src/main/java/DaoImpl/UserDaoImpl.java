package DaoImpl;

import Dao.BaseDao;
import Dao.UserDao;
import POJO.User;

/**
 * Created by mm on 2016/10/8.
 */
public class UserDaoImpl implements UserDao {
    BaseDao baseDao;
    public static final String NAME="name";
    public UserDaoImpl(){
        baseDao=new BaseDaoImpl();
    }

    public User persist(User user) {
        User po=null;
        try {
            po=(User) baseDao.persist(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return po;
    }

    public void delete(int id) {
        User user=new User();
        user.setId(id);
        baseDao.delete(user);
    }

    public void update(User user) {
        baseDao.update(user);
    }

    public User findById(int id) {
        User user=null;
        try {
            user= (User) baseDao.findById(id,User.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public User findByUserName(String name) {
        String[] properties={NAME};
        Object[] values={name};
        try{
            return (User) baseDao.findByProperties("User",properties,values);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
