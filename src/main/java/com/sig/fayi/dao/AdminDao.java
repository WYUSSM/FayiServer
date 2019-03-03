package com.sig.fayi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AdminDao {
    int addUserByPhonePsw(@Param("phone") String phone, @Param("password") String password, @Param("name") String name, @Param("registerTime") Date registerTime);
}
