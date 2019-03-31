package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.VoluntaryClass;
import com.sig.fayi.service.VoluntaryClassService;
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
@RequestMapping("/voluntaryClass")
public class VoluntaryClassController {

    @Autowired
    private VoluntaryClassService voluntaryClassService;


    @ResponseBody
    @RequestMapping(value = "addVoluntaryClass")
    public ResultDto addVoluntaryClass(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request){
        VoluntaryClass voluntaryClass=new VoluntaryClass();
        String title=request.getParameter("title");
        String demo=request.getParameter("demo");
        String url=request.getParameter("url");
        voluntaryClass.setTitle(title);
        voluntaryClass.setDemo(demo);
        voluntaryClass.setUrl(url);
        voluntaryClass.setTime(new Date());
        if (file.length > 0) {
            String fileUUIDName= FileUploadUtil.uploadFile(file[0],request);
            voluntaryClass.setCover(fileUUIDName);
            return voluntaryClassService.addVoluntaryClass(voluntaryClass);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteVoluntaryClass")
    public ResultDto deleteVoluntaryClass(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntaryClassService.deleteVoluntaryClass(id);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllVoluntaryClass")
    public ResultDto findAllVoluntaryClass(){
        return voluntaryClassService.findAllVoluntaryClass();
    }

    @ResponseBody
    @RequestMapping(value = "/findVoluntaryClassById")
    public ResultDto findVoluntaryClassById(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntaryClassService.findVoluntaryClassById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/changeVoluntaryClassById")
    public ResultDto changeVoluntaryClassById(HttpServletRequest request){
        VoluntaryClass voluntaryClass=new VoluntaryClass();
        int id=Integer.parseInt(request.getParameter("id"));
        String title=request.getParameter("title");
        String demo=request.getParameter("demo");
        String url=request.getParameter("url");
        voluntaryClass.setId(id);
        voluntaryClass.setTitle(title);
        voluntaryClass.setDemo(demo);
        voluntaryClass.setUrl(url);
        return  voluntaryClassService.changeVoluntaryClassById(voluntaryClass);
    }

    @ResponseBody
    @RequestMapping(value = "/changeCoverById")
    public ResultDto changeCoverById(@RequestParam(value = "file") MultipartFile[] file,HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        if (file.length > 0) {
            String cover= FileUploadUtil.uploadFile(file[0],request);
            return voluntaryClassService.changeCoverById(id,cover);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
