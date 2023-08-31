package com.dsy.dubbomockserver.test;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * @Author: dongshuaiyin
 * @Description:
 * @Date: 2023/4/22 17:22
 * @Modified by:
 */
public class generator {


    public static void main(String[] args) {
        FastAutoGenerator.create(
                    new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/mock?serverTimezone=GMT%2B8&characterEncoding=UTF-8&allowMultiQueries=true", "root", "123$qwerasdf")
                            .typeConvert(new MySqlTypeConvert())
                )
                .globalConfig(builder -> {
                    builder.author("dongshuaiyin") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/dongshuaiyin/Documents/self/plugins/dubbo-mock-server/src/main/java/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.dsy.dubbomockserver") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/dongshuaiyin/Documents/self/plugins/dubbo-mock-server/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("mock_rule") // 设置需要生成的表名
                            .addTablePrefix(""); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
