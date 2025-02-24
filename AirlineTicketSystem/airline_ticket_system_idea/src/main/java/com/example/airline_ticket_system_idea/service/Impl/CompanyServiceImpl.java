package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.CompanyMapper;
import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.service.CompanyService;
import com.example.airline_ticket_system_idea.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper ;
    @Override
    public Company findCompanyByEmail(String email) {
       Company company= companyMapper.findCompanyByEmail(email);
        return company;
    }

    @Override
    public void register(String companyID, String email, String password) {
        String md5String = Md5Util.getMD5String(password);
          companyMapper.add(companyID,email,md5String);
    }


}
