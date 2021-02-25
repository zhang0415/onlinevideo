package dao;

import com.zh.dao.CourseTypeDao;
import com.zh.dao.UserDao;
import com.zh.domain.CourseType;
import com.zh.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDao {
//    @Autowired
//    CourseTypeDao courseTypeDao;
//    @Test
//    public void test1(){
//        CourseType courseType = new CourseType();
//        courseType.setTypeName("数据库优化");
//        courseType.setId(2);
//        courseType.setFlag((byte) 1);
//        courseTypeDao.insertCourseType(courseType);
    @Autowired
    UserDao userDao;
    @Test
    public void  test2(){
        User user = new User();
        user.setEmail("123.@qq.com");
        userDao.insertUser(user);
    }
}
