<template>
    <div class="common-layout">
      <el-container class="layout-container">
        <el-header>航空公司菜单</el-header>
        <img src="../assets/blue.jpg">
        <el-container>
          <el-aside width="200px">
            <div class="el-aside__logo"></div>
            <!-- element-plus的菜单标签 -->
            <el-empty 
            image="https://pic.imgdb.cn/item/675907ead0e0a243d4e1a6b6.gif"
            description=" "
            ></el-empty>
            <el-menu active-text-color="#ffd04b" background-color="#232323" text-color="#fff" router>
              <el-menu-item index="/customer/ticket">
                <el-icon>
                  <Management />
                </el-icon>
                <span>订购机票</span>
              </el-menu-item>
              <el-menu-item index="/customer/bill">
                <el-icon>
                  <Promotion />
                </el-icon>
                <span>订单</span>
              </el-menu-item>
              <el-menu-item index="/customer/info">
                <el-icon>
                  <User />
                </el-icon>
                <span>个人信息</span>
              </el-menu-item>

              <el-menu-item >
                <el-icon>
                  <Logout />
                </el-icon>
                <span>退出登录</span>
              </el-menu-item>
            </el-menu>
          </el-aside>
          <el-main>
          <router-view></router-view>
            
          </el-main>
        </el-container>
      </el-container>
    </div>
  </template>
  
  <style lang="scss" scoped>
  .layout-container {
    height: 100vh;
  
    .el-aside {
      background-color: #1f84c3;
  
      .el-menu {
        border-right: none;
      }
    }
  
  
  
  
  }
  </style>