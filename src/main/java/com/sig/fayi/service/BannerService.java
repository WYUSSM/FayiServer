package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.HomeBanner;

public interface BannerService {
    /*
     *@Author sig
     *@Description 查找所有展示对象
     *@Date 16:14 2019/2/5
     *@Param []
     *@return com.sig.fayi.dto.ResultDto
     **/
    ResultDto findAllBanner();
    
    /*
     *@Author sig
     *@Description 插入展示
     *@Date 21:31 2019/2/5
     *@Param [homeBanner]
     *@return com.sig.fayi.dto.ResultDto
     **/
    ResultDto inserBanner(HomeBanner homeBanner);

    ResultDto editBanner(HomeBanner homeBanner);

    ResultDto deleteBanner(int id);

    ResultDto changeImage(String image,int id);

    ResultDto findBannerById(int id);
}
