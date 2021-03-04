package dao;


import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageInfo;
import com.zh.dao.*;
import com.zh.domain.*;
import com.zh.service.CourseTopicService;
import com.zh.service.CourseTypeService;
import com.zh.service.ToolsItemService;
import com.zh.service.ToolsTypeService;
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
        CourseType courseType = new CourseType(5,"分布式",1);
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

    @Autowired
    CourseTypeService courseTypeService;
    @Test
    public void t5(){
        List<CourseType> listAll = courseTypeService.getAllCourseType();
        for (CourseType courseType : listAll){
            System.out.println(courseType.getName());
        }
    }

    @Autowired
    ToolsItemService toolsItemService;

    @Test
    public void t6(){
        for (int i =101 ;i <=150 ;i++){
            ToolsItem toolsItem = new ToolsItem();
            toolsItem.setId(i);
            toolsItem.setName("进制转换器"+i);
            toolsItem.setToolsUrl("https://tool.lu/hexconvert/");
            toolsItem.setIconUrl("/static/imgs/card-item.png");

            toolsItem.setToolsTypeId(3);
            toolsItemService.insertToolsItem(toolsItem);

        }


//        System.out.println(toolsItemService.getToolsItem(3).getSize());
//        System.out.println(toolsItemService.getToolsItemAll().getSize());


    }

    @Autowired
    ToolsTypeService toolsTypeService;

    @Test
    public void t7(){
        System.out.println(toolsTypeService.getToolsTypeAll().size());
    }


    @Autowired
    CourseVideoDao courseVideoDao;
    @Test
    public void t8() {
//        for (int i = 100; i < 300; i++) {
            CourseVideo courseVideo = new CourseVideo();
            courseVideo.setId(300);
            courseVideo.setName("Vue3.0（正式版）" + 300);
            courseVideo.setFreeView(RandomUtil.randomInt(0, 2));
            courseVideo.setTopicId(100);
            courseVideo.setCreateTime(new Date());
            courseVideo.setFlag(1);
            courseVideo.setVideoUrl1("//player.bilibili.com/player.html?aid=712169146&bvid=BV1iD4y1o7dD&cid=238287362&page=1");
            courseVideo.setVideoUrl2("none");

            int code = courseVideoDao.insertCourseVideo(courseVideo);
            System.out.println(code);
//        }
    }
}
