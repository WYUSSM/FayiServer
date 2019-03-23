package com.sig.fayi.dao;

import com.sig.fayi.entity.ActivityComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoluntaryCommentDao {
    List<ActivityComment> findCommentById(@Param("id") int id);

    int addComment(@Param("activityComment") ActivityComment activityComment);


}
