package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.AirportMapper;
import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.service.AirportService;
import com.example.airline_ticket_system_idea.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportMapper airportMapper;



    @Override
    public Airport getAirportByEmail(String email) {
        Airport airport=airportMapper.findAirportByEmail(email);
        return airport;
    }

    @Override
    public void register(String airportID, String email, String password) {
        String  md5Util=Md5Util.getMD5String(password);
            airportMapper.add(airportID,email,md5Util);
    }
}
