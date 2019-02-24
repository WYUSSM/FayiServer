package com.sig.fayi.service.impl;

import com.sig.fayi.dao.VoluntaryDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Voluntary;
import com.sig.fayi.service.VoluntaryService;
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
            return new ResultDto(200,"failure",null);
        }
    }
}
