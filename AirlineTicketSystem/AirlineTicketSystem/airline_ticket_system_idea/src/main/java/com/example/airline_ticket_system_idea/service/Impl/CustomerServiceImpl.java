package com.example.airline_ticket_system_idea.service.Impl;

        import com.example.airline_ticket_system_idea.mapper.CustomerMapper;
        import com.example.airline_ticket_system_idea.pojo.Customer;
        import com.example.airline_ticket_system_idea.service.CustomerService;
        import com.example.airline_ticket_system_idea.util.Md5Util;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer findCustomerByEmail(String email) {
        //调用customerMapper.findCustomerByEmail()方法，将email赋值回去Mapper
        Customer customer= customerMapper.findCustomerByEmail(email);
        //这里的return是Controller用来检测用户是否已经注册用户用的
        return customer;
    }

    //传递参数到customerMapper.add()方法中
    @Override
    public void register(String citizenID, String email, String password) {
        //加密
        String md5String = Md5Util.getMD5String(password);
        customerMapper.add(citizenID,email,md5String);
    }
}
