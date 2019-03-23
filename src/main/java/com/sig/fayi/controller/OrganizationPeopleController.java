package com.sig.fayi.controller;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.OrganizationPeople;
import com.sig.fayi.service.OrganizationPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/organizationPeople")
public class OrganizationPeopleController {
    @Autowired
    private OrganizationPeopleService organizationPeopleService;

    @ResponseBody
    @RequestMapping(value = "/joinOrganization")
    public ResultDto joinOrganization(HttpServletRequest request){
        OrganizationPeople organizationPeople=new OrganizationPeople();
        organizationPeople.setUserId(Integer.parseInt(request.getParameter("userId")));
        organizationPeople.setOrganizationId(Integer.parseInt(request.getParameter("organizationId")));
        organizationPeople.setApply_time(new Date());
        organizationPeople.setFlag("审核中");
        return organizationPeopleService.joinOrganization(organizationPeople);
    }

    @ResponseBody
    @RequestMapping(value = "/quitOrganizationById")
    public ResultDto quitOrganizationById(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return organizationPeopleService.quitOrganizationById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/quitOrganization")
    public ResultDto quitOrganization(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        int organizationId=Integer.parseInt(request.getParameter("organizationId"));
        return organizationPeopleService.quitOrganization(userId,organizationId);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllUserByOrganizationId")
    public ResultDto findAllUserByOrganizationId(HttpServletRequest request){
        int organizationId=Integer.parseInt(request.getParameter("organizationId"));
        return organizationPeopleService.findAllUserByOrganizationId(organizationId);
    }
}
