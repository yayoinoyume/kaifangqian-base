# 资助审批电子签章系统

## 项目说明

本项目是基于开源电子签章项目 **开放签（kaifangqian）** 二次开发的个人学习项目，用于**贫困生资助审批表的三方签署**场景。

- **用途**：贫困生资助审批表由学生、学校、资助管理方等多方在线填写与签署。
- **性质**：仅用于个人学习交流，不作商业用途，不对外提供服务。
- **来源**：fork 自开放签（kaifangqian）开源项目，在其基础上完成品牌标识替换与业务适配。

> 说明：本项目仅用于个人学习，暂不考虑开源协议义务；上游项目采用 AGPLv3 协议。

## 技术架构

本项目采用现代化前后端分离架构，整体设计兼顾技术透明性与可信度，支持私有化部署、多租户服务和标准化 API 接入。
架构设计遵循模块化、高内聚低耦合原则，便于二次开发、功能扩展及集成对接。

- **前端框架**:Vue 3 + Vite
- **后端语言**:Java（JDK 1.8+）
- **后端框架**:Spring Boot + Spring Security + MyBatis Plus
- **文件处理**:Apache PDFBox 实现 PDF 文档操作
- **数据库**:MySQL / PostgreSQL（支持国产数据库适配）
- **部署方式**:支持 Docker 容器化部署
- **接口规范**:RESTful API
- **日志系统**:Logback + ELK 可视化日志分析
- **权限控制**:RBAC 模型 + JWT 认证机制

## 核心功能

- **文件在线签发**:支持 Web、H5、API 多端签署各类文件（如审批文件、证明、电子合同等）。
- **印章管理**:支持印章全生命周期管理（新增、编辑、停用、销毁等），支持三权分立机制。
- **组织及权限管理**:支持平台多租户、组织架构、成员、角色及权限管理。
- **业务线管理**:通过业务线配置可构建多种电子文件签署场景，灵活规范、风险可控。
- **自定义签署文档模板**:提供在线模板功能，签署过程可使用模板完成多方填写和确认。
- **安全合规认证**:结合国密算法加密、签名，确保签署流程可追溯、防篡改。

## 代码结构

```
kaifangqian-base/
├── kaifangqian-parent/         # 后端项目根目录
│   ├── kaifangqian-core/       # 核心模块
│   ├── kaifangqian-system/     # 系统模块
│   ├── kaifangqian-tools/      # 工具模块
│   └── sql/                    # 数据库脚本
├── kaifangqian-web/            # 前端项目根目录
│   ├── opensign-manage/        # 管理后台
│   ├── opensign-message/       # 消息服务
│   ├── opensign-mobile/        # 移动端应用
│   ├── opensign-tenant/        # 租户管理
│   └── opensign-web/           # 签署主应用
├── deploy/                     # 本地 Docker 部署脚本与配置
└── README.md                   # 项目说明文档
```

## 本地运行

### [启动后端](./kaifangqian-parent/README.md)
### [启动前端](./kaifangqian-web/README.md)

# 系统部署

## 环境要求
- **JDK**: 1.8+ (小于17)
- **Maven**: 3.x
- **MySQL**: 5.7+
- **Redis**: 任意版本
- **Node**: 16
- **IDE**: IntelliJ IDEA (必须安装 Lombok 插件)

**推荐 Linux 系统，服务器配置 4 核 8G**

- 本地 Docker 部署：见 [deploy/setup.md](./deploy/setup.md)
- 原生部署：下载源码后自行打包，参考后端 / 前端启动说明

# 许可证

本项目基于上游开源项目（AGPLv3）二次开发，仅用于个人学习交流，暂不考虑开源协议义务。

# 🙏 致谢

感谢以下开源项目为本项目提供支持：

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MyBatis Plus](https://baomidou.com/)
- [Apache PDFBox](https://pdfbox.apache.org/)
- [Apache Shiro](https://shiro.apache.org/)
- [Redisson](https://redisson.org/)
