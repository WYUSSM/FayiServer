package com.sig.fayi.controller;

import com.sig.fayi.dao.OrganizationPeopleDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Organization;
import com.sig.fayi.entity.User;
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
import java.util.List;

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
        Organization organization=new Organization();
        String phone=request.getParameter("phone");
        organization.setPhone(phone);
        String people_name=request.getParameter("people_name");
        organization.setPeople_name(people_name);
        String organizationName=request.getParameter("organizationName");
        organization.setOrganizationName(organizationName);
        String address=request.getParameter("address");
        organization.setAddress(address);
        String signature=request.getParameter("signature");
        organization.setSignature(signature);
        String password=request.getParameter("password");
        organization.setPassword(password);
        String email=request.getParameter("email");
        organization.setEmail(email);
        organization.setRegister_time(new Date());
        String demo=request.getParameter("demo");
        organization.setDemo(demo);
        if (file.length ==4) {
            String handIdCard=FileUploadUtil.uploadFile(file[0],request);
            organization.setHandIdCard(handIdCard);
            String positiveImage=FileUploadUtil.uploadFile(file[1],request);
            organization.setPositiveImage(positiveImage);
            String negativeImage=FileUploadUtil.uploadFile(file[2],request);
            organization.setNegativeImage(negativeImage);
            String proofImage=FileUploadUtil.uploadFile(file[3],request);
            organization.setProofImage(proofImage);
//            Organization organization=new Organization(phone,people_name,organizationName,proofImage,positiveImage,negativeImage,address,signature,password,email,0,new Date());
            return organizationService.addOrganition(organization);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    /*
     *@Author sig
     *@Description 查找所有组织
     *@Date 14:32 2019/3/1
     *@Param [request, response]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @ResponseBody
    @RequestMapping(value = "/findAllOrganization")
    public ResultDto findAllOrganization(HttpServletRequest request, HttpServletResponse response){
        List<Organization> organizations=organizationService.findAllOrganition();
        if (organizations != null && organizations.size() > 0) {
            return new ResultDto(200, "success", organizations);
        } else {
            return new ResultDto(200, "nodata", null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findOrganitionByPhone")
    public ResultDto findOrganitionByPhone(HttpServletRequest request, HttpServletResponse response){
        String phone=request.getParameter("phone");
        return organizationService.findOrganitionByPhone(phone);
    }

    @ResponseBody
    @RequestMapping(value = "/organizationRank")
    public ResultDto organizationRank(){
        return organizationService.organizationRank();
    }

    @ResponseBody
    @RequestMapping(value = "/findOrganizationById")
    public ResultDto findOrganizationById(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return organizationService.findOrganizationById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/examine")
    public ResultDto examine(HttpServletRequest request){
        int organizationId=Integer.parseInt(request.getParameter("organizationId"));
        int examineUser=Integer.parseInt(request.getParameter("examineUser"));
        String flag=request.getParameter("flag");
        return organizationService.examine(organizationId,examineUser,new Date(),flag);
    }

    @ResponseBody
    @RequestMapping(value = "/updateProof")
    public ResultDto updateProof(@RequestParam(value = "file") MultipartFile[] file,HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        if (file.length ==4) {
            String handIdCard=FileUploadUtil.uploadFile(file[0],request);
            String positiveImage=FileUploadUtil.uploadFile(file[1],request);
            String negativeImage=FileUploadUtil.uploadFile(file[2],request);
            String proofImage=FileUploadUtil.uploadFile(file[3],request);
            return organizationService.updateProof(id,handIdCard,positiveImage,negativeImage,proofImage);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findRankById")
    public ResultDto findRankById(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return organizationService.findRankById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllExmineOrganization")
    public ResultDto findAllExmineOrganization(HttpServletRequest request){
        return organizationService.findAllExmineOrganization();
    }

    @ResponseBody
    @RequestMapping(value = "/changeHeadImage")
    public ResultDto changeHeadImage(@RequestParam(value = "file") MultipartFile[] file,HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        if (file.length ==1) {
            String headImage=FileUploadUtil.uploadFile(file[0],request);
            return organizationService.changeHeadImage(headImage,id);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }
}
