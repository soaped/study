# 数据库文档

**数据库名：** plink

**文档版本：** 1.0.0-SNAPSHOT

**文档描述：** 数据库文档生成

| 表名                  | 说明       |
| :---: | :---: |
| [job](#job) | 作业表 |
| [job_instance](#job_instance) | 作业实例表 |

**表名：** <a id="job">job</a>

**说明：** 作业表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       | ID  |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 作业名称  |
|  3   | description |   varchar   | 1024 |   0    |    N     |  N   |       | 作业描述  |
|  4   | type |   tinyint   | 4 |   0    |    N     |  N   |       | 作业类型  |
|  5   | client_version |   varchar   | 20 |   0    |    N     |  N   |       | 客户端版本  |
|  6   | config_json |   mediumtext   | 16777215 |   0    |    Y     |  N   |       | 作业配置  |
|  7   | last_instance_id |   bigint   | 20 |   0    |    Y     |  N   |       | 最新实例的ID  |
|  8   | last_status |   tinyint   | 4 |   0    |    Y     |  N   |       | 最新实例的状态  |
|  9   | last_app_id |   varchar   | 100 |   0    |    Y     |  N   |       | 最新实例的app_id  |
|  10   | last_start_time |   timestamp   | 19 |   0    |    Y     |  N   |       | 最新实例的开始时间  |
|  11   | last_stop_time |   timestamp   | 19 |   0    |    Y     |  N   |       | 最新实例的结束时间  |
|  12   | create_time |   timestamp   | 19 |   0    |    N     |  N   |   CURRENT_TIMESTAMP    | 记录的创建时间  |
|  13   | update_time |   timestamp   | 19 |   0    |    N     |  N   |   CURRENT_TIMESTAMP    | 记录的更新时间  |

**表名：** <a id="job_instance">job_instance</a>

**说明：** 作业实例表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       | ID  |
|  2   | job_id |   bigint   | 20 |   0    |    N     |  N   |       | 作业的ID,即job表的id  |
|  3   | config_json |   mediumtext   | 16777215 |   0    |    Y     |  N   |       | 实例启动时的镜像配置  |
|  4   | status |   tinyint   | 4 |   0    |    N     |  N   |       | 实例的状态  |
|  5   | app_id |   varchar   | 100 |   0    |    Y     |  N   |       | 实例的集群任务id  |
|  6   | start_time |   timestamp   | 19 |   0    |    Y     |  N   |       | 实例的开始时间  |
|  7   | stop_time |   timestamp   | 19 |   0    |    Y     |  N   |       | 实例的结束时间  |
|  8   | create_time |   timestamp   | 19 |   0    |    N     |  N   |   CURRENT_TIMESTAMP    | 记录的创建时间  |
|  9   | update_time |   timestamp   | 19 |   0    |    N     |  N   |   CURRENT_TIMESTAMP    | 记录的更新时间  |
