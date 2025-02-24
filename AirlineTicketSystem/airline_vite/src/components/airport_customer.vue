<script setup>
import { ref, } from 'vue';
const title = ref('');
const dialogVisible = ref(false);
const customerData = ref([{
    email: '',
    citizenID: '',
    name: '',
    phone: '',
    points: '',
    gender: '',


}
]);
const addCustomerData = ref([
    {
        points: '',
        phone: '',
    }
])
const clearData = () => {
    addCustomerData.value = {
        points: '',
        phone: '',
    }
}
const showDialog = (row) => {
    dialogVisible.value = true;
    title.value = '编辑用户信息';
    addCustomerData.value = row;
}
import { customerDeleteService, customerListService, customerUpdateService } from '@/api/airport_view'
const customerList = async () => {
    let result = await customerListService();
    customerData.value = result.data;

}
customerList();
import { ElMessage } from 'element-plus'
const updateCustomer = async () => {
    let result = await customerUpdateService(addCustomerData.value);
    ElMessage.success(result.msg ? result.msg : '修改成功');
    dialogVisible.value = false;
    customerList();
}
import { ElMessageBox } from 'element-plus'
import { generateCodeFrame } from 'vue/compiler-sfc';

const customerDelete = async (row) => {
    ElMessageBox.confirm(
        '你确认要删除该用户信息吗?',
        '温馨提示',
        {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning',
        }
    )
        .then(async () => {
            //调用接口
            let result = await customerDeleteService(row.customerID);
            ElMessage({
                type: 'success',
                message: '删除成功',
            })
            //刷新列表
            customerList();
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
                <span>客户信息列表</span>
              
            </div>
        </template>
        <el-table :data="customerData" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
             <el-table-column label="客户邮箱" prop="email"></el-table-column>
          <el-table-column label="客户ID" prop="citizenID"></el-table-column>
          <el-table-column label="客户姓名" prop="name"></el-table-column>
          <el-table-column label="客户性别" prop="gender"></el-table-column>
          <el-table-column label="客户手机号" prop="phone"></el-table-column>
          <el-table-column label="积分" prop="points"></el-table-column>



            <el-table-column label="操作">
                <template #default="{ row }">
                    <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                    <el-button :icon="Delete" circle plain type="danger" @click="customerDelete(row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addCustomerData" lable-width="100px" style="padding-right: 30px;">
                <el-form-item label="客户积分">
                    <el-input v-model="addCustomerData.points" placeholder="请输入客户积分"></el-input>
                </el-form-item>
                <el-form-item label="客户手机号">
                    <el-input v-model="addCustomerData.phone" placeholder="请输入客户手机号"></el-input>
                </el-form-item>
                </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="updateCustomer()"> 确定</el-button>
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