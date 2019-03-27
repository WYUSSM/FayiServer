package com.sig.fayi.service.impl;

import com.sig.fayi.dao.VoluntaryReplyDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityReply1;
import com.sig.fayi.service.VoluntaryReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntaryReplyServiceImpl implements VoluntaryReplyService {
    @Autowired
    private VoluntaryReplyDao voluntaryReplyDao;

    @Override
    public ResultDto addReply(ActivityReply1 activityReply){
        int count=voluntaryReplyDao.addReply(activityReply);
        if(count==1){
            voluntaryReplyDao.addReplyCount(activityReply.getCommentId());
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto deleteReply(int replyId,int commentId){
        int count=voluntaryReplyDao.deleteReply(replyId);
        if(count==1){
            voluntaryReplyDao.reduceReplyCount(commentId);
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }
}
