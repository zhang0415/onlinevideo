package com.zh.controller;



import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.zh.domain.User;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @RequestMapping("/admin")
    public String adminPage(Model model) {
        PageHelper.startPage(1,8);
        PageInfo<User> userList  = userService.findAllUser();
        model.addAttribute("userList", userList);
        return "admin_main";
    }

    @RequestMapping("/admin/user")
    public String adminPage(Model model,Integer pageNum) {

        if (pageNum==null || pageNum<=1 ){
            pageNum = 1;
        }

        PageHelper.startPage(pageNum,8);

        PageInfo<User> userList  = userService.findAllUser();
        model.addAttribute("userList", userList);

        return "admin_main";
    }
    @RequestMapping("/admin/userDel/{id}")
    public String adminDel(@PathVariable Integer id , Model model , Integer pageNum){
        int i = userService.delete(id);

        if (pageNum == null || pageNum <= 0){
            pageNum = 1;
        }

        PageHelper.startPage(pageNum,8);

        PageInfo<User> userList  = userService.findAllUser();
        model.addAttribute("userList", userList);

        return "admin_main";

    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable Integer id , Model model){
        User user = userService.findUserByIds(id);
        model.addAttribute("user",user);
        return "admin_update_user";
    }

    @RequestMapping(value = "/admin/updateUser", method = RequestMethod.POST)
    public String Update(User user){
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("mobile",user.getMobile());
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        map.put("email",user.getEmail());
        map.put("vipFlag",user.getVipFlag());
        int code = userService.updateUser(map);
        System.out.println(code);
        return "redirect:/admin/user";
    }

}
