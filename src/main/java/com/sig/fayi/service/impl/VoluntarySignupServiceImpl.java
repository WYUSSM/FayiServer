package com.sig.fayi.service.impl;

import com.sig.fayi.dao.VoluntarySignupDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivitySignUp;
import com.sig.fayi.entity.SignupPeople;
import com.sig.fayi.entity.User;
import com.sig.fayi.service.VoluntarySignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarySignupServiceImpl implements VoluntarySignupService {
    @Autowired
    private VoluntarySignupDao voluntarySignupDao;

    @Override
    public ResultDto signupVoluntary(SignupPeople signupPeople){
        int count=voluntarySignupDao.signupVoluntary(signupPeople);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto quitVoluntary(int signupactivityId,int userId){
        int count=voluntarySignupDao.quitVoluntary(signupactivityId,userId);
        if(count==1){
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

}
