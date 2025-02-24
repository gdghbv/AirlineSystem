<template>
    <div class="common-layout">
      <el-container class="layout-container">
        <el-header>机场菜单
          
        </el-header>
        <img src="../assets/blue.jpg" >
        <el-container>
          <el-aside width="200px">
            <div class="el-aside__logo"></div>
            <!-- element-plus的菜单标签 -->
            <el-empty 
            image="https://pic.imgdb.cn/item/675907ead0e0a243d4e1a6b6.gif"
            description=" "
            ></el-empty>
            <el-menu active-text-color="#ffd04b" background-color="#939393" text-color="#fff" router>
              <el-menu-item index="/airport/flight">
                <el-icon>
                  <Management />
                </el-icon>
                <span>航班管理</span>
              </el-menu-item>

              <el-menu-item index="/airport/aircraft">
                <el-icon>
                  <User />
                </el-icon>
                <span>飞机起降信息</span>
              </el-menu-item>

              <el-menu-item index="/airport/customer">
                <el-icon>
                  <User />
                </el-icon>
                <span>管理客户信息</span>
              </el-menu-item>

              <el-menu-item index="/airport/info">
                <el-icon>
                  <User />
                </el-icon>
                <span>机场信息</span>
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
      background-color: #939393;
  
      .el-menu {
        border-right: none;
        backdrop-filter: blur(10px);
      }
    }
  
  
  
  
  }
  </style>