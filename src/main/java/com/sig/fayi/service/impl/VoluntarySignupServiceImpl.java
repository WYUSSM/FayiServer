package com.sig.fayi.service.impl;

import com.google.zxing.WriterException;
import com.sig.fayi.dao.VoluntarySignupDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.*;
import com.sig.fayi.service.VoluntarySignupService;
import com.sig.fayi.utils.QRCodeUtils;
import com.sig.fayi.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class VoluntarySignupServiceImpl implements VoluntarySignupService {
    @Autowired
    private VoluntarySignupDao voluntarySignupDao;

    @Override
    public ResultDto signupVoluntary(SignupPeople signupPeople){
        SimpleVoluntary simpleVoluntary=voluntarySignupDao.findVoluntaryById(signupPeople.getSignupactivityId());
        if(simpleVoluntary.getPeopleNum()>simpleVoluntary.getSignUpNum()){
            int count=voluntarySignupDao.signupVoluntary(signupPeople);
            if(count==1){
                voluntarySignupDao.addSignUpPeopleNum(signupPeople.getSignupactivityId());
                Message message=new Message();
                message.setOrganizationId(1);
                message.setUserId(signupPeople.getUserId());
                message.setContent("你已成功报名活动："+simpleVoluntary.getTitle()+",活动时间为："+TimeUtil.dateToStringNoS(simpleVoluntary.getStartTime())+"至"+TimeUtil.dateToStringNoS(simpleVoluntary.getEndTime())+",活动地点为:"+
                        simpleVoluntary.getAddress()+",可以进入活动详情点击地址进入导航,请按时到场并根据活动负责人二维码完成签到哦。");
                message.setTime(new Date());
                voluntarySignupDao.addMessage(message);
                return new ResultDto(200,"success",null);
            }else{
                return new ResultDto(200,"failure",null);
            }
        }else {
            return new ResultDto(200,"people_enough",null);
        }
    }

    @Override
    public ResultDto quitVoluntary(int signupactivityId,int userId){
        int count=voluntarySignupDao.quitVoluntary(signupactivityId,userId);
        if(count==1){
            voluntarySignupDao.reduceSignUpPeopleNum(signupactivityId);
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAllSignupUserByActivityId(int id){
        List<User> userList=voluntarySignupDao.findAllSignupUserByActivityId(id);
        if(userList==null){
            return new ResultDto(200,"nodata",null);
        }else {
            return new ResultDto(200,"success",userList);
        }
    }

    @Override
    public ResultDto signIn(int signupactivityId,int userId){
        SignupPeople signupPeople=voluntarySignupDao.findActivitySignUp(signupactivityId,userId);
        if(signupPeople!=null){
            if(signupPeople.getSignInFlag().equals("签到成功")){
                return new ResultDto(200,"signinover",null);
            }
        }
        int count=voluntarySignupDao.signIn(signupactivityId,userId,new Date());
        if(count==1){
            SimpleVoluntary simpleVoluntary=voluntarySignupDao.findVoluntaryById(signupactivityId);
            if(simpleVoluntary!=null){
                double voluntaryTime=TimeUtil.getVoluntaryTime(simpleVoluntary.getStartTime(),simpleVoluntary.getEndTime());
                voluntarySignupDao.addVolunteerTime(voluntaryTime,userId);
            }
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }


    @Override
    public ResultDto getQRcode(int activityId, HttpServletRequest request){
        String filePath = request.getSession().getServletContext().getRealPath("/") + "img/voluntary"+Integer.toString(activityId)+".png";
        try {
            QRCodeUtils.create(Integer.toString(activityId)+"*"+ TimeUtil.dateToString(new Date()), filePath);
            return new ResultDto(200,"success","voluntary"+Integer.toString(activityId)+".png");
        } catch (WriterException e) {
            e.printStackTrace();
            return new ResultDto(200,"failure",null);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findSigninPeople(int id){
        List<User> userList=voluntarySignupDao.findSigninPeople(id);
        if(userList==null){
            return new ResultDto(200,"failure",null);
        }else {
            return new ResultDto(200,"success",userList);
        }
    }


    @Override
    public ResultDto findNotSigninPeople(int id){
        List<User> userList=voluntarySignupDao.findNotSigninPeople(id);
        if(userList==null){
            return new ResultDto(200,"failure",null);
        }else {
            return new ResultDto(200,"success",userList);
        }
    }
}
