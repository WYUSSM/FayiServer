package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.User;
import com.sig.fayi.exception.BaseExceptionHandleAction;
import com.sig.fayi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")//Controller类继承BaseExceptionHandleAction这个类即可在产生异常时返回数据获取失败的异常类信息
public class UserController extends BaseExceptionHandleAction {
    //注入Service实现类依赖，可注入多个Service依赖
    @Autowired
    private UserService userService;
    /**
     *
     * 查找显示所有用户数据
     *
     * @param request
     * @param response
     * @return
     * @throws IOException 这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数，这里暂时用不到
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/findAllUser")
    public ResultDto findAllUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.findAllUser();
        if (userList != null && userList.size() > 0) {
            //ResultDto返回数据的封装类，参数使用规则可自定义
            //例：
            // stauts:状态返回码，200：URL访问请求成功，并成功返回数据；500：URL访问请求成功但内部程序出错
            // msg：信息提示
            // data：需要的数据
            return new ResultDto(200, "success", userList);
        } else {
            return new ResultDto(200, "nodata", null);
        }
    }

    /*
     *@Author sig
     *@Description 注册
     *@Date 12:54 2019/1/27
     *@Param [request, response]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/register")
    public ResultDto register(HttpServletRequest request,HttpServletResponse response){
        String phone=request.getParameter("phone");
        String psw = "123456";//如果不传密码参数过来，则密码默认为123456
        if (request.getParameter("password") != null) {
            psw = request.getParameter("password");
        }
        String name = request.getParameter("name");
        //获取到name、phone和psw后直接传数据给service层处理，controller一般只处理简单的数据传输操作
        ResultDto resultDto = userService.addUserByPhonePsw(phone, psw ,name);
        return resultDto;
    }

    /*
     *@Author sig
     *@Description 电话密码登录
     *@Date 1:24 2019/1/28
     *@Param [request, response]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/login")
    public ResultDto login(HttpServletRequest request,HttpServletResponse response){
        String phone=request.getParameter("phone");
        String password=request.getParameter("password");
        ResultDto resultDto=userService.checkPassword(phone,password);
        return  resultDto;
    }

    /*
     *@Author sig
     *@Description 通过电话查找用户
     *@Date 20:41 2019/2/1
     *@Param [request, response]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @ResponseBody
    @RequestMapping(value = "/findUserByPhone")
    public ResultDto findUserByPhone(HttpServletRequest request,HttpServletResponse response){
        String phone=request.getParameter("phone");
        return userService.findUserByPhone(phone);
    }
}
