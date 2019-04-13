package com.sig.fayi.dao;

import com.sig.fayi.entity.Message;
import com.sig.fayi.entity.Organization;
import com.sig.fayi.entity.OrganizationPeople;
import com.sig.fayi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrganizationPeopleDao {
    /*
     *@Author sig
     *@Description 加入组织
     *@Date 19:15 2019/3/7
     *@Param [organizationPeople]
     *@return int
     **/
    int signUpOrganization(@Param("organizationPeople") OrganizationPeople organizationPeople);

    int quitOrganization(@Param("id")int id);

    List<User> findAllUserByOrganizationId(@Param("organizationId") int organizationId);

    int quitOrganizationByTow(@Param("useId")int useId,@Param("organizationId") int organizationId);

    int updateFlag(@Param("useId")int useId, @Param("organizationId") int organizationId,@Param("signUp_time") Date signUp_time);

    int addPeopleNum(@Param("organizationId") int organizationId);

    int reducePeopleNum(@Param("organizationId") int organizationId);

    OrganizationPeople findOrganizationPeople(@Param("useId")int useId,@Param("organizationId") int organizationId);

    Organization findOrgByUserId(@Param("userId") int userId);

    int addMessage(@Param("message") Message message);

    List<User> findAllExmineUser(@Param("organizationId") int organizationId);
}
