package com.example.airline_ticket_system_idea.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CustomerTicketInfo {
private LocalDateTime dateTime;
private String status;
private String flightID;
private String email;
private String seatID;
    //  这是航班相关信息
    private String routeID;
    private String aircraftID;
    private String origin;
    private String destination;
    private String originAirport;
    private String destinationAirport;
    private String companyID;
    private String airportID;;
    private String departureTime;
    private String boardingGate;
    private double price;
    private String delay;
    private int seatCount;

}
