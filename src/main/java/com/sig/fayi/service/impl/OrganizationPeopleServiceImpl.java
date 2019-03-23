package com.sig.fayi.service.impl;

import com.sig.fayi.dao.OrganizationPeopleDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.OrganizationPeople;
import com.sig.fayi.entity.User;
import com.sig.fayi.service.OrganizationPeopleService;
import com.sig.fayi.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationPeopleServiceImpl implements OrganizationPeopleService {
    @Autowired
    private OrganizationPeopleDao organizationPeopleDao;

    @Override
    public ResultDto joinOrganization(OrganizationPeople organizationPeople){
        int count=organizationPeopleDao.signUpOrganization(organizationPeople);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto quitOrganizationById(int id){
        int count=organizationPeopleDao.quitOrganization(id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto quitOrganization(int userId,int organizationId){
        int count=organizationPeopleDao.quitOrganizationByTow(userId,organizationId);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAllUserByOrganizationId(int organizationId){
        List<User> userList=organizationPeopleDao.findAllUserByOrganizationId(organizationId);
        if(userList==null){
            return new ResultDto(200,"nodata",null);
        }else {
            return new ResultDto(200,"success",userList);
        }
    }
}
