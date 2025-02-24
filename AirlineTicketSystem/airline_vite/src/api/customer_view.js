import request from '@/utils/request'
import { useTokenStore } from '@/stores/token'

export const flightListService =()=>{
    const tokenStore = useTokenStore()
    // return request.get('/companyView/aircraftList',{headers: {'Authorization': tokenStore.token}})
    //因为在request。js中设置了默认的headers，所以这里可以不用设置headers
    return request.get('/customerView/flightList')
}
export const flightOrderService=(data)=>{
    return request.post('/customerView/orderFlight',data)
}
export const billListService=()=>{
    return request.get('/customerView/billList')
}
export const billRetreatService=(data)=>{
    return request.put('customerView/billRetreat')
}

export const customerInfoService=()=>{
    return request.get('/customerView/customerInfo')
}

export const updateCustomerInfoService=(data)=>{
    return request.put('/customerView/updateCustomerInfo',data)
}


