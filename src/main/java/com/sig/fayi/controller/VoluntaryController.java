package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.exception.BaseExceptionHandleAction;
import com.sig.fayi.service.VoluntaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/voluntary")
public class VoluntaryController extends BaseExceptionHandleAction {
    @Autowired
    private VoluntaryService voluntaryService;

    @ResponseBody
    @RequestMapping(value = "/findAllVoluntary")
    public ResultDto findAllVoluntary(){
        return voluntaryService.findAllVoluntary();
    }
}
