package com.sig.fayi.dao;

import com.sig.fayi.entity.ActivityComment;
import com.sig.fayi.entity.ActivityComment1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoluntaryCommentDao {
    List<ActivityComment> findCommentById(@Param("id") int id);

    int addComment(@Param("activityComment") ActivityComment1 activityComment);

    int deleteComment(@Param("id") int id);

    int updateRead(@Param("id")int id);
}
