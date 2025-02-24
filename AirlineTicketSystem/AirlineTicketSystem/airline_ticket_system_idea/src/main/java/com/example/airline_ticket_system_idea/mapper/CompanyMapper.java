package com.example.airline_ticket_system_idea.mapper;

import com.example.airline_ticket_system_idea.pojo.Company;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CompanyMapper {

    @Select("SELECT * FROM company_info WHERE email = #{email}")
    Company findCompanyByEmail(String email);

    @Insert("INSERT INTO company_info (companyID,email,password)"+"Values(#{companyID},#{email},#{password})")
    void add(@Param("companyID") String companyID, @Param("email") String email, @Param("password") String password);


}
