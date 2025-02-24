package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.CompanyViewService;
import com.example.airline_ticket_system_idea.util.JwtUtil;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/companyView")
public class CompanyViewController {
    @Autowired
    private CompanyViewService companyViewService;

 @GetMapping("/aircraftList")
    public Result<List<CompanyAircraft>> list(){
     List<CompanyAircraft> caList= companyViewService.list();
     return Result.success(caList);
 }
@PostMapping("/addAircraft")
    public Result<CompanyAircraft> addAircraft(@RequestBody CompanyAircraft companyAircraft){
     String aircraftId=companyAircraft.getAircraftID();
     if(companyViewService.findAircraftByID(aircraftId)!=null){
         return Result.error("该飞机编号已经存在");}
     companyViewService.addAircraft(companyAircraft);
     return Result.success(companyAircraft);
 }
 @PutMapping("/updateAircraft")
    public Result<CompanyAircraft> updateAircraft(@RequestBody CompanyAircraft companyAircraft){
     companyViewService.updateAircraft(companyAircraft);
     return Result.success(companyAircraft);
 }
 @DeleteMapping("/deleteAircraft/{aircraftID}")
    public Result<String> deleteAircraft(@PathVariable("aircraftID") String aircraftID){
     companyViewService.deleteAircraft(aircraftID);
     return Result.success("删除成功");
 }
   @GetMapping("/routesList")
    public Result<List<CompanyRoutes>> routesList(){
     List<CompanyRoutes> crList= companyViewService.routesList();
     return Result.success(crList);
    }
    @PostMapping("/addRoutes")
    public Result<CompanyRoutes> addRoutes(@RequestBody CompanyRoutes companyRoutes){
    String routeID=companyRoutes.getRouteID();
    if(companyViewService.findRoutesByID(routeID)!=null){
        return Result.error("该航线编号已经存在");}
    companyViewService.addRoutes(companyRoutes);
    return Result.success(companyRoutes);
    }
    @PutMapping("/updateRoutes")
    public Result<CompanyRoutes> updateRoutes(@RequestBody CompanyRoutes companyRoutes){
companyViewService.updateRoutes(companyRoutes);
return Result.success(companyRoutes);
    }
    @DeleteMapping("/deleteRoutes/{routeId}")
    public Result<String> deleteRoutes(@PathVariable("routeId") String routeID){
companyViewService.deleteRoutes(routeID);
return Result.success("删除成功");
    }
    @GetMapping("/companyInfo")
    public Result<Company> companyInfo(){
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String email = (String) map.get("email");
        Map<String, Object> map = ThreadLocalUtil.get();
        String email = (String) map.get("email");
        Company company = companyViewService.findCompanyByEmail(email);
        return Result.success(company);
    }
    @PutMapping("/updateCompanyInfo")
    public Result update(@RequestBody Company company){

        companyViewService.update(company);
        return Result.success();
    }
    }




