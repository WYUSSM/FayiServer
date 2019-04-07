package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityGood;
import com.sig.fayi.service.VoluntaryGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/voluntaryGood")
public class VoluntaryGoodController {
    @Autowired
    private VoluntaryGoodService voluntaryGoodService;

    @ResponseBody
    @RequestMapping("/addGood")
    public ResultDto addGood(HttpServletRequest request){
        int commentId=Integer.parseInt(request.getParameter("commentId"));
        int gooder=Integer.parseInt(request.getParameter("gooder"));
        int gooder1=Integer.parseInt(request.getParameter("gooder1"));
        ActivityGood activityGood=new ActivityGood();
        activityGood.setCommentId(commentId);
        activityGood.setGooder(gooder);
        activityGood.setGooder1(gooder1);
        activityGood.setGood_time(new Date());
        activityGood.setGood_read("未读");
        return voluntaryGoodService.addGood(activityGood);
    }

    @ResponseBody
    @RequestMapping("/deleteGood")
    public ResultDto deleteGood(HttpServletRequest request){
        int goodId=Integer.parseInt(request.getParameter("goodId"));
        int commentId=Integer.parseInt(request.getParameter("commentId"));
        return voluntaryGoodService.deleteGood(goodId,commentId);
    }


}
