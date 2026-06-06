# 老旧小区改造全流程管控系统

## 项目简介

老旧小区改造全流程管控系统是一套面向城市更新和老旧小区改造领域的数字化管理平台。系统覆盖改造项目从立项审批到维保回访的全生命周期，帮助政府部门和施工单位实现改造工作的规范化、透明化和可追溯化管理。

## 适用场景

- 城市更新管理部门对老旧小区改造项目的全流程监管
- 街道办事处/社区居委会组织住户征询和意见收集
- 施工单位进行施工节点管理和材料验收记录
- 物业公司进行改造档案管理和维保回访跟踪
- 第三方监理机构进行施工质量监督和验收

## 核心功能

### 1. 改造立项管理
- 改造项目信息录入（名称、地址、预算、户数等）
- 项目状态流转（立项中→征询中→进行中→已完工→已完成）
- 项目信息编辑和查询

### 2. 住户征询管理
- 逐户征询记录（住户信息、意见、状态）
- 征询意见统计（同意/反对/弃权）
- 征询进度跟踪

### 3. 施工节点管理
- 施工节点创建和分类（基础工程/主体工程/装饰工程/安装工程/验收阶段）
- 计划与实际时间对比
- 节点状态跟踪（未开始/进行中/已暂停/已完成）

### 4. 材料验收管理
- 材料信息登记（名称、规格、品牌、数量、单价）
- 验收结果记录（合格/不合格/待检验）
- 关联施工节点

### 5. 改造档案留存
- 档案分类管理（立项文件/征询文件/施工方案/验收文件/影像资料）
- 档案信息记录和查询
- 档案与项目关联

### 6. 维保回访管理
- 回访类型管理（质保回访/维修回访/满意度调查/投诉处理）
- 回访结果记录（满意/基本满意/不满意）
- 下次回访计划安排

### 7. 系统仪表盘
- 项目总数、进行中、已完成统计
- 各模块数据汇总
- 项目列表快速查看

## 技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 17 | 开发语言 |
| Spring Boot | 3.2.5 | 应用框架 |
| Spring Security | 6.x | 安全认证 |
| Spring Data JPA | 3.x | 数据访问 |
| Thymeleaf | 3.x | 模板引擎 |
| H2 Database | 2.x | 嵌入式数据库 |
| Maven | 3.9 | 构建工具 |
| Docker | - | 容器化部署 |

## 目录结构

```
renovation-manage/
├── Dockerfile                    # Docker构建文件
├── rule.md                       # 项目规范
├── prompts.csv                   # 提示词配置
├── publish_private_github.sh     # GitHub发布脚本
├── .github.env.example           # 环境变量示例
├── .gitignore                    # Git忽略配置
├── ssh_plugin/                   # SSH插件
│   ├── entrypoint.sh
│   └── install_ssh.sh
└── repo/                         # 项目源码
    ├── pom.xml                   # Maven配置
    ├── .gitignore
    ├── README.md
    └── src/
        └── main/
            ├── java/com/renovation/manage/
            │   ├── RenovationManageApplication.java
            │   ├── config/               # 配置类
            │   │   ├── SecurityConfig.java
            │   │   └── WebConfig.java
            │   ├── controller/           # 控制器
            │   │   ├── AuthController.java
            │   │   ├── ProjectController.java
            │   │   ├── ConsultationController.java
            │   │   ├── ConstructionController.java
            │   │   ├── MaterialController.java
            │   │   ├── ArchiveController.java
            │   │   ├── MaintenanceController.java
            │   │   └── DashboardController.java
            │   ├── model/                # 实体类
            │   │   ├── User.java
            │   │   ├── RenovationProject.java
            │   │   ├── Consultation.java
            │   │   ├── ConstructionNode.java
            │   │   ├── MaterialAcceptance.java
            │   │   ├── Archive.java
            │   │   └── MaintenanceVisit.java
            │   ├── repository/           # 数据访问层
            │   ├── service/              # 业务逻辑层
            │   └── dto/                  # 数据传输对象
            └── resources/
                ├── application.properties
                ├── data.sql              # 种子数据
                ├── templates/            # Thymeleaf模板
                └── static/               # 静态资源
                    ├── css/style.css
                    └── js/main.js
```

## Docker启动方式

### 构建镜像

```bash
cd renovation-manage
docker build -t renovation-manage .
```

### 运行容器

```bash
docker run -d -p 8080:8080 --name renovation-manage renovation-manage
```

### 带SSH插件运行

```bash
docker run -d \
  -p 8080:8080 \
  -p 2222:22 \
  -e SSH_PUBLIC_KEY="ssh-rsa AAAA..." \
  --name renovation-manage \
  renovation-manage
```

### 访问系统

浏览器打开 `http://localhost:8080`

## 本地启动方式

### 前置条件

- JDK 17+
- Maven 3.9+

### 启动步骤

```bash
cd renovation-manage/repo
mvn clean package -DskipTests
java -jar target/renovation-manage-1.0.0.jar
```

或使用开发模式：

```bash
cd renovation-manage/repo
mvn spring-boot:run
```

### 访问系统

- 系统首页：`http://localhost:8080`
- H2控制台：`http://localhost:8080/h2-console`
  - JDBC URL：`jdbc:h2:file:./data/renovation`
  - 用户名：`sa`
  - 密码：（空）

## 默认账号

| 用户名 | 密码 | 角色 | 姓名 |
|--------|------|------|------|
| admin | admin123 | ADMIN | 系统管理员 |

## 可扩展方向

1. **文件上传功能**：集成对象存储（MinIO/OSS），实现档案文件的真实上传和下载
2. **审批流程引擎**：引入Activiti/Flowable，实现改造项目的多级审批流程
3. **数据可视化**：集成ECharts，实现项目进度甘特图、征询结果饼图等可视化展示
4. **消息通知**：集成短信/邮件/微信通知，实现征询提醒、施工通知、回访提醒
5. **移动端适配**：开发小程序或APP，方便住户在线征询和查看改造进度
6. **GIS地图集成**：在地图上展示改造项目分布，支持区域统计分析
7. **数据导出**：支持征询结果、材料清单、验收报告等PDF/Excel导出
8. **多租户支持**：支持多个街道/区县独立使用，数据隔离
9. **审计日志**：记录所有关键操作的审计轨迹，满足监管要求
10. **接口开放**：提供RESTful API，与政务系统、物业系统对接
