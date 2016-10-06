package DaoImpl;

import Dao.HomepageDao;
import POJO.Essay;
import POJO.Homepage;

import java.util.List;

/**
 * Created by mm on 2016/10/3.
 */
public class HomepageEssayDaoImpl implements HomepageDao {
    public int pesist(Homepage homepage) {
        return 0;
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

    public Homepage getById(int id) {
        return null;
    }
}
