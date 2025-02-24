package com.example.airline_ticket_system_idea.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class Company {
    private String companyID;
    private String companyName;
    private String companyAddress;
    private String phone;
    private String email;
    @JsonIgnore
    private String password;

}
