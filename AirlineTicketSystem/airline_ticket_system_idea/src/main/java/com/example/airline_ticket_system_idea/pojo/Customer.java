package com.example.airline_ticket_system_idea.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private  String citizenID;
    private String name;
    private String phone;
    private String gender;
    private double points;
    private String email;
    private String password;
    private String address;
}
