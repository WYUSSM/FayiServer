package com.sig.fayi.dao;

import com.sig.fayi.entity.OrganizationPeople;
import com.sig.fayi.entity.User;
import org.apache.ibatis.annotations.Param;

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
}
