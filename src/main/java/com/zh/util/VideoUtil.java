package com.zh.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.zh.domain.User;
import com.zh.dto.LoginToken;



import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class VideoUtil {
    /**
     * 获取IP地址
     * @param request
     * @return
     */
    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }



    /**
     * 生成服务器保存的用户token对象
     * @param request
     * @param user
     * @return
     */
    public static LoginToken generateLoginToken(HttpServletRequest request, User user) {
        String userAgent = request.getHeader("User-Agent");
        // 时间 + 用户(email) + IP + 浏览器信息 = （MD5）
        LoginToken loginToken = new LoginToken();
        loginToken.setNow(DateUtil.now());
        loginToken.setUserAgent(userAgent);
        loginToken.setUser(user);
        loginToken.setIp(getIPAddress(request));
        return loginToken;
    }
        //获取application中的user
        public static User getUserByApplication(Cookie[] cookies, ServletContext application) {
            String cookieToken = null;
            for (Cookie cookie : cookies) {
                String cName = cookie.getName();

                // TODO COOKIE NAME
                if ("autoToken".equals(cName)) {
                    cookieToken = cookie.getValue();
                }
            }
            // 获取服务器中的所有用户登录的token数据
            HashMap<String, LoginToken> tokenMap = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);

            // 根据客户端的token，获取服务器中的用户数据
            LoginToken token = tokenMap.get(cookieToken);
            return token.getUser();
        }


    //检验服务器中的autoToken，是否与客户端的cookies一致
    public static Boolean checkAutoLogin(Cookie[] cookies, ServletContext application){
        if (ObjectUtil.isEmpty(cookies) || cookies.length == 0) {
            // 需要重新登陆，cookie没有数据
            return false;
        }
        String cookieToken = null;
        for (Cookie cookie : cookies){
            String cName = cookie.getName();
            if ("autoToken".equals(cName)){
                cookieToken = cookie.getValue();
            }
        }

        if (StrUtil.isEmpty(cookieToken) == true){
            // 需要重新登陆，cookie没有数据
            return false;
        }

        // 获取服务器中的所有用户登录的token数据
        HashMap<String, LoginToken> tokenMap = (HashMap<String, LoginToken>) application.getAttribute(Constants.AUTO_LOGIN_TOKEN);

        if (ObjectUtil.isEmpty(tokenMap)) {
            // 服务器还未初始化HashMap
            return false;
        }
        // 根据客户端的token，获取服务器中的用户数据
        LoginToken token = tokenMap.get(cookieToken);
        if (ObjectUtil.isEmpty(token)) {
            // 服务器中没有对应的用户数据
            return false;
        }

        String serverToken = token.generateToken();

        //比对时间是否超过48小时
        // 用户上一次登录的时间
        String tokenTime = token.getNow();
        DateTime tokenDateTime =DateUtil.parse(tokenTime);

        if (System.currentTimeMillis() - tokenDateTime.getTime() >= 172800000) {
            return false;
        }

        if (cookieToken.equals(serverToken)) {
            // 验证通过，可以自动登录
            return true;
        } else {
            // 客户端token凭证失效，需要重新登陆
            return false;
        }
    }
    public static String getCookieTokenValue(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies.length == 0 || ObjectUtil.isEmpty(cookies) == true){
            return "";
        }
        for (Cookie cookie : cookies){
            String cName = cookie.getName();
            if (Constants.LOGIN_USER.equals(cName)){
                return cookie.getValue();
            }
        }
        return "";
    }

//        public static String getCookieTokenValue(HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//        if (ObjectUtil.isEmpty(cookies) || cookies.length == 0) {
//            return "";
//        }
//
//        for (Cookie cookie : cookies) {
////            String cName = cookie.getName();
////
////            // TODO COOKIE NAME
////            if ("autoToken".equals(cName)) {
////                return cookie.getValue();
////
////            }
////        }
//        return "";
//    }



}
