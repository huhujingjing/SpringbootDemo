package com.example.demo.controller;

import com.example.demo.model.TUser;
import com.example.demo.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: HUJING
 * @Date: 2019/1/10 18:12
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class TUserController {

    @Autowired
    private TUserService service;

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int addUser(TUser user){
        return service.insertSelective(user);
    }

    @ResponseBody
    @RequestMapping(value = "/showUser",produces = {"application/json;charset=UTF-8"})
    public ModelAndView selectByPrimaryKey(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        TUser user = this.service.selectByPrimaryKey(userId);
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return service.findAllUser(pageNum,pageSize);
    }

//    @RequestMapping(value = "/index",method = RequestMethod.GET)
//    public String index(){
//        return "test"; //当浏览器输入/index时，会返回 /static/home.html的页面
//    }

}
