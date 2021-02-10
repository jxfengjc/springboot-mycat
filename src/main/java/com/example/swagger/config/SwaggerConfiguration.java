
package com.example.swagger.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Description Swagger 菜单配置
 * Author renpm
 * Date 2018/7/23 18:54
 * Version 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Autowired
    Environment env;

    private  boolean swaggerIsEnable(){
        String profile  = env.getActiveProfiles()[0];
        boolean swaggerEnable  = true;
        if ("pro".equals(profile)){
            swaggerEnable = false;
        }
        return  swaggerEnable;
    }
    @Bean(value = "defaultApi")
    @Order(value = 1)
    public Docket defaultApi() {

        List <Parameter> parameters = Lists.newArrayList();
        parameters.add(new ParameterBuilder()
                .name("Authorization")
                .description("token令牌   Bearer ${token}  注意，中间有空格")
                .modelRef(new ModelRef("String"))
                .parameterType("header")
                .required(true)
                .build());
        parameters.add(new ParameterBuilder()
            .name("sign")
            .description("签名认证：" +
                "◆ 参数名ASCII码从小到大排序（字典序）（sign参数不参与签名）；" +
                "◆ 如果参数的值为空不参与签名；" +
                "◆ 参数名区分大小写； " +
                "   将参数使用&进行拼接 最后拼接上签名key。使用MD5进行加密 赋值给参数sign   "+
                "◆ stringA=\"app=douniucaijing&body=thisisbody&timestamp=1555558720&key=mykey\";" +
                "   sign = MD5.encode(stringA)")
            .modelRef(new ModelRef("String"))
            .parameterType("query")
            .required(true)
            .build());
        parameters.add(new ParameterBuilder()
            .name("timestamp")
            .description("时间戳，使用秒 安卓获得的毫秒值需要除以1000")
            .modelRef(new ModelRef("String"))
            .parameterType("query")
            .required(true)
            .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerIsEnable())
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .groupName("接口文档")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameters);
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("投教系统 项目   RESTful APIs")
                .description("投教系统RESTful APIs，注意接口中的公共参数的填写。公共参数的欧写入到header中")
                .termsOfServiceUrl("http://www.xx.com/")
                .contact(new Contact("开发", "/url", "xx@qq.com"))
                .version("1.0")
                .build();
    }
}
