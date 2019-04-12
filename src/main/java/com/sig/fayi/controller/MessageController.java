package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Message;
import com.sig.fayi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/addMessage")
    public ResultDto addMessage(HttpServletRequest request){
        Message message=new Message();
        int organizationId=Integer.parseInt(request.getParameter("organizationId"));
        int userId=Integer.parseInt(request.getParameter("userId"));
        String content=request.getParameter("content");
        message.setOrganizationId(organizationId);
        message.setUserId(userId);
        message.setContent(content);
        message.setTime(new Date());
        return messageService.add(message);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllMessageByUserId")
    public ResultDto findAllMessageByUserId(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        return messageService.findAllMessageByUserId(userId);
    }
}
