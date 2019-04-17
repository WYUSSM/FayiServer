package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.SimpleVoluntary;


public interface VoluntaryService {
    ResultDto findAllVoluntary();

    ResultDto findAllSimpleVoluntary(String lat,String lng);

    ResultDto addVoluntary(SimpleVoluntary simpleVoluntary);

    ResultDto findVoluntaryById(int id);

    ResultDto findVoluntaryByUserId(int id);

    ResultDto findAllVoluntaryByOrgId(int id);

    ResultDto deleteVoluntary(int id);

    ResultDto editVoluntary(SimpleVoluntary simpleVoluntary);

    ResultDto findVoluntaryByTitle(String title,String lat,String lng);

    ResultDto findVoluntaryByDistrict(String province,String city,String district,String lat,String lng);
}
