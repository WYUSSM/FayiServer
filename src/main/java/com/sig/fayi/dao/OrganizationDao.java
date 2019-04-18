package com.sig.fayi.dao;

import com.sig.fayi.entity.Message;
import com.sig.fayi.entity.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    List<Organization> findOrganitionByLikeName(@Param("name") String name);

    Organization findOrganitionByPhone(@Param("phone")String phone);

    Organization findOrganitionByName(@Param("name") String name);

    List<Organization> organizationRank();

    Organization findOrganizationById(@Param("id") int id);


    int examine(@Param("organizationId") int organizationId,@Param("examineUser") int examineUser,@Param("examine_time") Date examine_time,@Param("flag") String flag);

    int updateProof(@Param("id") int id,@Param("handIdCard") String handIdCard,@Param("positiveImage") String positiveImage,@Param("negativeImage") String negativeImage,@Param("proofImage") String proofImage);

    List<Organization> findAllExmineOrganization();

    int changeHeadImage(@Param("headImage") String headImage,@Param("id") int id);

}
