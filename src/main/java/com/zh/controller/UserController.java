package com.zh.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.zh.domain.User;
import com.zh.dto.LoginToken;
import com.zh.dto.ResponseResult;
import com.zh.exception.MyException;
import com.zh.service.UserService;
import com.zh.util.Constants;
import com.zh.util.VideoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {
    //注册
    @Autowired
    UserService service;
    @RequestMapping("/regist")
    public ModelAndView regist(User user , HttpSession session , String vcode ){
        ModelAndView mv = new ModelAndView();
        String sVcode = (String) session.getAttribute("session_vcode");
        if (StrUtil.isEmpty(vcode) == true){
            throw new MyException("验证码错误");
        }
        boolean emailMatch = ReUtil.isMatch("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", user.getEmail());
        boolean phoneMatch = ReUtil.isMatch("1[3456789]\\d{9}$", user.getMobile());
        boolean passwordMatch = ReUtil.isMatch("^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$", user.getPassword());
        if (!phoneMatch || !emailMatch || !passwordMatch) {
            // TODO 跳转到错误页面
            throw new MyException("注册信息错误");
        }

        // 参数验证通过
        int code = service.insertUser(user);
        if (code != 1) {
            // TODO 数据库插入数据失败，跳转错误页面
            throw new MyException("注册失败");
        }
        // 注册成功直接登录
        session.setAttribute("login_user", user);
        mv.setViewName("redirect:/");
        // 重定向到首页
        return mv;

    }
    @RequestMapping("/checkEmail")
    @ResponseBody
    public ResponseResult checkEmail(@RequestParam("email") String email) {

        ResponseResult result = new ResponseResult(-1, "不可以注册，已存在");

        User user = service.checkEmail(email);
        if (user == null) {

            result.setRcode(1);
            result.setMessage("可以注册");
            return result;
        }

        return result;

    }


    @RequestMapping("/checkLogin")
    @ResponseBody
    public ResponseResult checkLogin(User user){
        ResponseResult responseResult = new ResponseResult(-1,"账号密码错误");
        if (StrUtil.isEmpty(user.getEmail()) || StrUtil.isEmpty(user.getPassword())) {
            return responseResult;
        }
        User dbUser = service.login(user);
        if (dbUser == null) {
            return responseResult;
        }
        responseResult.setRcode(1);
        responseResult.setMessage("ok");
        return responseResult;
    }

    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, String autoLogin, Model model, HttpServletRequest request, HttpServletResponse response){
        ServletContext application = request.getSession().getServletContext();
        if (StrUtil.isEmpty(user.getEmail()) || StrUtil.isEmpty(user.getPassword())) {
            throw new MyException("参数错误");
        }

        User dbUser = service.login(user);
        if (dbUser != null) {
            // 登录
            HttpSession session = request.getSession();
            session.setAttribute("login_user", user);
        }
        // TODO 上面是账号密码的判断
        // TODO 自动登录
        if (!StrUtil.isEmpty(autoLogin)) {
            // 1 生成cookie返回给客户端凭证cookie
            // 2 服务器端保存token对应loginToken数据,application
            LoginToken loginToken = VideoUtil.generateLoginToken(request, user);
            Cookie cookie = new Cookie("autoToken", loginToken.generateToken());
            // 设置COOKIE保存属性
            cookie.setPath("/");
            // 单位秒 48小时 60 * 60 * 48;
            cookie.setMaxAge(60 * 60 * 48);
            response.addCookie(cookie);

            // TODO 服务器保存对应的LoginToken用户登录数据
            HashMap<String, LoginToken> tokenMap = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);
            if (tokenMap == null) {
                // 初始化
                tokenMap = new HashMap<String, LoginToken>();
                tokenMap.put(loginToken.generateToken(), loginToken);
                application.setAttribute(Constants.AUTO_LOGIN_TOKEN, tokenMap);
            } else {
                // 已经初始化，直接保存loginToken
                tokenMap.put(loginToken.generateToken(), loginToken);
            }
            System.out.println("自动登录执行了");
        }
        // 重定向到首页
        return "redirect:/";
    }

    //退出
    @RequestMapping("/logout")
    public String loginOut(HttpServletRequest request,HttpServletResponse response){
        //删除session
        HttpSession session = request.getSession();
        session.removeAttribute("login_user");
        //删除application里面的MD5和token
        ServletContext application = session.getServletContext();
        String md5Hex1 = VideoUtil.getCookieTokenValue(request);
        HashMap<String, LoginToken> tokenMap = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);
        if (StrUtil.isEmpty(md5Hex1)) {
            tokenMap.remove(md5Hex1);
        }
        //设置cookie 失效
        Cookie cookie = new Cookie("autoToken", "invalid");
        cookie.setPath("/");
        cookie.setMaxAge(1);
        response.addCookie(cookie);
        //重定向到首页
        return "redirect:/";
    }

}
