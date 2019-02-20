package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Essay;

public interface EssayService {

    ResultDto findAllEssay();

    ResultDto insertEssay(Essay essay);
}
