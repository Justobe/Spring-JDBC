import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YanMing on 2017/2/22.
 */

public class JdbcDaoTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");
        JdbcDao jdbcDao = (JdbcDao) context.getBean("jdbcdao");

        User user = jdbcDao.selectUserByName("yanming");
        System.out.println(user.getName() + " " + user.getAge());

        List<User> list = jdbcDao.selectUserByAge(21);
        for (User user1:list){
            System.out.println(user1.getName()+" "+user1.getAge());
        }
    }
}
