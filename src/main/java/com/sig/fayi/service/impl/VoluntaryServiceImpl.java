package com.sig.fayi.service.impl;

import com.sig.fayi.dao.VoluntaryDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.SimpleVoluntary;
import com.sig.fayi.entity.Voluntary;
import com.sig.fayi.service.VoluntaryService;
import com.sig.fayi.utils.LocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntaryServiceImpl implements VoluntaryService {

    @Autowired
    private VoluntaryDao voluntaryDao;

    @Override
    public ResultDto findAllVoluntary(){
        List<Voluntary> voluntaryList=voluntaryDao.findAllVoluntary();
        if(voluntaryList!=null){
            return new ResultDto(200,"success",voluntaryList);
        }else{
            return new ResultDto(200,"nodata",null);
        }
    }

    @Override
    public ResultDto findAllSimpleVoluntary(String lat,String lng){
        List<SimpleVoluntary> simpleVoluntaries=voluntaryDao.findAllSimpleVoluntary();
        if(simpleVoluntaries!=null){
            if(lat==null||lng==null){
                for(SimpleVoluntary simpleVoluntary:simpleVoluntaries){
                    simpleVoluntary.setDistance("未获取到你的位置");
                }
            }else{
                for(SimpleVoluntary simpleVoluntary:simpleVoluntaries){
                    if(simpleVoluntary.getAddressLatitude()==null||simpleVoluntary.getAddressLongitude()==null){
                        simpleVoluntary.setDistance("志愿活动位置错误");
                    }else{
                        String distance= LocationUtil.getDistance(lng,lat,simpleVoluntary.getAddressLongitude(),simpleVoluntary.getAddressLatitude());
                        simpleVoluntary.setDistance(distance);
                    }
                }
            }
            return new ResultDto(200,"success",simpleVoluntaries);
        }else{
            return new ResultDto(200,"nodata",null);
        }
    }

    @Override
    public ResultDto addVoluntary(SimpleVoluntary simpleVoluntary){
        int count=voluntaryDao.addVoluntary(simpleVoluntary);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findVoluntaryById(int id){
        Voluntary voluntary=voluntaryDao.findVoluntaryById(id);
        if(voluntary!=null){
            return new ResultDto(200,"success",voluntary);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findVoluntaryByUserId(int id){
        List<SimpleVoluntary> simpleVoluntaries=voluntaryDao.findAllVoluntaryByUserId(id);
        if(simpleVoluntaries!=null){
            return new ResultDto(200,"success",simpleVoluntaries);
        }else {
            return new ResultDto(200,"nodata",null);
        }
    }

    @Override
    public ResultDto findAllVoluntaryByOrgId(int id){
        List<SimpleVoluntary> simpleVoluntaries=voluntaryDao.findAllVoluntaryByOrgId(id);
        if(simpleVoluntaries!=null){
            return new ResultDto(200,"success",simpleVoluntaries);
        }else {
            return new ResultDto(200,"nodata",null);
        }
    }

    @Override
    public ResultDto deleteVoluntary(int id){
        int count=voluntaryDao.deleteVoluntary(id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto editVoluntary(SimpleVoluntary simpleVoluntary){
        int count=voluntaryDao.editVoluntary(simpleVoluntary);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
