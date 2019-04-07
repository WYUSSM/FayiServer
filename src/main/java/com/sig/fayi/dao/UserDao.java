package com.sig.fayi.dao;

import com.sig.fayi.entity.SimpleVoluntary;
import com.sig.fayi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserDao {//添加UserDao的test时，选中类名UserDao，右键go to->test-创建->选择Junit4,选择添加的测试方法，finish
    /*
     *@Author sig
     *@Description 测试
     *@Date 23:44 2019/1/26
     *@Param []
     *@return java.util.List<com.sig.fayi.entity.user>
     **/
    List<User> findAllUser();

    User findUserById(@Param("id") int id);

    /*
     *@Author sig
     *@Description 插入user_tab表
     *@Date 10:16 2019/1/27
     *@Param [phone, password, name, registerTime]
     *@return int
     **/
    int addUserByPhonePsw(@Param("phone") String phone, @Param("password") String password, @Param("name") String name, @Param("registerTime") Date registerTime);

    /*
     *@Author sig
     *@Description 按电话查找用户
     *@Date 10:22 2019/1/27
     *@Param [phone]
     *@return com.sig.fayi.entity.user
     **/
    User findUserByPhone(@Param("phone")String phone);

    /*
     *@Author sig
     *@Description 通过phone检验密码是否正确
     *@Date 11:18 2019/1/27
     *@Param [phone, password]
     *@return com.sig.fayi.entity.user 正确返回user，失败返回null
     **/
    User checkPassword(@Param("phone") String phone,@Param("password") String password);

    /*
     *@Author sig
     *@Description 通过id修改用户基本信息
     *@Date 10:53 2019/3/1
     *@Param [user]
     *@return int
     **/
    int changeUserById(@Param("user") User user);

    /**
     * 通过id修改headimage
     *
     * @param id
     * @param headIamge
     * @return 更改成功返回1，没有则0
     */
    int changeHeadImageById(@Param("id") int id , @Param("headImage") String headIamge);

    /**
     * 通过id修改headimage
     *
     * @param id
     * @param backgroundImage
     * @return 更改成功返回1，没有则0
     */
    int changeBackgroundImageById(@Param("id") int id , @Param("backgroundImage") String backgroundImage);

    User findUserByName(@Param("name") String name);

    int changePhoneById(@Param("id") int id,@Param("phone") String phone);

    List<User> userRank();



}
