package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.IdCard;
import com.sig.fayi.service.IdCardService;
import com.sig.fayi.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/idCard")
public class IdCardController {

    @Autowired
    private IdCardService idCardService;

    @ResponseBody
    @RequestMapping(value = "/upladIdCard")
    public ResultDto upladIdCard(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request){
        IdCard idCard1=new IdCard();
        String idCard=request.getParameter("idCard");
        int userId=Integer.parseInt(request.getParameter("userId"));
        idCard1.setIdCard(idCard);
        idCard1.setFlag("未审核");
        idCard1.setUpload_time(new Date());
        if (file.length > 0) {
            String positiveImage= FileUploadUtil.uploadFile(file[0],request);
            String negativeImage= FileUploadUtil.uploadFile(file[1],request);
            idCard1.setPositiveImage(positiveImage);
            idCard1.setNegativeImage(negativeImage);
            return idCardService.upladIdCard(idCard1,userId);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/changeIdCard")
    public ResultDto changeIdCard(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request){
        IdCard idCard1=new IdCard();
        int id=Integer.parseInt(request.getParameter("id"));
        int userId=Integer.parseInt(request.getParameter("userId"));
        String idCard=request.getParameter("idCard");
        idCard1.setId(id);
        idCard1.setIdCard(idCard);
        idCard1.setUpload_time(new Date());
        if (file.length > 0) {
            String positiveImage= FileUploadUtil.uploadFile(file[0],request);
            String negativeImage= FileUploadUtil.uploadFile(file[1],request);
            idCard1.setPositiveImage(positiveImage);
            idCard1.setNegativeImage(negativeImage);
            return idCardService.changeIdCard(idCard1,userId);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findAllUser")
    public ResultDto findAllUser(){
        return idCardService.findAllUser();
    }

    @ResponseBody
    @RequestMapping(value = "/examineIdCard")
    public ResultDto examineIdCard(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        int examineUser=Integer.parseInt(request.getParameter("examineUser"));
        String flag=request.getParameter("flag");
        Date examine_time=new Date();
        return idCardService.examineIdCard(id,examineUser,examine_time,flag);
    }
}
