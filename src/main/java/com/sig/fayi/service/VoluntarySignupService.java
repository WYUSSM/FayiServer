package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivitySignUp;
import com.sig.fayi.entity.SignupPeople;

import javax.servlet.http.HttpServletRequest;

public interface VoluntarySignupService {
    ResultDto signupVoluntary(SignupPeople signupPeople);

    ResultDto quitVoluntary(int signupactivityId,int userId);

    ResultDto findAllSignupUserByActivityId(int id);

    ResultDto signIn(int signupactivityId,int userId);

    ResultDto getQRcode(int activityId, HttpServletRequest request);

    ResultDto findSigninPeople(int id);

    ResultDto findNotSigninPeople(int id);
}
