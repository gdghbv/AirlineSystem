package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.Company;

public interface CompanyService {


     Company findCompanyByEmail(String email);


     void register(String companyID,String email,String password);


}
