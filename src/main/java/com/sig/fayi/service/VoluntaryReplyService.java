package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityReply1;

public interface VoluntaryReplyService {
    ResultDto addReply(ActivityReply1 activityReply);

    ResultDto deleteReply(int replyId,int commentId);
}
