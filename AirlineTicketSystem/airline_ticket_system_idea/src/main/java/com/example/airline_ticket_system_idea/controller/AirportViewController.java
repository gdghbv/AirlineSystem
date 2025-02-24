package com.example.airline_ticket_system_idea.controller;


import com.example.airline_ticket_system_idea.pojo.*;
import com.example.airline_ticket_system_idea.service.AirportViewService;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/airportView")
public class AirportViewController {
    @Autowired
    private AirportViewService airportViewService;
    //机场航班mapping
    @GetMapping("/flightList")
    public Result<List<AirportFlight>> getFlightList() {
        List<AirportFlight> flightList = airportViewService.getFlightList();
        return Result.success(flightList);

    }
    @PostMapping("/addFlight")
    public Result<String> addFlight(@RequestBody AirportFlight airportFlight){
        airportViewService.addFlight(airportFlight);
        return Result.success("添加成功");
    }
    @PutMapping("/updateFlight")
    public Result<String> updateFlight(@RequestBody AirportFlight airportFlight){
        airportViewService.updateFlight(airportFlight);
        return Result.success("更新成功");
    }
    @DeleteMapping("/deleteFlight/{flightID}")
    public Result<String> deleteFlight(@PathVariable ("flightID")String flightID){
        airportViewService.deleteFlight(flightID);
        return Result.success("删除成功");
    }
    @PutMapping("/delayFlight/{id}")
  public Result<String> delayFlight(String flightID,String delayTime){
      airportViewService.delayFlight(flightID,delayTime);
        return Result.success("延误成功");
    }

    //机场飞机Mapping
    @GetMapping("/aircraftList")
    public Result<List<AirportAircraft>> getAircraftList() {
       List<AirportAircraft>    aircraftList = airportViewService.getAircraftList();
        return Result.success(aircraftList);

    }
    @PostMapping("/addAircraft")
    public Result<String> addAircraft(@RequestBody AirportAircraft airportAircraft){

        airportViewService.addAircraft(airportAircraft);
        return Result.success("添加成功");
    }
    @DeleteMapping("/deleteAircraft/{aircraftID}")
    public Result<String> deleteAircraft(@PathVariable ("aircraftID") String aircraftID) {
    airportViewService.deleteAircraft(aircraftID);
    return Result.success("删除成功");
    }
    @PutMapping("/updateAircraft")
    public Result<String> updateAircraft(@RequestBody AirportAircraft airportAircraft){
        airportViewService.updateAircraft(airportAircraft);
        return Result.success("更新成功");
    }
//机场客户Mapping
    @GetMapping("/customerList")
    public Result<List<Customer>> getCustomerList() {
        List<Customer> customerList = airportViewService.getCustomerList();
        return Result.success(customerList);

    }
    @DeleteMapping("/deleteCustomer/{email}")
    public Result<String> deleteCustomer( @PathVariable ("email")String email){
        airportViewService.deleteCustomer(email);
        return Result.success("删除成功");
    }
    @PutMapping("/updateCustomer")
    public Result<String> updateCustomer(@RequestBody Customer customer){
        airportViewService.updateCustomer(customer);
        return Result.success("更新成功");

}

    @GetMapping("/airportInfo")
    public Result<Airport> companyInfo(){
//
        Map<String, Object> map = ThreadLocalUtil.get();
        String email = (String) map.get("email");
        Airport airport = airportViewService.findAirportByEmail(email);
        return Result.success(airport);
    }
    @PutMapping("/updateAirportInfo")
    public Result update(@RequestBody Airport airport){

        airportViewService.update(airport);
        return Result.success();
    }

}












