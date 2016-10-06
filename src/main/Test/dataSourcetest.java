import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by mm on 2016/10/5.
 */
public class dataSourcetest {
    @Test
    public void datasource() throws SQLException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("infrastructure.xml");
        System.out.println(applicationContext);
        DataSource dataSource=applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
//        Configuration configuration=new Configuration().configure();
//        SessionFactory sessionFactory=configuration.buildSessionFactory();
    }
}
