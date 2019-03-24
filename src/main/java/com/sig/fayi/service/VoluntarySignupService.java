package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivitySignUp;
import com.sig.fayi.entity.SignupPeople;

public interface VoluntarySignupService {
    ResultDto signupVoluntary(SignupPeople signupPeople);

    ResultDto quitVoluntary(int signupactivityId,int userId);

    ResultDto findAllSignupUserByActivityId(int id);
}
