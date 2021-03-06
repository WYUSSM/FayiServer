package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.SignupPeople;
import com.sig.fayi.service.VoluntarySignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/voluntarySignup")
public class VoluntarySignupController {
    @Autowired
    private VoluntarySignupService voluntarySignupService;

    @ResponseBody
    @RequestMapping(value = "/signupVoluntary")
    public ResultDto signupVoluntary(HttpServletRequest request){
        int signupactivityId=Integer.parseInt(request.getParameter("signupactivityId"));
        int userId=Integer.parseInt(request.getParameter("userId"));
        SignupPeople signupPeople=new SignupPeople();
        signupPeople.setSignupactivityId(signupactivityId);
        signupPeople.setUserId(userId);
        signupPeople.setSignUpTime(new Date());
        return voluntarySignupService.signupVoluntary(signupPeople);
    }

    @ResponseBody
    @RequestMapping(value = "/quitVoluntary")
    public ResultDto quitVoluntary(HttpServletRequest request){
        int signupactivityId=Integer.parseInt(request.getParameter("signupactivityId"));
        int userId=Integer.parseInt(request.getParameter("userId"));
        return voluntarySignupService.quitVoluntary(signupactivityId,userId);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllSignupUserByActivityId")
    public ResultDto findAllSignupUserByActivityId(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntarySignupService.findAllSignupUserByActivityId(id);
    }

    @ResponseBody
    @RequestMapping(value = "/signIn")
    public ResultDto signIn(HttpServletRequest request){
        int signupactivityId=Integer.parseInt(request.getParameter("signupactivityId"));
        int userId=Integer.parseInt(request.getParameter("userId"));
        return voluntarySignupService.signIn(signupactivityId,userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getQRcode")
    public ResultDto getQRcode(HttpServletRequest request){
        int activityId=Integer.parseInt(request.getParameter("activityId"));
        return voluntarySignupService.getQRcode(activityId,request);
    }

    @ResponseBody
    @RequestMapping(value = "/findSigninPeople")
    public ResultDto findSigninPeople(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntarySignupService.findSigninPeople(id);
    }

    @ResponseBody
    @RequestMapping(value = "/findNotSigninPeople")
    public ResultDto findNotSigninPeople(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return voluntarySignupService.findNotSigninPeople(id);
    }
}
