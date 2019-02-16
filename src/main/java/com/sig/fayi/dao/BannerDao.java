package com.sig.fayi.dao;

import com.sig.fayi.entity.HomeBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {

    List<HomeBanner> findAllBanner();

    int insertBanner(@Param("homeBanner") HomeBanner homeBanner);

}
