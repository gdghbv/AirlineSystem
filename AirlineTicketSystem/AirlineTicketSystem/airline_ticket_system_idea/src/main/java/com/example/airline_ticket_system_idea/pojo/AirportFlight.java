package com.example.airline_ticket_system_idea.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AirportFlight {
  //  这是航线相关信息
    private String routeID;
    private String aircraftID;
    private String origin;
    private String destination;
    private String originAirport;
    private String destinationAirport;
    private String companyID;
    //这是航班在航线基础上添加的信息
    private String flightID;
    private String airportID;;
    private String departureTime;
    private String boardingGate;
    private double price;
    private String delay;
    private int seatCount;// 剩余座位数
    private int totalSeatCount;// 总座位数
    private double fullSeatRate;// 满座率
//    为了适配customer的订购信息，新添加的信息
  private LocalDateTime dateTime;
  private String status;
  private String email;

}
