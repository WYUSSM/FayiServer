package com.sig.fayi.dao;

import com.sig.fayi.entity.SimpleVoluntary;
import com.sig.fayi.entity.Voluntary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoluntaryDao {
    List<Voluntary> findAllVoluntary();

    List<SimpleVoluntary> findAllSimpleVoluntary();

    int addVoluntary(@Param("simpleVoluntary") SimpleVoluntary simpleVoluntary);
}
