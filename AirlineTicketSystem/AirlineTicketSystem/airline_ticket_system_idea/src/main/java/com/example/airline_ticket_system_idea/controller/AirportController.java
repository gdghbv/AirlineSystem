package com.example.airline_ticket_system_idea.controller;

import com.example.airline_ticket_system_idea.pojo.Airport;
import com.example.airline_ticket_system_idea.pojo.Company;
import com.example.airline_ticket_system_idea.pojo.Result;
import com.example.airline_ticket_system_idea.service.AirportService;
import com.example.airline_ticket_system_idea.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.example.airline_ticket_system_idea.util.Md5Util.checkPassword;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @PostMapping("/register")
    public Result register(String airportID,String email,String password){
        Airport airport = airportService.getAirportByEmail(email);
        if(airport== null){
            airportService.register(airportID,email,password);
            return Result.success();
        }else {
            return Result.error("邮箱已被注册");
        }
    }
    @PostMapping("login")
    public Result login(String email,String password){
        Airport airport=airportService.getAirportByEmail(email);
        if(airport==null){
            return Result.error("邮箱不存在");
        }
        if(checkPassword(password,airport.getPassword())){
            //登录成功，生成令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("airportID", airport.getAirportID()); //放入注册用户的id
            claims.put("email", airport.getEmail());//放入注册用户的username
            String token = JwtUtil.genToken(claims); //生成token
            return Result.success(token); //响应JWT token令牌字符串

        }
        return Result.error("密码错误");
    }
}

