package com.sig.fayi.dao;

import com.sig.fayi.entity.Message;
import com.sig.fayi.entity.Message1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {
    int addMessage(@Param("message") Message message);

    List<Message1> findAllMessageByUserId(@Param("userId") int userId);
}
