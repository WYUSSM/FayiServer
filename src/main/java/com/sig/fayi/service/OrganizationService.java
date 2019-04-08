package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Organization;

import java.util.Date;
import java.util.List;

public interface OrganizationService {

    /*
     *@Author sig
     *@Description 查找所有组织
     *@Date 20:19 2019/2/11
     *@Param []
     *@return com.sig.fayi.dto.ResultDto
     **/
    List<Organization> findAllOrganition();

    /*
     *@Author sig
     *@Description 根据地址查找组织
     *@Date 20:19 2019/2/11
     *@Param [address]
     *@return com.sig.fayi.dto.ResultDto
     **/
    ResultDto findOrganitionByAddress(String address);

    /*
     *@Author sig
     *@Description 添加组织
     *@Date 20:19 2019/2/11
     *@Param [organization]
     *@return com.sig.fayi.dto.ResultDto
     **/
    ResultDto addOrganition(Organization organization);

    /*
     *@Author sig
     *@Description 通过电话密码查找组织
     *@Date 20:19 2019/2/11
     *@Param [phone, password]
     *@return com.sig.fayi.dto.ResultDto
     **/
    ResultDto findOrganitionByPhonePass(String phone,String password);


    ResultDto findOrganitionByPhone(String phone);

    ResultDto organizationRank();

    ResultDto findOrganizationById(int id);

    ResultDto examine(int organizationId, int examineUser, Date examine_time, String flag);

    ResultDto updateProof(int id,String handIdCard,String positiveImage,String negativeImage,String proofImage);


}
