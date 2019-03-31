package com.sig.fayi.service.impl;

import com.sig.fayi.dao.VoluntaryClassDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.VoluntaryClass;
import com.sig.fayi.service.VoluntaryClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntaryClassServiceImpl implements VoluntaryClassService {

    @Autowired
    private VoluntaryClassDao voluntaryClassDao;

    @Override
    public ResultDto addVoluntaryClass(VoluntaryClass voluntaryClass){
        int count=voluntaryClassDao.addVoluntaryClass(voluntaryClass);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto deleteVoluntaryClass(int id){
        int count=voluntaryClassDao.deleteVoluntaryClass(id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAllVoluntaryClass(){
        List<VoluntaryClass> voluntaryClasses=voluntaryClassDao.findAllVoluntaryClass();
        if(voluntaryClasses!=null){
            return new ResultDto(200,"success",voluntaryClasses);
        }else {
            return new ResultDto(200,"nodata",null);
        }
    }

    @Override
    public ResultDto findVoluntaryClassById(int id){
        VoluntaryClass voluntaryClass=voluntaryClassDao.findVoluntaryClassById(id);
        if(voluntaryClass!=null){
            return new ResultDto(200,"success",voluntaryClass);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto changeVoluntaryClassById(VoluntaryClass voluntaryClass){
        int count=voluntaryClassDao.changeVoluntaryClassById(voluntaryClass);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto changeCoverById(int id,String cover){
        int count=voluntaryClassDao.changeCoverById(id,cover);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
