package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityReply;
import com.sig.fayi.entity.ActivityReply1;
import com.sig.fayi.service.VoluntaryReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/voluntaryReply")
public class VoluntaryReplyController {
    @Autowired
    private VoluntaryReplyService voluntaryReplyService;

    @ResponseBody
    @RequestMapping(value = "/addReply")
    public ResultDto addReply(HttpServletRequest request){
        int commentId=Integer.parseInt(request.getParameter("commentId"));
        int responder=Integer.parseInt(request.getParameter("responder"));
        int responder1=Integer.parseInt(request.getParameter("responder1"));
        String reply_conent=request.getParameter("reply_conent");
        ActivityReply1 activityReply=new ActivityReply1();
        activityReply.setCommentId(commentId);
        activityReply.setResponder(responder);
        activityReply.setResponder1(responder1);
        activityReply.setReply_conent(reply_conent);
        activityReply.setReply_time(new Date());
        activityReply.setReply_read("未读");
        return voluntaryReplyService.addReply(activityReply);
    }

    @ResponseBody
    @RequestMapping("/deleteReply")
    public ResultDto deleteReply(HttpServletRequest request){
        int replyId=Integer.parseInt(request.getParameter("replyId"));
        int commentId=Integer.parseInt(request.getParameter("commentId"));
        return voluntaryReplyService.deleteReply(replyId,commentId);
    }
}
