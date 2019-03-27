package com.sig.fayi.dao;

import com.sig.fayi.entity.ActivityReply1;
import org.apache.ibatis.annotations.Param;

public interface VoluntaryReplyDao {
    int addReply(@Param("activityReply") ActivityReply1 activityReply);

    int deleteReply(@Param("id") int id);

    int addReplyCount(@Param("id") int id);

    int reduceReplyCount(@Param("id") int id);
}
