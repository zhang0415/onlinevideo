package dao;


import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageInfo;
import com.zh.dao.CourseTopicDao;
import com.zh.dao.CourseTypeDao;
import com.zh.dao.ToolsTypeDao;
import com.zh.dao.UserDao;
import com.zh.domain.CourseTopic;
import com.zh.domain.CourseType;
import com.zh.domain.ToolsType;
import com.zh.domain.User;
import com.zh.service.CourseTopicService;
import com.zh.service.impl.CourseTopicServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDao {
    @Autowired
    CourseTypeDao courseTypeDao;
    @Test
    public void test1() {
        CourseType courseType = new CourseType(5,"分布式",(byte)1);
        courseTypeDao.insertCourseType(courseType);

    }
    @Autowired
    UserDao userDao;
    @Test
    public void  test2(){
        User user = new User();
        user.setEmail("123.@qq.com");
        userDao.insertUser(user);
    }

    @Autowired
    CourseTopicDao courseTopicDao;
    @Test
    public void t3() {

        for (int i = 1; i<=100 ;i++){
            CourseTopic courseTopic = new CourseTopic();
            courseTopic.setId(i);
            courseTopic.setTitle("Flutter从入门到进阶" +i);
            courseTopic.setIconUrl("/static/imgs/card-item.png");
            courseTopic.setIntroUrl("none");
            courseTopic.setTopicIntro("一系列由易到难通用组件开发，让你学会一个基本的组件库的开发思路和技巧。" + i);
            courseTopic.setViews(1000);
            courseTopic.setFlag(1);
            courseTopic.setTypeId(RandomUtil.randomInt(1, 6));
            courseTopic.setVipFlag(RandomUtil.randomInt(0, 2));
            courseTopic.setCoursewareUrl("none");
            courseTopic.setCreateTime(new Date());
            int code = courseTopicDao.insertCourseTopic(courseTopic);
            System.out.println(code);
        }


    }


    @Autowired
    CourseTopicService service;
    @Test
    public void t4() {
//        List<CourseTopic> courseTopics = service.getIndexCourseTopic(3);
//        int i = courseTopics.size();
//        System.out.println(i);
        PageInfo<CourseTopic> courseTopics = service.getIndexCourseTopic(4);
        System.out.println(courseTopics.getSize());

    }

}
