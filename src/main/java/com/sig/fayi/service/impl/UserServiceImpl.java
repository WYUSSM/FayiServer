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
     * 查找所有User
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
        User user1=userDao.findUserByName(name);
        if (user != null) {
            return  new ResultDto(200, "name_exist", null);
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

    /*
     *@Author sig
     *@Description 通过id修改基本信息
     *@Date 11:22 2019/3/1
     *@Param [user]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto changeUserById(User user){
        int count=userDao.changeUserById(user);
        if(count!=0){
            return new ResultDto(200,"success",userDao.findUserById(user.getId()));
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    /*
     *@Author sig
     *@Description 修改头像
     *@Date 12:12 2019/3/1
     *@Param [id, headIamge]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto changeHeadImageById(int id , String headIamge){
        int count=userDao.changeHeadImageById(id,headIamge);
        if(count!=0){
            return new ResultDto(200,"success",userDao.findUserById(id));
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    /*
     *@Author sig
     *@Description 修改背景图片
     *@Date 12:12 2019/3/1
     *@Param [id, backgroundImage]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto changeBackgroundImageById(int id , String backgroundImage){
        int count=userDao.changeBackgroundImageById(id,backgroundImage);
        if(count!=0){
            return new ResultDto(200,"success",userDao.findUserById(id));
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    /*
     *@Author sig
     *@Description 修改电话
     *@Date 13:16 2019/3/6
     *@Param [id, phone]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto changePhoneById(int id,String phone){
        int count=userDao.changePhoneById(id,phone);
        if(count!=0){
            return new ResultDto(200,"success",userDao.findUserById(id));
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto userRank(){
        List<User> users=userDao.userRank();
        if(users!=null){
            return new ResultDto(200,"success",users);
        }else {
            return new ResultDto(200,"nodata",null);
        }
    }

    @Override
    public ResultDto findUserById(int id){
        User user=userDao.findUserById(id);
        if(user!=null){
            return new ResultDto(200,"success",user);
        }else{
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto findRankByUserId(int userId){
        List<User> users=userDao.userRank();
        if(users!=null){
            for(int i=0;i<users.size();i++){
                if(users.get(i).getId()==userId){
                    return new ResultDto(200,"success",Integer.toString(i+1));
                }
            }
            return new ResultDto(200,"failure",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }
}
