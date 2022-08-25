import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.junit.Test;

import java.util.Collections;

public class AutoCoding {

    //测试如何获取文件的路径
    @Test
    public void pathTest(){
        System.out.println(System.getProperty("user.dir"));
        //D:\TemporaryDev\mybatisPlusStudy
        //得到的项目的根目录
    }

    @Test
    public void myAutoCoding(){
        final String outPath=System.getProperty("user.dir")+"/src/main/java";

        FastAutoGenerator.create(
                "jdbc:mysql://localhost:3306/mybaitsplusstudy?useSSL=true&useUnicode=true&serverTimezone=UCT"
                        , "root"
                        , "123456")
                .globalConfig(builder -> {
                    builder.author("xuanxie") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(outPath); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.autocode") // 设置父包名
           //                 .moduleName("system") // 设置父包模块名
                            .entity("pojo");
             //               .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }





    //用户模仿的类
    public void referenceAutoCoding(){
        //获取当前模块所在的路径
        String propath = System.getProperty("user.dir");

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatisplusstudy?useSSL=true&useUnicode=true&serverTimezone=UCT"
                        , "root", "123456")
                .globalConfig(builder -> {
                    builder.author("xuanxie") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(propath+"/autoCode/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.xuanxie") // 设置父包名
                            .moduleName("autoCode"); // 设置父包模块名
//                            指定xml生成的路径
 //                           .pathInfo(Collections.singletonMap(OutputFile.xml,propath+"\\autoCode\\src\\main\\resources\\mapper\\"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("")
                            //自定义配置继承父包 HmBaseMapper  此类为我们公司扩展类
                            .mapperBuilder()
                            .build()
                            //实体类配置
                            .entityBuilder()
                            .enableLombok()
                            .enableChainModel()
                            .enableTableFieldAnnotation()
                            .disableSerialVersionUID()
                            .build()
                            //service配置
                            .serviceBuilder()
                            .build();;
                })
               // .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
