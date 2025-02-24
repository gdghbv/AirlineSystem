<script setup>
import { ref, } from 'vue';
const title = ref('');
const dialogVisible = ref(false);
const billData = ref([{
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
const addBillData = ref({
  
    status:'',
    dateTime:'',
    seatNumber:'',
    price:'',
    origin:'',
    destination:'',
    departureTime:'',
    boardingGate:'',
    companyID:'',


}
)

const showDialog = (row) => {
    dialogVisible.value = true;
    title.value = '确认退票';
    addBillData.value = row;
    console.log("showDialog中的"+addBillData.value);
    
}

import {billListService ,billRetreatService } from '@/api/customer_view'
const billList = async () => {
  let result = await billListService();  
  console.log("billList中的"+result.data);
  billData.value = result.data;
}
billList();
import { ElMessage } from 'element-plus';
const billRetreat=async()=>{
    console.log("billRetreat中的"+addBillData.value);
    let result=await billRetreatService(addBillData.value);
    ElMessage.success( '退款成功');
    dialogVisible.value = false;
    billList();
}
</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>查询订单</span>
                
            </div>
        </template>
        <el-table :data="billData" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
           <el-table-column label="购买时间" prop="dateTime"></el-table-column>
            <el-table-column label="始发地" prop="origin"></el-table-column>
            <el-table-column label="目的地" prop="destination"></el-table-column>
            <el-table-column label="起飞机场" prop="originAirport"></el-table-column>
            <el-table-column label="到达机场" prop="destinationAirport"></el-table-column>
            <el-table-column label="公司ID" prop="companyID"></el-table-column>
            <el-table-column label="航班ID" prop="flightID"></el-table-column>
            <el-table-column label="起飞时间" prop="departureTime"></el-table-column>
            <el-table-column label="检票口" prop="boardingGate"></el-table-column>
            <el-table-column label="价格" prop="price"></el-table-column>
            <el-table-column label="座位位置" prop="seatNumber"></el-table-column>
         

            <el-table-column label="操作" width="150px">
                <template #default="{ row }">
                 
                    <el-button :icon="confirm" circle plain type="warning" @click="showDialog(row)">退票</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 确认购买信息弹窗 -->
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addBillData" lable-width="100px" style="padding-right: 30px;">
             
              
                是否确认退购此机票？
              
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="billRetreat()"> 确 定</el-button>
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