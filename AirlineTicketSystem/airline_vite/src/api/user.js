import request from '@/utils/request.js'

export const customerRegisterService=(CustomerRegisterData)=>{
    const params=new URLSearchParams();
    for(let key in CustomerRegisterData){
        params.append(key,CustomerRegisterData[key]);

    }
   
   return request.post('/customer/register',params);
}
export const customerLoginService=(CustomerLoginData)=>{
    const params=new URLSearchParams();
    for(let key in CustomerLoginData){
             params.append(key,CustomerLoginData[key])
    }
    return request.post('/customer/login',params);
}
export const companyRegisterService=(CompanyRegisterData)=>{
    const params=new URLSearchParams();
    for(let key in CompanyRegisterData){
        params.append(key,CompanyRegisterData[key]);

    }
    return request.post('/company/register',params);
}
export const companyLoginService=(CompanyLoginData)=>{
    const params=new URLSearchParams();
    for(let key in CompanyLoginData){
        params.append(key,CompanyLoginData[key]);

        }
    return request.post('/company/login',params);
}
export const airportRegisterService=(AirportRegisterData)=>{
    const param=new URLSearchParams();
    for(let key in AirportRegisterData){
        param.append(key,AirportRegisterData[key]);
    }
    return request.post('/airport/register',param);
}
export const airportLoginService=(AirportLoginData)=>{
    const params=new URLSearchParams();
    for(let key in AirportLoginData){
        params.append(key,AirportLoginData[key]);
    }
    return request.post('/airport/login',params);
}
