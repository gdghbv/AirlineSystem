package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.AirportViewMapper;
import com.example.airline_ticket_system_idea.pojo.*;
import com.example.airline_ticket_system_idea.service.AirportViewService;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AirportViewServiceImpl implements AirportViewService {

    @Autowired
    private AirportViewMapper airportViewMapper;


    @Override
    public List<AirportFlight> getFlightList() {
//        需要为每个routeID进行赋值
        Map<String, Object> map = ThreadLocalUtil.get();
        String airportID = (String) map.get("airportID");
        List<AirportFlight> flightList = airportViewMapper.getFlightList(airportID);


        return flightList;
    }

    @Override
    public void addFlight(AirportFlight airportFlight) {
        CompanyRoutes companyRoute = airportViewMapper.getCompanyRoute(airportFlight.getRouteID());
        CompanyAircraft companyAircraft = airportViewMapper.getCompanyAircraft(companyRoute.getAircraftID());

        airportFlight.setSeatCount(companyAircraft.getSeatCount());
        airportViewMapper.addFlight(airportFlight);
    }

    @Override
    public void updateFlight(AirportFlight airportFlight) {

        airportViewMapper.updateFlight(airportFlight);
    }

    @Override
    public void deleteFlight(String flightID) {
        airportViewMapper.deleteFlight(flightID);
    }

    @Override
    public void delayFlight(String flightID, String delayTime) {
        airportViewMapper.delayFlight(flightID, delayTime);
    }

    @Override
    public List<AirportAircraft> getAircraftList() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String airportID = (String) map.get("airportID");
        List<AirportAircraft> aircraftList = airportViewMapper.getAircraftList(airportID);
        for (AirportAircraft aircraft : aircraftList) {
            aircraft.setAircraftType(airportViewMapper.getAircraftType(aircraft.getAircraftID()));
            aircraft.setAirportName(airportViewMapper.getAirportName(aircraft.getAirportID()));
        }
        return aircraftList;
    }

    @Override
    public void addAircraft(AirportAircraft airportAircraft) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String airportId = (String) map.get("airportID");
        airportAircraft.setAirportID(airportId);
        airportViewMapper.addAircraft(airportAircraft);
    }

    @Override
    public void deleteAircraft(String aircraftID) {
        airportViewMapper.deleteAircraft(aircraftID);
    }

    @Override
    public void updateAircraft(AirportAircraft airportAircraft) {
        airportViewMapper.updateAircraft(airportAircraft);

    }

    @Override
    public List<Customer> getCustomerList() {
        return airportViewMapper.getCustomerList();
    }

    @Override
    public void deleteCustomer(String email) {
        airportViewMapper.deleteCustomer(email);
    }

    @Override
    public void updateCustomer(Customer customer) {
        airportViewMapper.updateCustomer(customer);

    }

    @Override
    public Airport findAirportByEmail(String email) {
        return airportViewMapper.findAirportByEmail(email);
    }

    @Override
    public void update(Airport airport) {
airportViewMapper.updateAirport(airport);
    }


}

