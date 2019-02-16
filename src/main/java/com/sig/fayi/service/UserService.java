package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    /*
     *@Author sig
     *@Description 查找所有用户测试
     *@Date 10:10 2019/1/27
     *@Param []
     *@return java.util.List<com.sig.fayi.entity.user>
     **/
    List<User> findAllUser();

    /*
     *@Author sig
     *@Description 按电话和密码添加用户
     *@Date 10:11 2019/1/27
     *@Param [phone, password, name]
     *@return com.sig.fayi.dto.ResultDto
     **/
    ResultDto addUserByPhonePsw(String phone, String password , String name);

    /*
     *@Author sig
     *@Description 检查电话密码是否正确
     *@Date 20:39 2019/1/28
     *@Param [phone, password]
     *@return com.sig.fayi.dto.ResultDto
     **/
    ResultDto checkPassword(String phone,String password);

    /*
     *@Author sig
     *@Description 通过电话查找用户
     *@Date 20:42 2019/2/1
     *@Param [phone]
     *@return com.sig.fayi.dto.ResultDto
     **/
    ResultDto findUserByPhone(String phone);
}
