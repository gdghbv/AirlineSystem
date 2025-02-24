package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.CompanyAircraft;
import com.example.airline_ticket_system_idea.pojo.CompanyRoutes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyViewMapper {
    //    查询该公司旗下所有飞机信息
    @Select("SELECT * FROM company_aircraft_info where companyID = #{companyID}")
    List<CompanyAircraft> list(@Param("companyID") String companyID);

    @Insert("INSERT INTO company_aircraft_info(companyID, aircraftID, aircraftType, seatCount) VALUES(#{companyID}, #{aircraftID}, #{aircraftType}, #{seatCount})")
    void addAircraft(CompanyAircraft companyAircraft);

    @Select("SELECT * FROM company_aircraft_info WHERE aircraftID = #{aircraftID}")
    CompanyAircraft findAircraftByID(String aircraftID);

    @Update("UPDATE company_aircraft_info SET aircraftType = #{aircraftType}, seatCount = #{seatCount} WHERE aircraftID = #{aircraftID}")
    void updateAircraft(CompanyAircraft companyAircraft);

    @Delete("DELETE FROM company_aircraft_info WHERE aircraftID = #{aircraftID}")
    void deleteAircraft(@Param("aircraftID") String aircraftID);

    @Select("SELECT * FROM company_routes_info WHERE companyID = #{companyID}")
    List<CompanyRoutes> routesList(String companyID);

    @Select("SELECT * FROM company_routes_info WHERE routeID = #{routeID}")
    CompanyRoutes findRoutesByID(String routeID);

    @Insert("INSERT INTO company_routes_info(routeID, origin, destination, originAirport, destinationAirport,companyID) VALUES( #{routeID}, #{origin}, #{destination}, #{originAirport}, #{destinationAirport}, #{companyID})")
    void addRoutes(CompanyRoutes companyRoutes);

    @Delete("DELETE FROM company_routes_info WHERE routeID = #{routeID}")
    void deleteRoutes(String routeID);

    @Update("UPDATE company_routes_info SET aircraftID = #{aircraftID}, routeID=#{routeID},origin=#{origin},destination=#{destination},originAirport=#{originAirport},destinationAirport=#{destinationAirport} WHERE routeID = #{routeID}")
    void updateRoutes(CompanyRoutes companyRoutes);

    @Select("SELECT * FROM company_info WHERE email = #{email}")
    Company findCompanyByEmail(String email);

    @Update("UPDATE company_info SET companyID = #{companyID}, companyName= #{companyName},companyAddress = #{companyAddress}, phone = #{phone} WHERE email = #{email}")
    void update(Company company);
}

