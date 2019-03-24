package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityComment1;

public interface VoluntaryCommentService {
    ResultDto addComment(ActivityComment1 activityComment);

    ResultDto findCommentById(int id);

    ResultDto deleteComment(int id);

    ResultDto updateRead(int id);
}
