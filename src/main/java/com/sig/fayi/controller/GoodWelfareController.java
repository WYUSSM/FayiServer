package com.sig.fayi.controller;

import com.sig.fayi.service.GoodWelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goodWelfare")
public class GoodWelfareController {

    @Autowired
    private GoodWelfareService goodWelfareService;

}
