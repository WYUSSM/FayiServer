package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.ActivityGood;

public interface VoluntaryGoodService {
    ResultDto addGood(ActivityGood activityGood);

    ResultDto deleteGood(int goodId,int commentId);
}
