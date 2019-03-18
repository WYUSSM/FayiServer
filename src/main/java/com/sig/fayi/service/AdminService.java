package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;

import java.util.Date;

public interface AdminService {
    ResultDto addAdmin(String phone, String password, String name,Date register_time);

    ResultDto findAdminByPhone(String phone);

    ResultDto findAdminById(int id);

    ResultDto findAdminByPhonePassword(String phone,String password);
}
