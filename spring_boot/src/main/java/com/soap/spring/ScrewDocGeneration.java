package com.soap.spring;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author yangfuzhao on 2020/12/21.
 */
public class ScrewDocGeneration {

    public static void main(String[] args) throws SQLException {
        String fileOutputDir = "/Users/soapy/IdeaProjects/study/spring_boot/src/main/resources/doc/doris";
        //数据源
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
//        hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/plink");
//        hikariConfig.setUsername("root");
//        hikariConfig.setPassword("123456");

        //rtstat
//        hikariConfig.setJdbcUrl("jdbc:mysql://10.25.178.34:5002/rtstat");
//        hikariConfig.setUsername("rtstat_test_jty");
//        hikariConfig.setPassword("3Lvt0jMUaV2jGs");

        //doris
        hikariConfig.setJdbcUrl("jdbc:mysql://gh-data-olap-experiment-test01.corp.sankuai.com:8080/caterb2b_rt");
        hikariConfig.setUsername("caterb2b_rt");
        hikariConfig.setPassword("8qlFwe7abPYTBxeE");


        //设置可以获取tables remarks信息
        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
//        hikariConfig.setMinimumIdle(2);
//        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        //生成配置
        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir(fileOutputDir)
                //打开目录
                .openOutputDir(true)
                //文件类型
                .fileType(EngineFileType.MD)
                //生成模板实现
                .produceType(EngineTemplateType.freemarker)
                //自定义文件名称
                .fileName("实时数仓-Doris").build();

        //忽略表
        ArrayList<String> ignoreTableName = new ArrayList<>();
        ignoreTableName.add("test_user");
        ignoreTableName.add("test_user");
        //忽略表前缀
        ArrayList<String> ignorePrefix = new ArrayList<>();
        ignorePrefix.add("test_");
        //忽略表后缀
        ArrayList<String> ignoreSuffix = new ArrayList<>();
        ignoreSuffix.add("_test");
        ProcessConfig processConfig = ProcessConfig.builder()
                //指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
                //根据名称指定表生成
                .designatedTableName(Lists.newArrayList("app_caterb2b_byr_deal__dt_wk_mo_csu_cat_byr_city_1"))
                //根据表前缀生成
                .designatedTablePrefix(new ArrayList<>())
                //根据表后缀生成
                .designatedTableSuffix(new ArrayList<>())
                //忽略表名
                .ignoreTableName(ignoreTableName)
                //忽略表前缀
                .ignoreTablePrefix(ignorePrefix)
                //忽略表后缀
                .ignoreTableSuffix(ignoreSuffix).build();
        //配置
        Configuration config = Configuration.builder()
                //版本
                .version("1.0.0")
                //描述
                .description("doris")
                //数据源
                .dataSource(dataSource)
                //生成配置
                .engineConfig(engineConfig)
                //生成配置
                .produceConfig(processConfig)
                .build();
        //执行生成
        new DocumentationExecute(config).execute();

    }
}
