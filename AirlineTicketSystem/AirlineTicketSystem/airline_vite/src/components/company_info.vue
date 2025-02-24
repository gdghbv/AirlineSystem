<template>

  
    <el-descriptions
      class="margin-top"
      title="公司信息界面"
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
            CompanyName
          </div>
        </template>
        {{ companyData.companyName }}
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
        {{ companyData.phone }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <location />
            </el-icon>
            CompanyAddress
          </div>
        </template>
        {{ companyData.companyAddress }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div class="cell-item">
            <el-icon :style="iconStyle">
              <tickets />
            </el-icon>
            CompanyID
          </div>
        </template>
        <!-- <el-tag size="small">School</el-tag> -->
        {{ companyData.companyID }}
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
        {{ companyData.email }}
      </el-descriptions-item>
    </el-descriptions>
  

    <el-dialog v-model="dialogVisible" :title="title" width="30%">
        <el-form :model="companyData" lable-width="100px" style="padding-right: 30px;">
            <el-form-item label="公司名称" prop="companyName">
                <el-input v-model="updateCompanyData.companyName" placeholder="请输入公司名称"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="phone">
                <el-input v-model="updateCompanyData.phone" placeholder="请输入电话"></el-input>
            </el-form-item>
            <el-form-item label="地址" prop="companyAddress">
                <el-input v-model="updateCompanyData.companyAddress" placeholder="请输入地址"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="updateCompanyData.email" placeholder="请输入邮箱"></el-input>
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button type="primary" @click="updateCompany()"> 确 定</el-button>
                <el-button @click="dialogVisible = false"> 取 消</el-button>
            </span>
        </template>
    </el-dialog>


  </template>
  
  <script setup>

const showDialog = (row) => {
    dialogVisible.value = true;
    title.value = '编辑信息';
    updateCompanyData.value = companyData.value;
}


const dialogVisible = ref(false);
const title = ref('');


const companyData = ref({

    companyID: '111',
    companyName: '111',
    phone: '111',
    companyAddress: '111',
    email: '111',
    password: '111',

}
);

const updateCompanyData = ref([
    {
        companyName: '',
        phone: '',
        companyAddress: '',
        email: '',
    }
])

import { companyInfoService, updateCompanyInfoService } from '@/api/company_view.js'
const companyInfo = async () => {
    let result = await companyInfoService();
   companyData.value = result.data;

}
companyInfo();
import { ElMessage } from 'element-plus'
const updateCompany = async () => {
    let result = await updateCompanyInfoService(updateCompanyData.value);
    ElMessage.success(result.msg ? result.msg : '修改成功');
    dialogVisible.value = false;
    companyInfo();
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