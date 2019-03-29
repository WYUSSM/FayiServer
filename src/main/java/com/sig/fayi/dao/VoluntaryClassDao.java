package com.sig.fayi.dao;

import com.sig.fayi.entity.VoluntaryClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoluntaryClassDao {

    int addVoluntaryClass(@Param("voluntaryClass") VoluntaryClass voluntaryClass);

    int deleteVoluntaryClass(@Param("id") int id);

    List<VoluntaryClass> findAllVoluntaryClass();

    VoluntaryClass findVoluntaryClassById(@Param("id") int id);

    int changeVoluntaryClassById(@Param("voluntaryClass") VoluntaryClass voluntaryClass);

    int changeCoverById(@Param("id") int id,@Param("cover") String cover);
}
