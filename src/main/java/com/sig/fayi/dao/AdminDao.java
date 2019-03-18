package com.sig.fayi.dao;

import com.sig.fayi.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AdminDao {
    int addAdmin(@Param("phone") String phone, @Param("password") String password, @Param("name") String name, @Param("registerTime") Date registerTime);

    Admin findAdminByPhone(@Param("phone")String phone);

    Admin findAdminById(@Param("id")int id);

    Admin findAdminByPhonePassword(@Param("phone") String phone,@Param("password")String password);
}
