package com.example.airline_ticket_system_idea;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){
        Map<String ,Object> claims=new HashMap<>();
        claims.put("companyID","John Doe");
       claims.put("email","123");
       // claims.put("citizenID","111");
        //生成Jwt的代码
         String token=JWT.create()
                .withClaim("user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .sign(Algorithm.HMAC256("secret"));
        System.out.print(token);

    }

    @Test
    public void testGen1(){
        Map<String ,Object> claims=new HashMap<>();
        claims.put("password","123");
        claims.put("email","123");
        claims.put("citizenID","123");
        //生成Jwt的代码
        String token=JWT.create()
                .withClaim("user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .sign(Algorithm.HMAC256("secret"));
        System.out.print(token);

    }




}
