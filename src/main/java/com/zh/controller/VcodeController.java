package com.zh.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.zh.dto.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class VcodeController {
    @RequestMapping("/checkVcode")
    @ResponseBody
    public ResponseResult checkVcode(String vcode , HttpSession session){
        ResponseResult responseResult = new ResponseResult(-1,"验证码错误");
        String sVcode = (String) session.getAttribute("session_vcode");
        if (StrUtil.isEmpty(sVcode) || StrUtil.isEmpty(vcode)){
            return responseResult;
        }
        if (sVcode.equals(vcode) == true){
            responseResult.setRcode(1);
            responseResult.setMessage("OK");
            return responseResult;
        }
        return responseResult;
    }

    char[]vcodeSequence = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    @RequestMapping("/vcode")
    public void vcode(HttpServletRequest request, HttpServletResponse response){
        // 设置生成图片的属性
        BufferedImage bufferedImage = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        //设置画笔
        Graphics2D gd = bufferedImage.createGraphics();
        //设置颜色
        gd.setColor(Color.WHITE);
        //绘制矩形
        gd.drawRect(0, 0, 80, 30);
        //设置字体
        Font font = new Font("宋体",Font.BOLD,25);
        gd.setFont(font);
        //保存验证码
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < 4;i++){
            int number = RandomUtil.randomInt(10);
            String randomNumber = String.valueOf(vcodeSequence[number]);
            builder.append(randomNumber);
            //字体颜色
            gd.setColor(new Color(RandomUtil.randomInt(255),RandomUtil.randomInt(255),RandomUtil.randomInt(255)));
            gd.drawString(randomNumber, (i + 1) * 15, 25);
        }
        // 验证码保存到session
        HttpSession session = request.getSession(true);
        session.setAttribute("session_vcode", builder.toString());
        // 设置HTTP协议响应头，图片类型
        response.setContentType("image/jpeg");
        // 不使用缓存
//        Cache-Control:no-cache
//        Pragma:no-cache
//        Expires：-1
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        try {
            ServletOutputStream ous = response.getOutputStream();
            ImageIO.write(bufferedImage,"jpeg",ous);
            ous.flush();
            ous.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
