package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AirportViewMapper {

    //机场航班
    @Select("SELECT * FROM airport_flight_info afi Join company_routes_info cri on afi.routeID = cri.routeID " +
            "WHERE airportID= #{airportID}")
    List<AirportFlight> getFlightList(String airportID);

    @Select("SELECT * FROM company_routes_info " +
            "WHERE routeID= #{routeID}")
    CompanyRoutes getCompanyRoute(String routeId);

    @Insert("INSERT INTO airport_flight_info (airportID,routeID,flightID,departureTime,boardingGate,price,delay,seatCount) " +
            "VALUES (#{airportID},#{routeID},#{flightID},#{departureTime},#{boardingGate},#{price},'否',#{seatCount})")
    void addFlight(AirportFlight airportFlight);

    @Update("UPDATE airport_flight_info SET airportID= #{airportID},routeID= #{routeID},flightID= #{flightID}," +
            "departureTime= #{departureTime},boardingGate= #{boardingGate},price= #{price} WHERE flightID= #{flightID}")
    void updateFlight(AirportFlight airportFlight);

    @Delete("DELETE FROM airport_flight_info WHERE flightID= #{flightID}")
    void deleteFlight(String flightID);

    @Update("UPDATE airport_flight_info SET delay= '是' WHERE flightID= #{flightID}")
    void delayFlight(String flightID, String delayTime);

    //    机场飞机管理
    @Select("SELECT * FROM airport_aircraft Where airportID= #{airportID}")
    List<AirportAircraft> getAircraftList(String airportID);

    @Select("SELECT aircraftType FROM company_aircraft_info WHERE aircraftID= #{aircraftID}")
    String getAircraftType(String aircraftID);

    @Select("SELECT airportName FROM airport_info WHERE airportID= #{airportID}")
    String getAirportName(String airportID);

    @Insert("INSERT INTO airport_aircraft (aircraftID,airportID,status) VALUES ( #{aircraftID},#{airportID},#{status})")
    void addAircraft(AirportAircraft airportAircraft);

    @Delete("DELETE FROM airport_aircraft WHERE aircraftID= #{aircraftID}")
    void deleteAircraft(String aircraftID);

    @Update("UPDATE airport_aircraft SET aircraftID= #{aircraftID},airportID= #{airportID},status= #{status} WHERE aircraftID= #{aircraftID}")
    void updateAircraft(AirportAircraft airportAircraft);

    //机场客户信息管理
    @Select("SELECT * FROM customer_info")
    List<Customer> getCustomerList();

    @Delete("DELETE FROM customer_info WHERE email= #{email}")
    void deleteCustomer(String email);

    @Update("UPDATE customer_info SET name= #{name},points= #{points},email= #{email},phone= #{phone} WHERE email= #{email}")
    void updateCustomer(Customer customer);
@Select("SELECT seatCount FROM company_aircraft_info WHERE aircraftID= #{aircraftID}")
    CompanyAircraft getCompanyAircraft(String aircraftID);

@Select("SELECT * FROM airport_info WHERE email=#{email}")
    Airport findAirportByEmail(String email);

@Update("UPDATE airport_info SET  airportAddress=#{airportAddress},airportPhone=#{airportPhone} ,airportID=#{airportID}   WHERE email=#{email}")
    void updateAirport(Airport airport);
}


//机场信息
