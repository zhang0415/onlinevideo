package service;

import com.zh.service.UserService;
import com.zh.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CheckEmail {
    @Autowired
    UserService userService;
    @Autowired
    MailServiceImpl mailService;

    @Test
    public void t1(){

        System.out.println(userService.checkEmail("15855555555@qq.com"));
    }

    @Test
    public void t2(){
        mailService.send();
    }
}
