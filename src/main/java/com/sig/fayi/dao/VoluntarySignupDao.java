package com.sig.fayi.dao;

import com.sig.fayi.entity.ActivitySignUp;
import com.sig.fayi.entity.SignupPeople;
import com.sig.fayi.entity.SimpleVoluntary;
import com.sig.fayi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoluntarySignupDao {
    int signupVoluntary(@Param("signupPeople") SignupPeople signupPeople);

    int quitVoluntary(@Param("signupactivityId") int signupactivityId,@Param("userId") int userId);

    List<User> findAllSignupUserByActivityId(@Param("id") int id);

    SignupPeople findActivitySignUp(@Param("signupactivityId") int signupactivityId,@Param("userId") int userId);

    int addSignUpPeopleNum(@Param("signupactivityId")int signupactivityId);

    int reduceSignUpPeopleNum(@Param("signupactivityId")int signupactivityId);

    SimpleVoluntary findVoluntaryById(@Param("id") int id);
}
