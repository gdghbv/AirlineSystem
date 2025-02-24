<script setup>
import { ref ,} from 'vue';
const title = ref('');
const dialogVisible = ref(false);
const routesData = ref([{
  
}
]);
const addRoutesData = ref([
    {
        routeID: '',
      
        origin: '',
        destination: '',
        originAirport: '',
        destinationAirport: '',
      
        companyID: ''
    }
])
const clearData = () => {
    addRoutesData.value = {
        routeID: '',
        
        origin: '',
        destination: '',
        originAirport: '',
        destinationAirport: '',
       
        companyID: ''
    }
}
const showDialog = (row) => {
    dialogVisible.value=true;
    title.value='编辑航线';
    addRoutesData.value=row;
}
import {  routesListService,routesAddService,  routesDeleteService, routesUpdateService } from '@/api/company_view'
const routesList = async () => {
    let result = await routesListService();
    routesData.value = result.data;
   
}
routesList();
import { ElMessage } from 'element-plus'
const addRoutes = async () => {
    let result = await routesAddService(addRoutesData.value);
    ElMessage.success(result.msg ? result.msg : '添加成功');
    dialogVisible.value = false;
   routesList();
}
const updateRoutes = async () => {
    let result = await routesUpdateService(addRoutesData.value);
    ElMessage.success(result.msg ? result.msg : '修改成功');
    dialogVisible.value = false;
   routesList();
}
import { ElMessageBox } from 'element-plus'
const routeDelete = async (row) => {
    ElMessageBox.confirm(
        '你确认要删除该航线信息吗?',
        '温馨提示',
        {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning',
        }
    )
        .then(async () => {
            //调用接口
            let result = await routesDeleteService(row.routeID);
            ElMessage({
                type: 'success',
                message:  '删除成功',
            })
            //刷新列表
           routesList();
        })
        .catch(() => {
            ElMessage({
                type: 'info',
                message: '用户取消了删除',
            })
        })
}
</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
            <span>公司航线信息</span>
            <div class="extra">
                <el-button type="primary" @click="dialogVisible = true; title = '添加航线'; clearData()">添加航线</el-button>
            </div></div>
        </template>
        <el-table :data="routesData" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="航线ID" prop="routeID"></el-table-column>
            
            <el-table-column label="始发地" prop="origin"></el-table-column>
            <el-table-column label="目的地" prop="destination"></el-table-column>
            <el-table-column label="起飞机场" prop="originAirport"></el-table-column>
            <el-table-column label="到达机场" prop="destinationAirport"></el-table-column>
         
            <el-table-column label="公司ID" prop="companyID"></el-table-column>
            <el-table-column label="操作">
                <template #default="{ row }">
                <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                <el-button :icon="Delete" circle plain type="danger" @click="routeDelete(row)">删除</el-button>
           </template> 
        </el-table-column>
        </el-table>
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addRoutesData" lable-width="100px" style="padding-right: 30px;">
                 <el-form-item label="航线ID" prop="routeID">
                    <el-input v-model="addRoutesData.routeID" placeholder="请输入航线ID"></el-input>
                 </el-form-item>
                
                 <el-form-item label="始发地" prop="origin">
                    <el-input v-model="addRoutesData.origin" placeholder="请输入始发地"></el-input>
                 </el-form-item>
                 <el-form-item label="目的地" prop="destination">
                    <el-input v-model="addRoutesData.destination" placeholder="请输入目的地"></el-input>
                 </el-form-item>
                 <el-form-item label="起飞机场" prop="originAirport">
                    <el-input v-model="addRoutesData.originAirport" placeholder="请输入起飞机场"></el-input>
                 </el-form-item>
                 <el-form-item label="到达机场" prop="destinationAirport">
                    <el-input v-model="addRoutesData.destinationAirport" placeholder="请输入到达机场"></el-input>
                 </el-form-item>
              
               
                
                 <el-form-item label="公司ID" prop="companyID">
                    <el-input v-model="addRoutesData.companyID" placeholder="请输入公司ID"></el-input>
                 </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="title=='添加航线'?addRoutes():updateRoutes()"> 确 定</el-button>
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