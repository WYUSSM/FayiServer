package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.IdCard;

import java.util.Date;

public interface IdCardService {

    ResultDto upladIdCard(IdCard idCard,int userId);

    ResultDto changeIdCard(IdCard idCard,int userId);

    ResultDto findAllUser();

    ResultDto examineIdCard(int id, int examineUser, Date examine_time,String flag);


}
