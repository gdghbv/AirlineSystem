package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {
    //根据邮箱查询客户，返回Customer对象
    @Select("SELECT * FROM customer_info WHERE email= #{email}")
    Customer findCustomerByEmail(String email);

    //添加客户,一开始注册的用户不需要填手机号，升级客户则需要在后面页面填手机号
    @Insert("INSERT INTO customer_info(citizenID, email,password)"+
            "VALUES(#{citizenID},#{email},#{password})")
   void add(@Param("citizenID") String citizenID,@Param("email") String email, @Param("password") String password);
}
