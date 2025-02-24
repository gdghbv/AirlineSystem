<script setup>
import { ref, } from 'vue';
const title = ref('');
const dialogVisible = ref(false);
const aircraftData = ref([{

    airportID: '',
    airportName: '',
    companyID: '',
    aircraftID: '',
    aircraftName: '',
    status: '',

}
]);
const addAircraftData = ref([
    {
        airportID: '',
        aircraftID: '',
        status: '',
    }
])
const clearData = () => {
    addAircraftData.value = {
        airportID: '',
        aircraftID: '',
        status: '',
    }
}
const showDialog = (row) => {
    dialogVisible.value = true;
    title.value = '编辑航线';
    addAircraftData.value = row;
}
import { aircraftListService, aircraftAddService, aircraftUpdateService, aircraftDeleteService, } from '@/api/airport_view'
const aircraftList = async () => {
    let result = await aircraftListService();
    aircraftData.value = result.data;

}
aircraftList();
import { ElMessage } from 'element-plus'
const addAircraft = async () => {
    let result = await aircraftAddService(addAircraftData.value);
    ElMessage.success(result.msg ? result.msg : '添加成功');
    dialogVisible.value = false;
    aircraftList();
}
const updateAircraft = async () => {
    let result = await aircraftUpdateService(addAircraftData.value);
    ElMessage.success(result.msg ? result.msg : '修改成功');
    dialogVisible.value = false;
    aircraftList();
}
import { ElMessageBox } from 'element-plus'
const aircraftDelete = async (row) => {
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
            let result = await aircraftDeleteService(row.aircraftID);
            ElMessage({
                type: 'success',
                message: '删除成功',
            })
            //刷新列表
            aircraftList();
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
                <span>机场飞机管理</span>
                <div class="extra">
                    <el-button type="primary"
                        @click="dialogVisible = true; title = '添加飞机'; clearData()">添加飞机</el-button>
                </div>
            </div>
        </template>
        <el-table :data="aircraftData" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="飞机ID" prop="aircraftID"></el-table-column>
            <el-table-column label="飞机型号" prop="aircraftType"></el-table-column>
            <el-table-column label="机场ID" prop="airportID"></el-table-column>
            <el-table-column label="机场名字" prop="airportName"></el-table-column>
          
            <el-table-column label="状态" prop="status"></el-table-column>
            <el-table-column label="操作">
                <template #default="{ row }">
                    <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                    <el-button :icon="Delete" circle plain type="danger" @click="aircraftDelete(row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        
        
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addAircraftData" lable-width="100px" style="padding-right: 30px;">
                <el-form-item label="飞机ID" prop="aircraftID">
                    <el-input v-model="addAircraftData.aircraftID" placeholder="请输入飞机ID"></el-input>
                </el-form-item>
                <el-form-item label="机场ID" prop="airportID">
                    <el-input v-model="addAircraftData.airportID" placeholder="请输入机场ID"></el-input>
                </el-form-item>
                <el-form-item label="状态" prop="status">
                    <el-input v-model="addAircraftData.status" placeholder="请输入状态"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="title == '添加飞机' ? addAircraft() : updateAircraft()"> 确
                        定</el-button>
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