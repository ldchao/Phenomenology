package DaoImpl;

import Dao.BaseDao;
import Dao.HomepageDao;
import POJO.Essay;
import POJO.Homepage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class HomepageEssayDaoImpl implements HomepageDao {
//    @Autowired
    BaseDao baseDao;

    public int pesist(Homepage homepage) {
        Homepage bean=(Homepage)baseDao.persist(homepage);
        return bean.getId();
    }

    public void delete(int id) {

    }

    public void update(Homepage homepage) {

    }

    public List<Homepage> findAll() {
        return null;
    }

    public List<Essay> findTop5(String type, String Language) {
        return null;
    }

    public List<Essay> find(String type, String language) {
        return null;
    }
}
