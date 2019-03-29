package com.sig.fayi.service.impl;

import com.sig.fayi.dao.GoodWelfareDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.GoodWelfare;
import com.sig.fayi.service.GoodWelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodWelfareServiceImpl implements GoodWelfareService {

    @Autowired
    private GoodWelfareDao goodWelfareDao;

    @Override
    public ResultDto addGoodWelfare(GoodWelfare goodWelfare){
        int count=goodWelfareDao.addGoodWelfare(goodWelfare);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto deleteGoodWelfare(int id){
        int count=goodWelfareDao.deleteGoodWelfare(id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAllGoodWelfare(){
        List<GoodWelfare> goodWelfares=goodWelfareDao.findAllGoodWelfare();
        if(goodWelfares!=null){
            return new ResultDto(200,"success",goodWelfares);
        }else {
            return new ResultDto(200,"nodata",null);
        }
    }

    @Override
    public ResultDto findGoodWelfareById(int id){
        GoodWelfare goodWelfare=goodWelfareDao.findGoodWelfareById(id);
        if(goodWelfare!=null){
            return new ResultDto(200,"success",goodWelfare);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto changeGoodWelfareById(GoodWelfare goodWelfare){
        int count=goodWelfareDao.changeGoodWelfareById(goodWelfare);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto changeCoverById(int id,String cover){
        int count=goodWelfareDao.changeCoverById(id,cover);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
