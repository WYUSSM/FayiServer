package com.sig.fayi.dao;

import com.sig.fayi.entity.ActivityGood;
import org.apache.ibatis.annotations.Param;

public interface VoluntaryGoodDao {

    int addGood(@Param("activityGood") ActivityGood activityGood);

    int deleteGood(@Param("id") int id);

    int addGoodCount(@Param("id") int id);

    int reduceGoodCount(@Param("id") int id);
}
