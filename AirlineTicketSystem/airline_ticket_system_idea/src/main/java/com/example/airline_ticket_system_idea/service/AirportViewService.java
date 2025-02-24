package com.example.airline_ticket_system_idea.service;

import com.example.airline_ticket_system_idea.pojo.*;

import java.util.List;

public interface AirportViewService {

    List<AirportFlight> getFlightList();



    void addFlight(AirportFlight airportFlight);

    void updateFlight(AirportFlight airportFlight);

    void deleteFlight(String flightID);

    void delayFlight(String flightID,String delayTime);

    List<AirportAircraft> getAircraftList();

    void addAircraft(AirportAircraft airportAircraft);

    void deleteAircraft(String aircraftID);

    void updateAircraft(AirportAircraft airportAircraft);

    List<Customer> getCustomerList();

    void deleteCustomer(String email);

    void updateCustomer(Customer customer);

    Airport findAirportByEmail(String email);

    void update(Airport airport);
}
