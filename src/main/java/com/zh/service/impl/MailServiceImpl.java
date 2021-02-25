package com.zh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl{
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(){
        //创建邮件对象
        MimeMessage message = javaMailSender.createMimeMessage();
        //.发送这个邮件  找小弟帮忙
        MimeMessageHelper helper = new MimeMessageHelper(message);
        //4.需要告知helper 发给谁 发什么
        try {
            //用什么用邮箱发送
            helper.setFrom("1932685116@qq.com");
            //发送给谁
            String[] strings = {"1220349152@qq.com","861657765@qq.com"};
            helper.setTo(strings);
            //主题
            helper.setSubject("test");
            //内容
            helper.setText("666");
            //发送
            javaMailSender.send(message);
            System.out.println("发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
