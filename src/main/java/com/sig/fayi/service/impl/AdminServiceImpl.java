package com.sig.fayi.service.impl;

import com.sig.fayi.dao.AdminDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Admin;
import com.sig.fayi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public ResultDto addAdmin(String phone, String password, String name, Date register_time){
        int count=adminDao.addAdmin(phone,password,name,register_time);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAdminByPhone(String phone){
        Admin admin=adminDao.findAdminByPhone(phone);
        if(admin!=null){
            return new ResultDto(200,"success",admin);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAdminById(int id){
        Admin admin=adminDao.findAdminById(id);
        if(admin!=null){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findAdminByPhonePassword(String phone,String password){
        Admin admin=adminDao.findAdminByPhonePassword(phone,password);
        if(admin!=null){
            return new ResultDto(200,"success",admin);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}
