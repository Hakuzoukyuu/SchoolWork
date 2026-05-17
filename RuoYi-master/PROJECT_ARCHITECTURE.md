# 校园管理系统 - 项目架构文档

## 项目概述

本项目是基于若依框架（RuoYi v4.8.3）开发的校园综合管理系统，集成了学生管理、教职工管理、后勤管理、资产管理、AI智能助手、数据可视化等核心功能，为学校提供一站式信息化解决方案。

## 技术栈

### 后端技术
| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 4.0.3 | 核心框架 |
| JDK | 17+ | 开发环境 |
| MyBatis | 4.0.1 | ORM框架 |
| Shiro | 2.1.0 | 安全框架 |
| Druid | 1.2.28 | 数据库连接池 |
| Thymeleaf | - | 模板引擎 |
| PageHelper | 2.1.1 | 分页插件 |
| LangChain4j | 1.0.0-beta1 | AI集成框架 |

### 前端技术
| 技术 | 版本 | 说明 |
|------|------|------|
| jQuery | 1.12.4 | JavaScript框架 |
| Bootstrap | 3.3.7 | UI框架 |
| ECharts | - | 数据可视化 |
| Font Awesome | 4.7.0 | 图标库 |
| Layer | - | 弹窗组件 |

### AI技术
| 技术 | 版本 | 说明 |
|------|------|------|
| Ollama | - | 本地大模型部署 |
| Qwen3.5:9b | - | 对话大模型 |
| nomic-embed-text | - | 嵌入模型 |

## 项目模块结构

```
RuoYi-master/
├── ruoyi-admin/          # 管理后台模块（Web层）
├── ruoyi-framework/      # 框架核心模块
├── ruoyi-system/         # 系统业务模块
├── ruoyi-common/         # 公共工具模块
├── ruoyi-quartz/         # 定时任务模块
├── ruoyi-generator/      # 代码生成模块
├── ruoyi-ai/            # AI智能助手模块
└── ruoyi-visual/        # 数据可视化模块
```

## 模块详细说明

### 1. ruoyi-admin（管理后台模块）
**职责**：Web层，处理HTTP请求，提供RESTful API和页面路由

**主要包结构**：
```
com.ruoyi.web.controller/
├── ai/                    # AI相关控制器
│   ├── CampusAssistantController.java    # AI问答接口
│   └── CampusChatController.java         # 聊天页面路由
├── system/                # 系统业务控制器
│   ├── StudentController.java            # 学生管理
│   ├── StaffInfoController.java          # 教职工管理
│   ├── DormDormitoryController.java      # 宿舍管理
│   ├── CanteenStallController.java       # 食堂档口管理
│   ├── AssetManagementController.java   # 资产管理
│   └── ...
├── monitor/               # 系统监控控制器
│   ├── CacheController.java              # 缓存监控
│   └── DruidController.java             # 数据库监控
└── common/                # 通用控制器
    └── CommonController.java            # 文件上传等通用功能
```

**核心功能**：
- 接收前端HTTP请求
- 调用Service层处理业务逻辑
- 返回JSON数据或页面视图
- 处理文件上传、下载等操作

### 2. ruoyi-system（系统业务模块）
**职责**：业务逻辑层，实现具体的业务功能

**主要包结构**：
```
com.ruoyi.system/
├── domain/                # 实体类
│   ├── Student.java                      # 学生实体
│   ├── StaffInfo.java                    # 教职工实体
│   ├── DormDormitory.java                # 宿舍实体
│   ├── CanteenStall.java                 # 食堂档口实体
│   └── ...
├── service/               # 服务接口
│   ├── IStudentService.java             # 学生服务接口
│   ├── IStaffInfoService.java           # 教职工服务接口
│   └── ...
├── service/impl/          # 服务实现
│   ├── StudentServiceImpl.java         # 学生服务实现
│   ├── StaffInfoServiceImpl.java       # 教职工服务实现
│   └── ...
└── mapper/                # 数据访问层
    ├── StudentMapper.java               # 学生Mapper
    ├── StaffInfoMapper.java             # 教职工Mapper
    └── ...
```

**核心功能**：
- 实现业务逻辑
- 数据验证和处理
- 调用Mapper层进行数据库操作
- 事务管理

### 3. ruoyi-framework（框架核心模块）
**职责**：提供框架级别的核心功能和配置

**主要功能**：
- Shiro安全配置（认证、授权）
- 拦截器配置
- 全局异常处理
- 跨域配置
- Redis缓存配置

### 4. ruoyi-common（公共工具模块）
**职责**：提供公共工具类和常量定义

**主要功能**：
- 通用工具类（字符串、日期、文件等）
- 常量定义
- 枚举类型
- 注解定义

### 5. ruoyi-quartz（定时任务模块）
**职责**：提供定时任务调度功能

**主要功能**：
- 定时任务管理
- 任务执行日志
- Cron表达式解析

### 6. ruoyi-generator（代码生成模块）
**职责**：根据数据库表结构生成代码

**主要功能**：
- 生成实体类
- 生成Mapper接口
- 生成Service接口和实现
- 生成Controller
- 生成前端页面

### 7. ruoyi-ai（AI智能助手模块）
**职责**：集成大语言模型，提供智能问答功能

**技术架构**：
```
┌─────────────────────────────────────────────────────────┐
│                    ruoyi-ai 模块                         │
├─────────────────────────────────────────────────────────┤
│  AiConfig.java              ← 配置 Ollama 连接           │
│    ├── chatLanguageModel()      → OllamaChatModel       │
│    ├── embeddingModel()         → OllamaEmbeddingModel  │
│    └── embeddingStore()         → InMemoryEmbeddingStore│
├─────────────────────────────────────────────────────────┤
│  CampusAssistantService.java ← 核心服务（RAG问答）       │
│    └── answer(String question) → 处理用户问题           │
├─────────────────────────────────────────────────────────┤
│  DocumentIngestionService.java ← 文档上传服务           │
│    └── ingest(InputStream, String) → 文档入库          │
├─────────────────────────────────────────────────────────┤
│  KnowledgeBaseInitializer.java ← 知识库初始化            │
└─────────────────────────────────────────────────────────┘
```

**核心流程**：
```
1. 文档上传
   ┌──────────┐    ┌──────────────┐    ┌───────────────┐
   │ PDF/Word │───>│ 文本提取(Tika) │───>│ 嵌入模型向量化 │
   └──────────┘    └──────────────┘    └───────┬───────┘
                                            │
                                            ▼
                                   ┌─────────────────┐
                                   │ InMemoryStore   │
                                   │ (内存向量库)    │
                                   └─────────────────┘

2. 用户问答
   ┌──────────┐    ┌──────────────┐    ┌───────────────┐
   │ 用户问题 │───>│ 嵌入模型向量化 │───>│ 向量相似度检索 │
   └──────────┘    └──────────────┘    └───────┬───────┘
                                            │
                                            ▼
                                   ┌─────────────────┐
                                   │  qwen3.5:9b     │
                                   │ (生成回答)       │
                                   └─────────────────┘
```

**API接口**：
- `POST /api/ai/assistant/chat` - AI问答接口
- `POST /api/ai/assistant/document/upload` - 文档上传接口
- `GET /ai/chat/page` - 聊天页面

### 8. ruoyi-visual（数据可视化模块）
**职责**：为各业务模块提供数据可视化功能

**技术架构**：
```
┌─────────────────────────────────────────────────────────┐
│                   ruoyi-visual 模块                       │
├─────────────────────────────────────────────────────────┤
│  IVisualService.java         ← 可视化服务接口            │
│    ├── getStudentChartData()     → 学生数据统计         │
│    ├── getStaffChartData()       → 教职工数据统计       │
│    ├── getDormChartData()        → 宿舍数据统计         │
│    ├── getStallChartData()       → 食堂档口数据统计     │
│    └── getAvailableDataTypes()   → 获取可用数据类型    │
├─────────────────────────────────────────────────────────┤
│  VisualServiceImpl.java      ← 可视化服务实现            │
│    ├── 数据类型映射（DATA_TYPE_MAP）                   │
│    ├── 统计方法（statisticsByXxx）                       │
│    └── 图表数据组装                                     │
├─────────────────────────────────────────────────────────┤
│  VisualController.java       ← 可视化控制器              │
│    ├── GET /visual/student/chart   → 学生图表数据      │
│    ├── GET /visual/staff/chart     → 教职工图表数据    │
│    ├── GET /visual/dorm/chart      → 宿舍图表数据      │
│    └── GET /visual/stall/chart     → 食堂档口图表数据  │
└─────────────────────────────────────────────────────────┘
```

**支持的图表类型**：
- 饼图（Pie Chart）
- 柱状图（Bar Chart）

**已集成模块**：
- 学生管理（按性别、学院、专业等统计）
- 教职工管理（按性别、部门、职称等统计）
- 宿舍管理（按宿舍类型、楼栋等统计）
- 食堂档口管理（按所属食堂、卫生状态等统计）

## 业务功能模块

### 1. 学生信息管理
- 学生基础档案管理
- 学籍信息管理
- 家庭信息管理
- 心理健康管理
- 道德评价管理
- 学业成绩管理
- 实习就业管理
- 缴费信息管理
- 宿舍分配管理

### 2. 教职工信息管理
- 教职工基础档案管理
- 考勤管理
- 调动管理
- 绩效考核管理

### 3. 后勤管理
- 宿舍管理
  - 宿舍信息管理
  - 床位管理
  - 宿舍分配
- 食堂管理
  - 食堂档口管理
  - 菜品管理
- 报修管理

### 4. 资产管理
- 资产信息管理
- 资产分类管理
- 资产借用管理

### 5. 办公管理
- 通知公告管理
- 文档管理
- 会议管理
- 工作计划管理
- 财务审批管理

### 6. 招生就业
- 招生录取管理
- 企业合作管理

### 7. 社团管理
- 社团信息管理
- 社团成员管理

### 8. 学院管理
- 学院信息管理
- 班级管理

### 9. AI智能助手
- 基于RAG的智能问答
- 文档知识库管理
- 校园规章制度查询
- 通用对话功能

### 10. 数据可视化
- 学生数据统计图表
- 教职工数据统计图表
- 宿舍数据统计图表
- 食堂档口数据统计图表

## 系统架构设计

### 分层架构
```
┌─────────────────────────────────────────────────────────┐
│                    表现层（View Layer）                   │
│  Thymeleaf模板 + jQuery + Bootstrap + ECharts           │
└─────────────────────────────────────────────────────────┘
                           │
                           ▼
┌─────────────────────────────────────────────────────────┐
│                    控制层（Controller Layer）              │
│  Spring MVC Controller (@RestController)                │
└─────────────────────────────────────────────────────────┘
                           │
                           ▼
┌─────────────────────────────────────────────────────────┐
│                    业务层（Service Layer）                │
│  Service接口 + ServiceImpl实现类                          │
└─────────────────────────────────────────────────────────┘
                           │
                           ▼
┌─────────────────────────────────────────────────────────┐
│                    持久层（Mapper Layer）                 │
│  MyBatis Mapper接口 + XML映射文件                        │
└─────────────────────────────────────────────────────────┘
                           │
                           ▼
┌─────────────────────────────────────────────────────────┐
│                    数据层（Database Layer）               │
│  MySQL数据库                                              │
└─────────────────────────────────────────────────────────┘
```

### 安全架构
```
┌─────────────────────────────────────────────────────────┐
│                    Shiro安全框架                          │
├─────────────────────────────────────────────────────────┤
│  认证（Authentication）                                   │
│    ├── 用户登录验证                                       │
│    ├── Session管理                                        │
│    └── 记住我功能                                         │
├─────────────────────────────────────────────────────────┤
│  授权（Authorization）                                    │
│    ├── 角色权限管理                                       │
│    ├── 菜单权限控制                                       │
│    ├── 按钮权限控制                                       │
│    └── 数据权限控制                                       │
├─────────────────────────────────────────────────────────┤
│  加密（Cryptography）                                     │
│    ├── 密码加密（BCrypt）                                 │
│    └── 验证码生成                                         │
└─────────────────────────────────────────────────────────┘
```

## 数据库设计

### 核心表结构
| 表名 | 说明 |
|------|------|
| sys_user | 用户表 |
| sys_role | 角色表 |
| sys_menu | 菜单表 |
| sys_dept | 部门表 |
| sys_post | 岗位表 |
| student | 学生表 |
| staff_info | 教职工表 |
| dorm_dormitory | 宿舍表 |
| dorm_bed | 床位表 |
| canteen_stall | 食堂档口表 |
| canteen_dish | 菜品表 |
| asset_management | 资产表 |
| repair_report | 报修表 |
| club | 社团表 |
| class_management | 班级表 |
| college_info | 学院表 |

## 配置说明

### Ollama配置
```yaml
ollama:
  base:
    url: http://localhost:11434    # Ollama服务地址
  chat:
    model: qwen3.5:9b              # 对话模型
  embedding:
    model: nomic-embed-text        # 嵌入模型
```

### 数据库配置
```yaml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ry-vue?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
    username: root
    password: password
```

## 部署说明

### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Ollama（可选，用于AI功能）

### 启动步骤
1. 克隆项目到本地
2. 导入数据库脚本
3. 修改配置文件（数据库、Ollama等）
4. 执行 `mvn clean package` 打包
5. 运行 `RuoYiApplication` 启动项目
6. 访问 `http://localhost:8080`

### 默认账号
- 用户名：admin
- 密码：admin123

## 开发规范

### 代码分层
- Controller层：处理HTTP请求，参数验证
- Service层：业务逻辑处理
- Mapper层：数据库操作
- Domain层：实体类定义

### 命名规范
- 类名：大驼峰命名法（PascalCase）
- 方法名：小驼峰命名法（camelCase）
- 常量：全大写下划线分隔（UPPER_SNAKE_CASE）
- 包名：全小写点分隔

### 注释规范
- 类注释：说明类的功能和职责
- 方法注释：说明方法的功能、参数、返回值
- 关键代码：添加必要的行内注释

## 扩展开发

### 添加新模块
1. 创建实体类（Domain）
2. 创建Mapper接口
3. 创建Service接口和实现类
4. 创建Controller
5. 创建前端页面
6. 配置菜单和权限

### 集成新功能
1. 在相应模块下创建包结构
2. 实现业务逻辑
3. 配置路由和权限
4. 编写单元测试

## 技术支持

- 若依官方文档：http://doc.ruoyi.vip
- Spring Boot文档：https://spring.io/projects/spring-boot
- MyBatis文档：https://mybatis.org/mybatis-3/
- Shiro文档：https://shiro.apache.org/
- LangChain4j文档：https://docs.langchain4j.dev/

## 版本历史

| 版本 | 日期 | 说明 |
|------|------|------|
| 4.8.3 | 2026-05-13 | 基于若依框架开发，集成AI和可视化功能 |

## 许可证

本项目基于若依框架开发，遵循MIT许可证。
