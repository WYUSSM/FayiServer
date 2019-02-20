package com.sig.fayi.dao;

import com.sig.fayi.entity.Essay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EssayDao {
    /*
     *@Author sig
     *@Description 插入文章
     *@Date 23:44 2019/2/20
     *@Param [essay]
     *@return int
     **/
    int insertEssay(@Param("essay") Essay essay);

    /*
     *@Author sig
     *@Description 查找所有文章
     *@Date 23:44 2019/2/20
     *@Param
     *@return
     **/
    List<Essay> findAllEssay();
}
