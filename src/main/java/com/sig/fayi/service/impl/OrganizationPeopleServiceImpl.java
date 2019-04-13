package com.sig.fayi.service.impl;

import com.sig.fayi.dao.OrganizationPeopleDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Message;
import com.sig.fayi.entity.Organization;
import com.sig.fayi.entity.OrganizationPeople;
import com.sig.fayi.entity.User;
import com.sig.fayi.service.OrganizationPeopleService;
import com.sig.fayi.service.OrganizationService;
import com.sig.fayi.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrganizationPeopleServiceImpl implements OrganizationPeopleService {
    @Autowired
    private OrganizationPeopleDao organizationPeopleDao;

    @Override
    public ResultDto joinOrganization(OrganizationPeople organizationPeople){
        Organization organization=organizationPeopleDao.findOrgByUserId(organizationPeople.getUserId());
        if(organization!=null){
            return new ResultDto(200,"havedorg",null);
        }else {
            int count=organizationPeopleDao.signUpOrganization(organizationPeople);
            if(count==1){
                return new ResultDto(200,"success",null);
            }else {
                return new ResultDto(200,"failure",null);
            }
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
            organizationPeopleDao.reducePeopleNum(organizationId);
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

    @Override
    public ResultDto findOrganizationPeople(int useId,int organizationId){
        OrganizationPeople organizationPeople=organizationPeopleDao.findOrganizationPeople(useId,organizationId);
        if(organizationPeople!=null){
            if(organizationPeople.getFlag().equals("审核中")){
                return new ResultDto(200,"examineing",organizationPeople);
            }else if(organizationPeople.getFlag().equals("审核通过")){
                return new ResultDto(200,"examineover",organizationPeople);
            }else {
                return new ResultDto(200,"failure",organizationPeople);
            }
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto examine(int useId,int organizationId,String flag){
        if(flag.equals("审核通过")){
            int count=organizationPeopleDao.updateFlag(useId,organizationId,new Date());
            if(count==1){
                organizationPeopleDao.addPeopleNum(organizationId);
                Message message=new Message();
                message.setOrganizationId(organizationId);
                message.setUserId(useId);
                message.setContent("你已成功加入本组织！");
                message.setTime(new Date());
                organizationPeopleDao.addMessage(message);
                return new ResultDto(200,"success",null);
            }else {
                return new ResultDto(200,"failure",null);
            }
        }else {
            int count=organizationPeopleDao.quitOrganizationByTow(useId,organizationId);
            if(count==1){
                organizationPeopleDao.reducePeopleNum(organizationId);
                return new ResultDto(200,"success",null);
            }else {
                return new ResultDto(200,"failure",null);
            }
        }
    }

    @Override
    public ResultDto findOrgByUserId(int userId){
        Organization organization=organizationPeopleDao.findOrgByUserId(userId);
        if(organization==null){
            return new ResultDto(200,"noorg",null);
        }else {
            return new ResultDto(200,"success",organization);
        }
    }

    @Override
    public ResultDto findAllExmineUser(int organizationId){
        List<User> userList=organizationPeopleDao.findAllExmineUser(organizationId);
        if(userList==null){
            return new ResultDto(200,"failure",null);
        }else {
            return new ResultDto(200,"success",userList);
        }
    }
}
