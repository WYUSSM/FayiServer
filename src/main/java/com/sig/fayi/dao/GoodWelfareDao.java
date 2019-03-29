package com.sig.fayi.dao;

import com.sig.fayi.entity.GoodWelfare;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodWelfareDao {

    int addGoodWelfare(@Param("goodWelfare") GoodWelfare goodWelfare);

    int deleteGoodWelfare(@Param("id") int id);

    List<GoodWelfare> findAllGoodWelfare();

    GoodWelfare findGoodWelfareById(@Param("id") int id);

    int changeGoodWelfareById(@Param("goodWelfare") GoodWelfare goodWelfare);

    int changeCoverById(@Param("id")int id,@Param("cover") String cover);
}
