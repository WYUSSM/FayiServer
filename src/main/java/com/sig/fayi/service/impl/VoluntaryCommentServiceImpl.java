package com.sig.fayi.service.impl;

import com.sig.fayi.dao.VoluntaryCommentDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityComment;
import com.sig.fayi.entity.ActivityComment1;
import com.sig.fayi.service.VoluntaryCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntaryCommentServiceImpl implements VoluntaryCommentService {

    @Autowired
    private VoluntaryCommentDao voluntaryCommentDao;

    @Override
    public ResultDto addComment(ActivityComment1 activityComment){
        int count=voluntaryCommentDao.addComment(activityComment);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findCommentById(int id){
        List<ActivityComment> activityComments=voluntaryCommentDao.findCommentById(id);
        if(activityComments==null){
            return new ResultDto(200,"failure",null);
        }else {
            updateRead(id);
            return new ResultDto(200,"success",activityComments);
        }
    }

    @Override
    public ResultDto deleteComment(int id){
        int count=voluntaryCommentDao.deleteComment(id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto updateRead(int id){
        int count=voluntaryCommentDao.updateRead(id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }
}
