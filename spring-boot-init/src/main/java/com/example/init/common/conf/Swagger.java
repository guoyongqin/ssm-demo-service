package com.example.init.common.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* Swagger 配置文件
* @ClassName: Swagger
* @Description: TODO(配置文件)
* @author StevenGuo
* @date 2020年8月7日
*
 */
@Configuration(value="false")
@EnableSwagger2 //启动swagger注解 启动服务，浏览器输入"http://服务名:8080/swagger-ui.html"
public class Swagger {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
				.apiInfo(apiInfo())
				// 设置哪些接口暴露给Swagger展示
				.select()
				 // 扫描所有有注解的api，用这种方式更灵活
				.apis(RequestHandlerSelectors.basePackage("com.example.init"))
				// 扫描指定包中的swagger注解
				//.apis(RequestHandlerSelectors.basePackage("com.fc.test.controller"))
				// 扫描所有 .apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//设置标题
				.title("API文档")
				//描述
				.description("努力打造springboot框架的极致细腻的脚手架")
				 //作者信息
                //.contact(new Contact(v2Config.getName(), null, V2Config.getEmail_account()))
                //服务条款URL
				.termsOfServiceUrl("")
				//版本
				.version("版本号:0.0.1")
				.build();
	}

}
