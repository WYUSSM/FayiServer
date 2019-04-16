package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Essay;

public interface EssayService {

    ResultDto findAllEssay();

    ResultDto insertEssay(Essay essay);

    //通过id修改文章
    ResultDto changeEssayById(Essay essay);

    ResultDto changeCoverById(String cover,int id);

    ResultDto deleteEssayById(int id);

    ResultDto findEssayById(int id);
}
