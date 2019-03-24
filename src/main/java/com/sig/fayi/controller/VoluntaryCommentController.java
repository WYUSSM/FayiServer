package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityComment1;
import com.sig.fayi.service.VoluntaryCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/voluntaryComment")
public class VoluntaryCommentController {
    @Autowired
    private VoluntaryCommentService voluntaryCommentService;

    @ResponseBody
    @RequestMapping(value = "/addComment")
    public ResultDto addComment(HttpServletRequest request){
        ActivityComment1 activityComment=new ActivityComment1();
        int activityId=Integer.parseInt(request.getParameter("activityId"));
        int commentor=Integer.parseInt(request.getParameter("commentor"));
        int commentor1=Integer.parseInt(request.getParameter("commentor1"));
        String content=request.getParameter("content");
        activityComment.setActivityId(activityId);
        activityComment.setCommentor(commentor);
        activityComment.setCommentor1(commentor1);
        activityComment.setContent(content);
        activityComment.setTime(new Date());
        activityComment.setGoodCount(0);
        activityComment.setReplyCount(0);
        activityComment.setComment_read("未读");
        return voluntaryCommentService.addComment(activityComment);
    }

    @ResponseBody
    @RequestMapping(value = "/findCommentById")
    public ResultDto findCommentById(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntaryCommentService.findCommentById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteComment")
    public ResultDto deleteComment(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntaryCommentService.deleteComment(id);
    }
}
