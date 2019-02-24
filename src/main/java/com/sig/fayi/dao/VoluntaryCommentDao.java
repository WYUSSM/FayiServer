package com.sig.fayi.dao;

import com.sig.fayi.entity.ActivityComment;

import java.util.List;

public interface VoluntaryCommentDao {
    List<ActivityComment> findCommentById(int id);
}
