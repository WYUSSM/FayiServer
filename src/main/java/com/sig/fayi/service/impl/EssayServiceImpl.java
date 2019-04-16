package com.sig.fayi.service.impl;

import com.sig.fayi.dao.EssayDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Essay;
import com.sig.fayi.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayDao essayDao;

    @Override
    public ResultDto findAllEssay(){
        List<Essay> essays=essayDao.findAllEssay();
        if(essays!=null){
            return new ResultDto(200,"success",essays);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto insertEssay(Essay essay){
        int count=essayDao.insertEssay(essay);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public  ResultDto changeEssayById(Essay essay){
        int count = essayDao.changeEssayById(essay);
        if(count==1){
            return new ResultDto(200,"success",null);
        }
        else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public  ResultDto changeCoverById(String cover,int id){
        int count = essayDao.changeCoverById(cover,id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }
        else{
            return new ResultDto(200,"failure",null);
        }
    }

    public  ResultDto deleteEssayById(int id){
        int count = essayDao.deleteEssayById(id);
        if(count ==1){
            return  new ResultDto(200,"success",null);
        }
        else{
            return  new ResultDto(200,"failure",null);
        }
    }

    public ResultDto findEssayById(int id){
        Essay essay=essayDao.findEssayById(id);
        if(essay==null){
            return new ResultDto(200,"failure",null);
        }else {
            return new ResultDto(200,"success",essay);
        }
    }
}
