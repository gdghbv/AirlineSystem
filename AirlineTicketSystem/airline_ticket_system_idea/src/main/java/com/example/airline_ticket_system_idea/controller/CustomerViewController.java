package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.Customer;
import com.example.airline_ticket_system_idea.pojo.CustomerTicketInfo;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CustomerViewService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerView")
public class CustomerViewController {
    @Autowired
    private CustomerViewService customerViewService;

    @GetMapping("/flightList")
    public Result<List<AirportFlight>> getFlightList() {
       List<AirportFlight> flightList = customerViewService.getFlightList();
        return Result.success(flightList);
    }
    @PostMapping("/orderFlight")
    public Result<String> orderFlight(@RequestBody AirportFlight airportFlight){
        customerViewService.orderFlight(airportFlight);
        return Result.success("订购成功");
    }
    @GetMapping("/billList")
    public Result<List<CustomerTicketInfo>> getBillList() {
        List<CustomerTicketInfo> billList = customerViewService.getBillList();
        return Result.success(billList);
    }
    @PutMapping("/billRetreat/{ticketID}")
    public Result<String> billRetreat( @PathVariable String ticketID){
        customerViewService.billRetreat(ticketID);
        return Result.success("退票成功");
    }
    @GetMapping("/customerInfo")
    public Result<Customer> customerInfo(){
        Customer customer = customerViewService.customerInfo();
        return Result.success(customer);
    }
    @PutMapping("/updateCustomerInfo")
    public Result<String> updateCustomerInfo(@RequestBody Customer customer){
        customerViewService.updateCustomerInfo(customer);
        return Result.success("修改成功");
    }

}
