import request from '@/utils/request'
import { useTokenStore } from '@/stores/token'

export const flightListService =()=>{
    const tokenStore = useTokenStore()
    // return request.get('/airportView/aircraftList',{headers: {'Authorization': tokenStore.token}})
    //因为在request。js中设置了默认的headers，所以这里可以不用设置headers
    return request.get('/airportView/flightList')
}
export const flightAddService = (data)=>{
    return request.post('/airportView/addFlight',data)
}
export const flightDeleteService = (id)=>{
    return request.delete('/airportView/deleteFlight/'+id)
}
export const flightUpdateService = (data)=>{
    return request.put('/airportView/updateFlight',data)
}
export const flightDelayService = (data)=>{
    return request.put('/airportView/delayFlight',data)
}
export const aircraftListService =()=>{
    return request.get('/airportView/aircraftList')
}
export const aircraftAddService = (data)=>{
    return request.post('/airportView/addAircraft',data)
}
export const aircraftDeleteService = (id)=>{
    return request.delete('/airportView/deleteAircraft/'+id)
}
export const aircraftUpdateService = (data)=>{
    return request.put('/airportView/updateAircraft',data)
}
// 机场管理顾客用api
export const customerListService =()=>{
    return request.get('/airportView/customerList')
}
export const customerUpdateService = (data)=>{
    return request.put('/airportView/updateCustomer',data)
}
export const customerDeleteService = (id)=>{
    return request.delete('/airportView/deleteCustomer/'+id)
}
export const airportInfoService =()=>{
    return request.get('/airportView/airportInfo')
}

export const updateAirportInfoService=(data)=>{
    return request.put('/airportView/updateAirportInfo',data)
}

