package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.GoodWelfare;

public interface GoodWelfareService {

    ResultDto addGoodWelfare(GoodWelfare goodWelfare);

    ResultDto deleteGoodWelfare(int id);

    ResultDto findAllGoodWelfare();

    ResultDto findGoodWelfareById(int id);

    ResultDto changeGoodWelfareById(GoodWelfare goodWelfare);

    ResultDto changeCoverById(int id,String cover);
}
