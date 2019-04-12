package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.Message;

public interface MessageService {
    ResultDto add(Message message);

    ResultDto findAllMessageByUserId(int userId);
}
