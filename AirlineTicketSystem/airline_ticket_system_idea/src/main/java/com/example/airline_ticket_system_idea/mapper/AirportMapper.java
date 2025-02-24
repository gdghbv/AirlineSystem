package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.Airport;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AirportMapper {
    @Select("SELECT * FROM airport_info WHERE email=#{email}")
    Airport findAirportByEmail(String email);

    @Insert("INSERT INTO airport_info(airportID,email,password)"+"VALUES(#{airportID},#{email},#{password})")
    void add(@Param("airportID") String airportID, @Param("email") String email, @Param("password") String password);



}
