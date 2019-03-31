package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.GoodWelfare;
import com.sig.fayi.service.GoodWelfareService;
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
@RequestMapping("/goodWelfare")
public class GoodWelfareController {

    @Autowired
    private GoodWelfareService goodWelfareService;

    @ResponseBody
    @RequestMapping(value = "/addGoodWelfare")
    public ResultDto addGoodWelfare(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request){
        GoodWelfare goodWelfare=new GoodWelfare();
        String title=request.getParameter("title");
        String demo=request.getParameter("demo");
        String url=request.getParameter("url");
        goodWelfare.setTitle(title);
        goodWelfare.setDemo(demo);
        goodWelfare.setUrl(url);
        goodWelfare.setTime(new Date());
        if (file.length > 0) {
            String fileUUIDName= FileUploadUtil.uploadFile(file[0],request);
            goodWelfare.setCover(fileUUIDName);
            return goodWelfareService.addGoodWelfare(goodWelfare);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteGoodWelfare")
    public ResultDto deleteGoodWelfare(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return goodWelfareService.deleteGoodWelfare(id);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllGoodWelfare")
    public ResultDto findAllGoodWelfare(HttpServletRequest request){
        return goodWelfareService.findAllGoodWelfare();
    }

    @ResponseBody
    @RequestMapping(value = "/findGoodWelfareById")
    public ResultDto findGoodWelfareById(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return goodWelfareService.findGoodWelfareById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/changeGoodWelfareById")
    public ResultDto changeGoodWelfareById(HttpServletRequest request){
        GoodWelfare goodWelfare=new GoodWelfare();
        int id=Integer.parseInt(request.getParameter("id"));
        String title=request.getParameter("title");
        String demo=request.getParameter("demo");
        String url=request.getParameter("url");
        goodWelfare.setId(id);
        goodWelfare.setTitle(title);
        goodWelfare.setDemo(demo);
        goodWelfare.setUrl(url);
        return goodWelfareService.changeGoodWelfareById(goodWelfare);
    }

    @ResponseBody
    @RequestMapping(value = "/changeCoverById")
    public ResultDto changeCoverById(@RequestParam(value = "file") MultipartFile[] file,HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        if (file.length > 0) {
            String cover= FileUploadUtil.uploadFile(file[0],request);
            return goodWelfareService.changeCoverById(id,cover);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
