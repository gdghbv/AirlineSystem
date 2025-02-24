<script setup>
import { ref, } from 'vue';
const title = ref('');
const dialogVisible = ref(false);
const flightData = ref([{
    origin:'',
    destination:'',
    originAirport:'',
    destinationAirport:'',
    departureTime:'',
    boardingGate:'',
    price:'',
    seatCount:'',
}
]);
const addTicketData = ref({
  
    flightID: '',
    date:'',
    origin:'',
    destination:'',
    originAirport:'',
    destinationAirport:'',
    departureTime:'',
    boardingGate:'',
    price:'',
    seatCount:'',
   citizenID:'',
}
)

const showDialog = (row) => {
    dialogVisible.value = true;
    title.value = '确认购买';
    addTicketData.value = row;
    console.log("showDialog中的"+addTicketData.value);
    
}

import {flightListService ,flightOrderService } from '@/api/customer_view'
const flightList = async () => {
  let result = await flightListService();  // 请求后端的 /customerView/flightList
  flightData.value = result.data;
}
flightList();
import { ElMessage } from 'element-plus';
const flightOrder=async()=>{
    console.log("flightOrder中的"+addTicketData.value);
    let result=await flightOrderService(addTicketData.value);
    ElMessage.success( '购买成功');
    dialogVisible.value = false;
    flightList();
}
</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>购买机票</span>              
            </div>
        </template>
        <el-table :data="flightData" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="始发地" prop="origin"></el-table-column>
            <el-table-column label="目的地" prop="destination"></el-table-column>
            <el-table-column label="起飞机场" prop="originAirport"></el-table-column>
            <el-table-column label="到达机场" prop="destinationAirport"></el-table-column>
            <el-table-column label="公司ID" prop="companyID"></el-table-column>
            <el-table-column label="航班ID" prop="flightID"></el-table-column>
            <el-table-column label="机场ID" prop="airportID"></el-table-column>
            <el-table-column label="起飞时间" prop="departureTime"></el-table-column>
            <el-table-column label="检票口" prop="boardingGate"></el-table-column>
            <el-table-column label="价格" prop="price"></el-table-column>
            <el-table-column label="剩余座位" prop="seatCount"></el-table-column>

            <el-table-column label="操作" width="150px">
                <template #default="{ row }">
                 
                    <el-button :icon="confirm" circle plain type="primary" @click="showDialog(row)">购买</el-button>
                </template>
            </el-table-column>
            
        </el-table>
        <!-- 确认购买信息弹窗 -->
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addTicketData" lable-width="100px" style="padding-right: 30px;">
              <el-form-item>
                <el-input v-model="addTicketData.citizenID" placeholder="请输入出行人的身份证号"></el-input>
              </el-form-item>
              
                是否确认购买此机票？
              
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="flightOrder()"> 确 定</el-button>
                    <el-button @click="dialogVisible = false"> 取 消</el-button>
                </span>
            </template>
        </el-dialog>
    </el-card>
</template>
<style lang="scss" scoped>
.page-container {
    min-height: 100%;
    box-sizing: border-box;

    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
}
</style>