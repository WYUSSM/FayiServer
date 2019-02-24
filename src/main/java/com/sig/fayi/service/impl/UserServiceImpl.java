package com.sig.fayi.service.impl;

import com.sig.fayi.dao.UserDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.User;
import com.sig.fayi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service  //添加UserService的test时，选中类名UserServiceImpl，右键go to->test-创建->选择Junit4,选择添加的测试方法，finish
public class UserServiceImpl implements UserService {
    //注入Dao实现类依赖
    //    @Resource
    @Autowired
    private UserDao userDao;
    /**
     * 查找所有User，并按年龄降序排序好
     * @return
     */
    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    /*
     *@Author sig
     *@Description 按电话和密码添加用户
     *@Date 10:13 2019/1/27
     *@Param [phone, password, name]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto addUserByPhonePsw(String phone, String password, String name) {
        //先判断手机号是否已被注册
        User user = userDao.findUserByPhone(phone);
        if (user != null) {
            return  new ResultDto(200, "phone_exist", null);
        }
        //手机号未被注册，进行注册，且记录注册时间
        if (userDao.addUserByPhonePsw(phone, password, name ,new Date()) == 1) {
            return new ResultDto(200, "success", null);
        }
        return new ResultDto(200, "failure", null);
    }
    
    /*
     *@Author sig
     *@Description 检查电话密码是否正确
     *@Date 11:25 2019/1/27
     *@Param [phone, password]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto checkPassword(String phone,String password){
        User user=userDao.checkPassword(phone,password);
        if(user!=null){
            return new ResultDto(200,"success",user);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    /*
     *@Author sig
     *@Description 通过电话查找用户
     *@Date 20:41 2019/2/1
     *@Param [phone]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto findUserByPhone(String phone){
        User user=userDao.findUserByPhone(phone);
        if(user!=null){
            return new ResultDto(200,"success",user);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }
}