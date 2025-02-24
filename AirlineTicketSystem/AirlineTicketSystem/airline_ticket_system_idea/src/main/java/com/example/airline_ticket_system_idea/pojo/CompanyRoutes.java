package com.example.airline_ticket_system_idea.pojo;

import lombok.Data;

@Data
public class CompanyRoutes {
    private String routeID;
    private String aircraftID;
    private String origin;
    private String destination;
    private String originAirport;
    private String destinationAirport;
    private String companyID;
}
