package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Essay;
import com.sig.fayi.exception.BaseExceptionHandleAction;
import com.sig.fayi.service.EssayService;
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
@RequestMapping("/essay")
public class EssayController extends BaseExceptionHandleAction {
    @Autowired
    private EssayService essayService;



    @ResponseBody
    @RequestMapping(value = "/findAllEssay")
    public ResultDto findAllEssay(){
        return essayService.findAllEssay();
    }


    @ResponseBody
    @RequestMapping(value = "/addEssay")
    public ResultDto addEssay(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request){
        Essay essay=new Essay();
        essay.setTitle(request.getParameter("title"));
        essay.setAuthor(request.getParameter("author"));
        essay.setUrl(request.getParameter("url"));
        essay.setView(0);
        essay.setTime(new Date());
        if (file.length > 0) {
            String fileUUIDName= FileUploadUtil.uploadFile(file[0],request);
            essay.setCover(fileUUIDName);
            return essayService.insertEssay(essay);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
