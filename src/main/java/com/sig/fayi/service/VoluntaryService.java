package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.SimpleVoluntary;


public interface VoluntaryService {
    ResultDto findAllVoluntary();

    ResultDto findAllSimpleVoluntary();

    ResultDto addVoluntary(SimpleVoluntary simpleVoluntary);
}
