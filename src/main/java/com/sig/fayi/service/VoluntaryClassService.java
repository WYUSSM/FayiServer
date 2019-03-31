package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.VoluntaryClass;

public interface VoluntaryClassService {

    ResultDto addVoluntaryClass(VoluntaryClass voluntaryClass);

    ResultDto deleteVoluntaryClass(int id);

    ResultDto findAllVoluntaryClass();

    ResultDto findVoluntaryClassById(int id);

    ResultDto changeVoluntaryClassById(VoluntaryClass voluntaryClass);

    ResultDto changeCoverById(int id,String cover);
}
