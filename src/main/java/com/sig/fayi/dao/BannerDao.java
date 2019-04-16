package com.sig.fayi.dao;

import com.sig.fayi.entity.HomeBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {

    /*
     *@Author sig
     *@Description 查找所有轮播
     *@Date 23:55 2019/2/20
     *@Param []
     *@return java.util.List<com.sig.fayi.entity.HomeBanner>
     **/
    List<HomeBanner> findAllBanner();

    /*
     *@Author sig
     *@Description 添加轮播
     *@Date 23:55 2019/2/20
     *@Param [homeBanner]
     *@return int
     **/
    int insertBanner(@Param("homeBanner") HomeBanner homeBanner);

    int editBanner(@Param("homeBanner") HomeBanner homeBanner);

    int deleteBanner(@Param("id") int id);

    int changeImage(@Param("image") String image,@Param("id") int id);

    HomeBanner findBannerById(@Param("id") int id);

}
