import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YanMing on 2017/2/22.
 */
public class JdbcDao{
    private JdbcTemplate jdbcTemplate;
    private static  final  String GETNAME_query = "select * from user where name = ?";
    private static  final  String GETAGE_query = "select * from user where age = ?";
    public JdbcDao(){}

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public User selectUserByName(String name){
        User user = (User) jdbcTemplate.queryForObject(GETNAME_query, new RowMapper(){

            @Override
            public Object mapRow(ResultSet resultSet,int index) throws SQLException{

                    User user1 = new User();
                    user1.setName(resultSet.getString(1));
                    user1.setAge(resultSet.getInt(2));
                    return user1;
                }


        },name);

        return user;
    }

    public List<User> selectUserByAge(int age){
        return this.jdbcTemplate.query(GETAGE_query, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName(resultSet.getString(1));
                user.setAge(resultSet.getInt(2));
                return user;
            }
        },age);
    }
}
