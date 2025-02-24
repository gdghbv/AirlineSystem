package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.Airport;
import org.springframework.stereotype.Service;


public interface AirportService {
    Airport getAirportByEmail(String email);
    void register(String airportID,String email,String password);


}
