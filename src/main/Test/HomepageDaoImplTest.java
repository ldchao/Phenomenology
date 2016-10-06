import DaoImpl.HomepageDaoImpl;
import POJO.Homepage;
import org.junit.Test;

/**
 * Created by mm on 2016/10/6.
 */
public class HomepageDaoImplTest {

    @Test
    public void persist(){
        Homepage homepage=new Homepage();
        homepage.setId(1);
        homepage.setLanguage("English");
        homepage.setType("none");
        HomepageDaoImpl homepageDao=new HomepageDaoImpl();
        homepageDao.pesist(homepage);
    }
}
