package com.sig.fayi.service.impl;

import com.sig.fayi.dao.MessageDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Message;
import com.sig.fayi.entity.Message1;
import com.sig.fayi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public ResultDto add(Message message){
        int count=messageDao.addMessage(message);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAllMessageByUserId(int userId){
        List<Message1> message1List=messageDao.findAllMessageByUserId(userId);
        if(message1List!=null){
            return new ResultDto(200,"success",message1List);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }
}
