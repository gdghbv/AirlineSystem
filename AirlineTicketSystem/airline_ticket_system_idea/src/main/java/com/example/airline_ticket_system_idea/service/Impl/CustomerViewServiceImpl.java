package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.CustomerViewMapper;
import com.example.airline_ticket_system_idea.pojo.AirportFlight;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.pojo.Customer;
import com.example.airline_ticket_system_idea.pojo.CustomerTicketInfo;
import com.example.airline_ticket_system_idea.service.CustomerViewService;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CustomerViewServiceImpl implements CustomerViewService {
    @Autowired
    private CustomerViewMapper customerViewMapper;
    @Override
    public List<AirportFlight> getFlightList() {
        List<AirportFlight> airportFlights = customerViewMapper.getFlightList();
//        使用了链接查询，就不需要下面这些麻烦步骤了
//        for(AirportFlight airportFlight: airportFlights){
//String routeId=airportFlight.getRouteID();
//            CompanyRoutes companyRoutes=customerViewMapper.getCompanyRoutes(routeId);
//
//                airportFlight.setOrigin(companyRoutes.getOrigin());
//                airportFlight.setDestination(companyRoutes.getDestination());
//                airportFlight.setOriginAirport(companyRoutes.getOriginAirport());
//                airportFlight.setDestinationAirport(companyRoutes.getDestinationAirport());
//                airportFlight.setCompanyID(companyRoutes.getCompanyID());
//                airportFlight.setAircraftID(companyRoutes.getAircraftID());
//
//        }
        return airportFlights;
    }

    @Override
    public void orderFlight(AirportFlight airportFlight) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String email=(String) map.get("email");

        airportFlight.setDateTime(LocalDateTime.now());
       airportFlight.setEmail(email);
        airportFlight.setStatus("未出行");
//        在顾客订单表中添加一条记录
        customerViewMapper.orderFlight(airportFlight);
//当订购成功的时候，减少航班余座数量
        String flightID=airportFlight.getFlightID();
        AirportFlight flight=customerViewMapper.getFlight(flightID);
        airportFlight.setSeatCount(flight.getSeatCount()-1);
        customerViewMapper.updateFlightSeatCount(airportFlight);
//        同时更新用户的积分记录
       Customer customer= customerViewMapper.getCustomerInfo(email);
       if(customer.getPhone()!=null){
       int addPoints=(int)(flight.getPrice()/10);
       customer.setPoints(customer.getPoints()+addPoints);}
    }

    @Override
    public List<CustomerTicketInfo> getBillList() {
        Map<String ,Object> map=ThreadLocalUtil.get();
        String email=(String)map.get("email");
        List<CustomerTicketInfo> customerTicketInfos=customerViewMapper.getBillList(email);


        return customerTicketInfos;
    }

    @Override
    public void billRetreat(String ticketID) {

        Map<String ,Object> map=ThreadLocalUtil.get();
        String email=(String) map.get("email");
        Customer customer=customerViewMapper.getCustomerInfo(email);
        customerViewMapper.billRetreat(ticketID);
        //对于customer的退票，扣除相应的积分并额外扣除50积分
        if(customer.getPhone()!=null){
            CustomerTicketInfo customerTicketInfo=customerViewMapper.getCustomerTicketInfo(ticketID);
            AirportFlight airportFlight=customerViewMapper.getCustomerFlight(customerTicketInfo.getFlightID());
        customer.setPoints(customer.getPoints()-50-airportFlight.getPrice()/10);

        }
    }

    @Override
    public Customer customerInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String eamil=(String) map.get("email");
       return customerViewMapper.getCustomerInfo(eamil);
    }

    @Override
    public void updateCustomerInfo(Customer customer) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String email=(String) map.get("email");
        customer.setEmail(email);
        customerViewMapper.updateCustomerInfo(customer);
    }

}
