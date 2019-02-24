package com.sig.fayi.dao;

import com.sig.fayi.entity.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationDao {

    /*
     *@Author sig
     *@Description 查找所有组织
     *@Date 19:28 2019/2/11
     *@Param []
     *@return java.util.List<com.sig.fayi.entity.Organization>
     **/
    List<Organization> findAllOrganition();

    /*
     *@Author sig
     *@Description 通过地址查找组织
     *@Date 19:30 2019/2/11
     *@Param []
     *@return java.util.List<com.sig.fayi.entity.Organization>
     **/
    List<Organization> findOrganitionByAddress(@Param("address") String address);

    /*
     *@Author sig
     *@Description 添加组织
     *@Date 20:01 2019/2/11
     *@Param [organization]
     *@return int
     **/
    int addOrganition(@Param("organization") Organization organization);


    Organization findOrganitionByPhonePass(@Param("phone") String phone,@Param("password") String password);
}