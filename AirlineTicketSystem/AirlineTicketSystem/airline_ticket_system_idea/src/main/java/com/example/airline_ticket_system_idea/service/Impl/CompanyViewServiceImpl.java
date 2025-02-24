package com.example.airline_ticket_system_idea.service.Impl;

import com.example.airline_ticket_system_idea.mapper.CompanyViewMapper;
import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import com.example.airline_ticket_system_idea.service.CompanyViewService;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CompanyViewServiceImpl implements CompanyViewService {
    @Autowired
    private CompanyViewMapper companyViewMapper;



//展示公司飞机
    @Override
    public List<CompanyAircraft> list() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String companyID= (String) map.get("companyID");
        return companyViewMapper.list(companyID);
    }

    @Override
    public void addAircraft(CompanyAircraft companyAircraft) {

        companyViewMapper.addAircraft(companyAircraft);
    }

    @Override
    public CompanyAircraft findAircraftByID(String aircraftID) {

        return companyViewMapper.findAircraftByID(aircraftID);
    }

    @Override
    public void updateAircraft(CompanyAircraft companyAircraft) {
        companyViewMapper.updateAircraft(companyAircraft);
    }

    @Override
    public void deleteAircraft(String aircraftId) {
        companyViewMapper.deleteAircraft(aircraftId);
    }


//    公司航线
    @Override
    public List<CompanyRoutes> routesList() {
       Map<String,Object> map=ThreadLocalUtil.get();
       String companyID=(String)map.get("companyID");
       return companyViewMapper.routesList(companyID);
    }

    @Override
    public CompanyRoutes findRoutesByID(String routeID) {
        return companyViewMapper.findRoutesByID(routeID);
    }

    @Override
    public void addRoutes(CompanyRoutes companyRoutes) {
companyViewMapper.addRoutes(companyRoutes);
    }

    @Override
    public void updateRoutes(CompanyRoutes companyRoutes) {
        companyViewMapper.updateRoutes(companyRoutes);
    }

    @Override
    public void deleteRoutes(String routeID) {
companyViewMapper.deleteRoutes(routeID);
    }

// 查找公司用户信息和更新
    @Override
    public Company findCompanyByEmail(String email) {
        return companyViewMapper.findCompanyByEmail( email);
    }

    @Override
    public void update(Company company) {
        companyViewMapper.update(company);
    }

}



