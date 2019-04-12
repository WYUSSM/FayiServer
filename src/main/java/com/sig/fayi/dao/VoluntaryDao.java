package com.sig.fayi.dao;

import com.sig.fayi.entity.Message;
import com.sig.fayi.entity.SimpleVoluntary;
import com.sig.fayi.entity.Voluntary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoluntaryDao {
    List<Voluntary> findAllVoluntary();

    List<SimpleVoluntary> findAllSimpleVoluntary();

    int addVoluntary(@Param("simpleVoluntary") SimpleVoluntary simpleVoluntary);

    Voluntary findVoluntaryById(@Param("id") int id);

    List<SimpleVoluntary> findAllVoluntaryByUserId(@Param("id") int id);

    List<SimpleVoluntary> findAllVoluntaryByOrgId(@Param("id") int id);

    int deleteVoluntary(@Param("id") int id);

    int editVoluntary(@Param("simpleVoluntary") SimpleVoluntary simpleVoluntary);

    int addMessage(@Param("message") Message message);
}
