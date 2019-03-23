package com.sig.fayi.service;

import com.sig.fayi.dto.ResultDto;
import com.sig.fayi.entity.OrganizationPeople;

public interface OrganizationPeopleService {
    ResultDto joinOrganization(OrganizationPeople organizationPeople);

    ResultDto quitOrganizationById(int id);

    ResultDto quitOrganization(int userId,int organizationId);

    ResultDto findAllUserByOrganizationId(int organizationId);


}
