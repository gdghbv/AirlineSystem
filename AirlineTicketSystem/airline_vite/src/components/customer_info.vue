<template>

  
    <el-descriptions
      class="margin-top"
      title="个人信息界面"
      :column="3"
   
      border
    >
      <template #extra>
        <el-button type="primary" @click="showDialog()">编辑</el-button>
      </template>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <user />
            </el-icon>
            Username
          </div>
        </template>
        {{ customerData.name }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <iphone />
            </el-icon>
            Phone
          </div>
        </template>
        {{ customerData.phone }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <location />
            </el-icon>
            Points
          </div>
        </template>
        {{ customerData.points }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <tickets />
            </el-icon>
            CitizenID
          </div>
        </template>
        <!-- <el-tag size="small">School</el-tag> -->
        {{ customerData.citizenID }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <office-building />
            </el-icon>
            Gender
          </div>
        </template>
        {{ customerData.gender }}
      </el-descriptions-item>

      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <office-building />
            </el-icon>
            Email
          </div>
        </template>
        {{ customerData.email }}
      </el-descriptions-item>
    </el-descriptions>
  

    <el-dialog v-model="dialogVisible" :title="title" width="30%">
        <el-form :model="customerData" lable-width="100px" style="padding-right: 30px;">
            <el-form-item label="昵称" prop="name">
                <el-input v-model="updateCustomerData.name" placeholder="请输入昵称"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="phone">
                <el-input v-model="updateCustomerData.phone" placeholder="请输入电话"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="gender">
                <el-input v-model="updateCustomerData.gender" placeholder="请输入性别"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="updateCustomerData.email" placeholder="请输入邮箱"></el-input>
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button type="primary" @click="updateCustomer()"> 确 定</el-button>
                <el-button @click="dialogVisible = false"> 取 消</el-button>
            </span>
        </template>
    </el-dialog>


  </template>
  
  <script setup>

const showDialog = () => {
    dialogVisible.value = true;
    title.value = '编辑信息';
    updateCustomerData.value = customerData.value;
}


const dialogVisible = ref(false);
const title = ref('');


const customerData = ref({

    citizenID: '111',
    name: '111',
    phone: '111',
    gender: '111',
    points: '111',
    email: '111',
    password: '111',

}
);

const updateCustomerData = ref([
    {
      name: '',
      phone: '',
      gender: '',
      email: '',
    
    }
])

import { customerInfoService, updateCustomerInfoService } from '@/api/customer_view';
const customerInfo = async () => {
    let result = await customerInfoService();
    customerData.value = result.data;

}
customerInfo();
import { ElMessage } from 'element-plus'
const updateCustomer = async () => {
    let result = await updateCustomerInfoService(updateCustomerData.value);
    ElMessage.success(result.msg ? result.msg : '修改成功');
    dialogVisible.value = false;
    customerInfo();
}


  import { computed, ref } from 'vue'
  import {
    Iphone,
    Location,
    OfficeBuilding,
    Tickets,
    User,
  } from '@element-plus/icons-vue'

  
  
  
  const iconStyle = computed(() => {
    const marginMap = {
      large: '8px',
      default: '6px',
      small: '4px',
    }
    return {
      marginRight: marginMap.default,
    }
  })
  const blockMargin = computed(() => {
    const marginMap = {
      large: '32px',
      default: '28px',
      small: '24px',
    }
    return {
      marginTop: marginMap.default,
    }
  })
  </script>
  
  <style scoped>
  .el-descriptions {
    margin-top: 20px;
  }
  .cell-item {
    display: flex;
    align-items: center;
  }
  .margin-top {
    margin-top: 20px;
  }
  </style>