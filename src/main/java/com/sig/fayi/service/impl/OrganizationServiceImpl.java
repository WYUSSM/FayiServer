package com.sig.fayi.service.impl;

import com.sig.fayi.dao.OrganizationDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Organization;
import com.sig.fayi.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;
    /*
     *@Author sig
     *@Description 查找所有组织
     *@Date 23:04 2019/2/11
     *@Param []
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public List<Organization> findAllOrganition(){
//        List<Organization> organizations=organizationDao.findAllOrganition();
//        if(organizations.size()>0){
//            return new ResultDto(200,"success",organizations);
//        }else {
//            return new ResultDto(200,"nodata",null);
//        }
        return organizationDao.findAllOrganition();
    }

    /*
     *@Author sig
     *@Description 根据地址查找组织
     *@Date 23:12 2019/2/11
     *@Param [address]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto findOrganitionByAddress(String address){
        List<Organization> organizations=organizationDao.findOrganitionByAddress(address);
        if(organizations.size()>0){
            return new ResultDto(200,"success",organizations);
        }else {
            return new ResultDto(200,"nodata",null);
        }
    }

    /*
     *@Author sig
     *@Description 添加组织
     *@Date 23:12 2019/2/11
     *@Param [organization]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto addOrganition(Organization organization){
        Organization organization1=organizationDao.findOrganitionByName(organization.getOrganizationName());
        Organization organization2=organizationDao.findOrganitionByPhone(organization.getPhone());
        if(organization1!=null){
            return new ResultDto(200,"name_exit",null);
        }
        if(organization2!=null){
            return new ResultDto(200,"phone_exit",null);
        }
        if(organizationDao.addOrganition(organization)>0){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    /*
     *@Author sig
     *@Description 通过电话密码查找组织
     *@Date 23:14 2019/2/11
     *@Param [phone, password]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto findOrganitionByPhonePass(String phone,String password){
        Organization organization=organizationDao.findOrganitionByPhonePass(phone,password);
        if(organization!=null){
            return new ResultDto(200,"success",organization);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    public ResultDto findOrganitionByPhone(String phone){
        Organization organization=organizationDao.findOrganitionByPhone(phone);
        if(organization!=null){
            return new ResultDto(200,"success",organization);
        }else {
            return new ResultDto(200,"nodata",null);
        }
    }
}
