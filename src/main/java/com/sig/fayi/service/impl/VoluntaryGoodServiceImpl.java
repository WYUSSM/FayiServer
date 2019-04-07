package com.sig.fayi.service.impl;

import com.sig.fayi.dao.VoluntaryGoodDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityGood;
import com.sig.fayi.service.VoluntaryGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntaryGoodServiceImpl implements VoluntaryGoodService {
    @Autowired
    private VoluntaryGoodDao voluntaryGoodDao;

    @Override
    public ResultDto addGood(ActivityGood activityGood){
        if(activityGood.getGooder()!=0){
            ActivityGood activityGood1=voluntaryGoodDao.findGoodByGooder(activityGood.getCommentId(),activityGood.getGooder());
            if(activityGood1!=null){
                return new ResultDto(200,"failure",null);
            }else {
                int count=voluntaryGoodDao.addGood(activityGood);
                if(count==1){
                    voluntaryGoodDao.addGoodCount(activityGood.getCommentId());
                    return new ResultDto(200,"success",null);
                }else {
                    return new ResultDto(200,"failure",null);
                }
            }
        }else {
            ActivityGood activityGood1=voluntaryGoodDao.findGoodByGooder1(activityGood.getCommentId(),activityGood.getGooder());
            if(activityGood1!=null){
                return new ResultDto(200,"failure",null);
            }else {
                int count=voluntaryGoodDao.addGood(activityGood);
                if(count==1){
                    voluntaryGoodDao.addGoodCount(activityGood.getCommentId());
                    return new ResultDto(200,"success",null);
                }else {
                    return new ResultDto(200,"failure",null);
                }
            }
        }
    }

    @Override
    public ResultDto deleteGood(int goodId,int commentId){
        int count=voluntaryGoodDao.deleteGood(goodId);
        if(count==1){
            voluntaryGoodDao.reduceGoodCount(commentId);
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }
}
