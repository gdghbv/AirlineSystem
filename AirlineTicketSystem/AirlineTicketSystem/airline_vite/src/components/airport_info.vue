<template>

  
    <el-descriptions
      class="margin-top"
      title="机场信息界面"
      :column="3"
    
      border
    >
      <template #extra>
        <el-button type="primary" @click="showDialog(row)">编辑</el-button>
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
        {{ airportData.airportName }}
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
        {{ airportData.airportPhone }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <tickets />
            </el-icon>
            AirportID
          </div>
        </template>
        <!-- <el-tag size="small">School</el-tag> -->
        {{ airportData.airportID }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <office-building />
            </el-icon>
            AirportAddress
          </div>
        </template>
        {{ airportData.airportAddress }}
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
        {{ airportData.email }}
      </el-descriptions-item>
    </el-descriptions>
  

    <el-dialog v-model="dialogVisible" :title="title" width="30%">
        <el-form :model="airportData" lable-width="100px" style="padding-right: 30px;">
            <el-form-item label="昵称" prop="airportName">
                <el-input v-model="updateAirportData.airportName" placeholder="请输入昵称"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="airportPhone">
                <el-input v-model="updateAirportData.airportPhone" placeholder="请输入电话"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="airportAddress">
                <el-input v-model="updateAirportData.airportAddress" placeholder="请输入地址"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="updateAirportData.email" placeholder="请输入邮箱"></el-input>
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button type="primary" @click="updateAirportInfo()"> 确 定</el-button>
                <el-button @click="dialogVisible = false"> 取 消</el-button>
            </span>
        </template>
    </el-dialog>


  </template>
  
  <script setup>




const dialogVisible = ref(false);
const title = ref('');




const airportData = ref({

    airportID: '111',
    airportName: '111',
    airportPhone: '111',
    airportAddress: '111',
    email: '111',
    password: '111',

}
);

const updateAirportData = ref([
    {
        airportName: '',
        airportPhone: '',
        airportAddress: '',
        email: '',
    }
])

const showDialog = (row) => {
    dialogVisible.value = true;
    title.value = '编辑信息';
    updateAirportData.value = airportData.value;
}


import { airportInfoService, updateAirportInfoService } from '@/api/airport_view'
const airportInfo = async () => {
    let result = await airportInfoService();
    airportData.value = result.data;

}
airportInfo();
import { ElMessage } from 'element-plus'
const updateAirportInfo = async () => {
    let result = await updateAirportInfoService(updateAirportData.value);
    ElMessage.success(result.msg ? result.msg : '修改成功');
    dialogVisible.value = false;
    airportInfo();
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