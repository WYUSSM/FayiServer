package com.sig.fayi.dao;

import com.sig.fayi.entity.IdCard;
import com.sig.fayi.entity.UserIdcard;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IdCardDao {

    int upladIdCard(@Param("idCard") IdCard idCard);

    int changeIdCard(@Param("idCard") IdCard idCard);

    int changeUserIdcard(@Param("id") int id,@Param("idCard") String idCard);

    List<UserIdcard> findAllUser();

    int examineIdCard(@Param("id") int id,@Param("examineUser") int examineUser,@Param("examine_time") Date examine_time);




}
