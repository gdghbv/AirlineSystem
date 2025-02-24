import request from '@/utils/request'
import { useTokenStore } from '@/stores/token'

export const aircraftListService =()=>{
    const tokenStore = useTokenStore()
    // return request.get('/companyView/aircraftList',{headers: {'Authorization': tokenStore.token}})
    //因为在request。js中设置了默认的headers，所以这里可以不用设置headers
    return request.get('/companyView/aircraftList')
}
export const aircraftAddService = (data)=>{
    return request.post('/companyView/addAircraft',data)
}
export const aircraftDeleteService = (id)=>{
    return request.delete('/companyView/deleteAircraft/'+id)
}
export const aircraftUpdateService = (data)=>{
    return request.put('/companyView/updateAircraft',data)
}
export const routesListService =()=>{
    return request.get('/companyView/routesList')}
export const routesAddService = (data)=>{
    return request.post('/companyView/addRoutes',data)
}
export const routesDeleteService = (id)=>{
    return request.delete('/companyView/deleteRoutes/'+id)
}
export const routesUpdateService = (data)=>{
    return request.put('/companyView/updateRoutes',data)
}


export const updateCompanyInfoService=(data)=>{
    return request.put('/companyView/updateCompanyInfo',data)
}
export const companyInfoService=()=>{
    return request.get('/companyView/companyInfo')
}