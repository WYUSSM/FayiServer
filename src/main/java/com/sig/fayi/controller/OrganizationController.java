package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Organization;
import com.sig.fayi.service.OrganizationService;
import com.sig.fayi.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    /*
     *@Author sig
     *@Description 电话密码登录
     *@Date 0:18 2019/2/12
     *@Param [request, response]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @ResponseBody
    @RequestMapping(value = "/login")
    public ResultDto login(HttpServletRequest request, HttpServletResponse response){
        String phone=request.getParameter("phone");
        String password=request.getParameter("password");
        return organizationService.findOrganitionByPhonePass(phone,password);
    }

    /*
     *@Author sig
     *@Description 注册
     *@Date 0:43 2019/2/12
     *@Param [file, request]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @ResponseBody
    @RequestMapping(value = "/register")
    public ResultDto register(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request){
        String phone=request.getParameter("phone");
        String people_name=request.getParameter("people_name");
        String organizationName=request.getParameter("organizationName");
        String idCard=request.getParameter("idCard");
        String address=request.getParameter("address");
        String signature=request.getParameter("signature");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        if (file.length ==3) {
            String proofImage=FileUploadUtil.uploadFile(file[0],request);
            String positiveImage=FileUploadUtil.uploadFile(file[1],request);
            String negativeImage=FileUploadUtil.uploadFile(file[2],request);
            Organization organization=new Organization(phone,people_name,organizationName,proofImage,idCard,positiveImage,negativeImage,address,signature,password,email,new Date());
            return organizationService.addOrganition(organization);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
