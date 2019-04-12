package com.sig.fayi.service.impl;

import com.sig.fayi.dao.BannerDao;
import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.HomeBanner;
import com.sig.fayi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    /*
     *@Author sig
     *@Description 查找所有展示对象
     *@Date 16:14 2019/2/5
     *@Param
     *@return
     **/
    @Override
    public ResultDto findAllBanner(){
        List<HomeBanner> banners=bannerDao.findAllBanner();
        if(banners!=null){
            return new ResultDto(200,"success",banners);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    /*
     *@Author sig
     *@Description 插入展示
     *@Date 21:31 2019/2/5
     *@Param [homeBanner]
     *@return com.sig.fayi.dto.ResultDto
     **/
    @Override
    public ResultDto inserBanner(HomeBanner homeBanner){
        int count=bannerDao.insertBanner(homeBanner);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto editBanner(HomeBanner homeBanner){
        int count=bannerDao.editBanner(homeBanner);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto deleteBanner(int id){
        int count=bannerDao.deleteBanner(id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }

    @Override
    public ResultDto changeImage(String image,int id){
        int count=bannerDao.changeImage(image,id);
        if(count==1){
            return new ResultDto(200,"success",null);
        }else {
            return new ResultDto(200,"failure",null);
        }
    }
}
