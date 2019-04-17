package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.HomeBanner;
import com.sig.fayi.exception.BaseExceptionHandleAction;
import com.sig.fayi.service.BannerService;
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
@RequestMapping("/banner")//Controller类继承BaseExceptionHandleAction这个类即可在产生异常时返回数据获取失败的异常类信息
public class BannerController extends BaseExceptionHandleAction {
    //注入Service实现类依赖，可注入多个Service依赖
    @Autowired
    private BannerService bannerService;

    /*
     *@Author sig
     *@Description 查找所有展示对象
     *@Date 16:13 2019/2/5
     *@Param []
     *@return com.sig.fayi.dto.ResultDto
     **/
    @ResponseBody
    @RequestMapping(value = "/findAllBanner")
    public ResultDto findAllBanner(){
        return bannerService.findAllBanner();
    }

    @ResponseBody
    @RequestMapping(value = "/insertBanner")
    public ResultDto insertBanner(@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request){
        HomeBanner homeBanner=new HomeBanner();
        homeBanner.setDemo(request.getParameter("demo"));
        homeBanner.setUrl(request.getParameter("url"));
        homeBanner.setTime(new Date());
        if (file.length > 0) {
            String fileUUIDName= FileUploadUtil.uploadFile(file[0],request);
            homeBanner.setImage(fileUUIDName);
            return bannerService.inserBanner(homeBanner);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/editBanner")
    public ResultDto editBanner(HttpServletRequest request){
        HomeBanner homeBanner=new HomeBanner();
        homeBanner.setId(Integer.parseInt(request.getParameter("id")));
        homeBanner.setDemo(request.getParameter("demo"));
        homeBanner.setUrl(request.getParameter("url"));
        return bannerService.editBanner(homeBanner);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteBanner")
    public ResultDto deleteBanner(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return bannerService.deleteBanner(id);
    }

    @ResponseBody
    @RequestMapping(value = "/changeImage")
    public ResultDto changeImage(@RequestParam(value = "file") MultipartFile[] file,HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        if(file.length>0){
            String image= FileUploadUtil.uploadFile(file[0],request);
            return bannerService.changeImage(image,id);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findBannerById")
    public ResultDto findBannerById(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return bannerService.findBannerById(id);
    }
}
