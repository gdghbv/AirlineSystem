<script setup>
import { ref, } from 'vue';
const title = ref('');
const dialogVisible = ref(false);
const delayVisible = ref(false);
const flightData = ref([{
    routeID: '1',
    origin: '北京',
    destination: '上海',
    originAirport: '北京机场',
    destinationAirport: '上海机场',
    companyID: '1',
    flightID: '1',
    airportID: '1',
    departureTime: '2022-01-01 08:00:00',
    boardingGate: 'A1',
    price: '1000',
    delay: ' 否'


}
]);
const addFlightData = ref({
    routeID: '',
    flightID: '',
    departureTime: '',
    boardingGate: '',
    price: '',
    delay: '',
    companyID: '',
}
)
const clearData = () => {
    addFlightData.value = {
        routeID: '',
        flightID: '',
        departureTime: '',
        boardingGate: '',
        price: '',
        delay: '',
        companyID: '',
    }
}
const showDialog = (row) => {
    dialogVisible.value = true;
    title.value = '编辑航班';
    addFlightData.value = row;
}
const showDelayDialog = (row) => {
    delayVisible.value = true;
    title.value = '航班延误';
    addFlightData.value = row;
}
import { flightListService, flightAddService, flightUpdateService, flightDeleteService, flightDelayService } from '@/api/airport_view'
const flightList = async () => {
    let result = await flightListService();
    flightData.value = result.data;

}
flightList();
import { ElMessage } from 'element-plus'
const addFlight = async () => {
    let result = await flightAddService(addFlightData.value);
    ElMessage.success(result.msg ? result.msg : '添加成功');
    dialogVisible.value = false;
    flightList();
}
const updateFlight = async () => {
    let result = await flightUpdateService(addFlightData.value);
    ElMessage.success(result.msg ? result.msg : '修改成功');
    dialogVisible.value = false;
    flightList();
}
import { ElMessageBox } from 'element-plus'
const flightDelete = async (row) => {
    ElMessageBox.confirm(
        '你确认要删除该航班信息吗?',
        '温馨提示',
        {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning',
        }
    )
        .then(async () => {
            //调用接口
            let result = await flightDeleteService(row.flightID);
            ElMessage({
                type: 'success',
                message: '删除成功',
            })
            //刷新列表
            flightList();
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
                <span>机场航班信息</span>
                <div class="extra">
                    <el-button type="primary"
                        @click="dialogVisible = true; title = '添加航班'; clearData()">添加航班</el-button>
                </div>
            </div>
        </template>
        <el-table :data="flightData" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="航线ID" prop="routeID"></el-table-column>

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
            <el-table-column label="总座位" prop="totalSeatCount"></el-table-column>
            <el-table-column lable="满座率" prop="fullSeatRate"></el-table-column>
            <el-table-column label="是否延误" prop="delay"></el-table-column>


            <el-table-column label="操作" width="150px">
                <template #default="{ row }">
                    <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                    <el-button :icon="Delete" circle plain type="danger" @click="flightDelete(row)">删除</el-button>
                    <el-button :icon="Delete" circle plain type="danger" @click="showDelayDialog(row)">延误</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 添加航班和编辑航班弹窗 -->
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addFlightData" lable-width="100px" style="padding-right: 30px;">
                <el-form-item label="航线ID" prop="routeID">
                    <el-input v-model="addFlightData.routeID" placeholder="请输入航线ID"></el-input>
                </el-form-item>
                <el-form-item label="航班ID" prop="flightID">
                    <el-input v-model="addFlightData.flightID" placeholder="请输入航班ID"></el-input>
                </el-form-item>
                <el-form-item label="起飞时间" prop="departureTime">
                    <el-input v-model="addFlightData.departureTime" placeholder="请输入起飞时间"></el-input>
                </el-form-item>
                <el-form-item label="检票口" prop="boardingGate">
                    <el-input v-model="addFlightData.boardingGate" placeholder="请输入检票口"></el-input>
                </el-form-item>
                <el-form-item label="价格" prop="price">
                    <el-input v-model="addFlightData.price" placeholder="请输入价格"></el-input>
                </el-form-item>
                <el-form-item label="机场ID" prop="airportID">
                    <el-input v-model="addFlightData.airportID" placeholder="请输入机场ID"></el-input>
                </el-form-item>
                <el-form-item label="是否延误" prop="delay">
                    <el-input v-model="addFlightData.delay" placeholder="请输入是否延误"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="title == '添加航班' ? addFlight() : updateFlight()"> 确 定</el-button>
                    <el-button @click="dialogVisible = false"> 取 消</el-button>
                </span>
            </template>
        </el-dialog>
        <!-- 延误弹窗 -->
        <el-dialog v-model="delayVisible" :title="title" width="30%">
            <el-form :model="addFlightData" lable-width="100px" style="padding-right: 30px;">
                <el-form-item label="延误的起飞时间" prop="departureTime">
                    <el-input v-model="addFlightData.departureTime" placeholder="请输入起飞时间"></el-input>
                </el-form-item>


            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="updateFlight()"> 确 定</el-button>
                    <el-button @click="delayVisible = false"> 取 消</el-button>
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