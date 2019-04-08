package com.sig.fayi.service.impl;

import com.sig.fayi.dao.IdCardDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.IdCard;
import com.sig.fayi.entity.UserIdcard;
import com.sig.fayi.service.IdCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IdCardServiceImpl implements IdCardService {
    @Autowired
    private IdCardDao idCardDao;

    @Override
    public ResultDto upladIdCard(IdCard idCard,int userId){
        int count=idCardDao.upladIdCard(idCard);
        if(count==1){
            idCardDao.changeUserIdcard(userId,idCard.getIdCard());
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto changeIdCard(IdCard idCard,int userId){
        int count=idCardDao.changeIdCard(idCard);
        if(count==1){
            if(idCard.getIdCard()!=null){
                idCardDao.changeUserIdcard(userId,idCard.getIdCard());
            }
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAllUser(){
        List<UserIdcard> userIdcards=idCardDao.findAllUser();
        if(userIdcards!=null){
            return new ResultDto(200,"success",userIdcards);
        }else{
            return new ResultDto(200,"nodata",null);
        }
    }

    @Override
    public ResultDto examineIdCard(int id, int examineUser, Date examine_time,String flag){
        int count=idCardDao.examineIdCard(id,examineUser,examine_time,flag);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
