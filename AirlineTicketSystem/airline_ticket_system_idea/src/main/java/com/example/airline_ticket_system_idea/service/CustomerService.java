package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.Customer;

public interface CustomerService {


    Customer findCustomerByEmail(String email);
    void register(String citizenID,String email,String password);
}
