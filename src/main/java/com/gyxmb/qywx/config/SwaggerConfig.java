package com.gyxmb.qywx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author duxuebo
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gyxmb.qywx"))
				.paths(PathSelectors.any())
				.build().apiInfo(new ApiInfoBuilder()
						.title("公益项目部")
						.description("企业微信相关接口")
						.version("1.0")
//						.contact(new Contact("啊啊啊啊", "blog.csdn.net", "aaa@gmail.com"))
//						.license("The Apache License")
//						.licenseUrl("http://www.baidu.com")
						.build());
	}
}
