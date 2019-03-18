package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/register")
    public ResultDto addAdmin(HttpServletRequest request, HttpServletResponse response){
        String phone=request.getParameter("phone");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        return adminService.addAdmin(phone,password,name,new Date());
    }

    @ResponseBody
    @RequestMapping(value = "/findAdminByPhone")
    public ResultDto findAdminByPhone(HttpServletRequest request, HttpServletResponse response){
        String phone=request.getParameter("phone");
        return adminService.findAdminByPhone(phone);
    }

    @ResponseBody
    @RequestMapping(value = "/findAdminById")
    public ResultDto findAdminById(HttpServletRequest request, HttpServletResponse response){
        int id=Integer.parseInt(request.getParameter("id"));
        return adminService.findAdminById(id);
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResultDto findAdminByPhonePassword(HttpServletRequest request, HttpServletResponse response){
        String phone=request.getParameter("phone");
        String password=request.getParameter("password");
        return adminService.findAdminByPhonePassword(phone,password);
    }
}
