package com.soap.flink.sql;

import org.apache.calcite.avatica.util.Casing;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Planner;
import org.apache.calcite.tools.RelConversionException;
import org.apache.calcite.tools.ValidationException;

/**
 * @author yangfuzhao on 2020/9/6.
 */
public class CalciteTest {
    public static void main(String[] args) throws SqlParseException, ValidationException, RelConversionException {
        // 初始化配置
        SqlParser.ConfigBuilder configBuilder = SqlParser.configBuilder();
        configBuilder.setUnquotedCasing(Casing.UNCHANGED);

        //Sql解析：解析Sql语句，通过JavaCC解析成AST语法树，表现为SqlNode
//        SqlParser sqlParser = SqlParser.create(sql, configBuilder.build());
//        SqlNode sqlNode = sqlParser.parseQuery();
        //Sql校验：结合元数据信息验证Sql是否符合规范
//        Planner planner = Frameworks.getPlanner(config);
//        SqlNode node = planner.validate(sqlNode);
        //Sql查询优化：将SqlNode转换为LogicalPlan，表现为RelNode
//        RelRoot relRoot = planner.rel(node);
//        RelNode project = relRoot.project();

//        System.out.println(project);
    }
}
