package org.anz.wholesale.config;

import io.swagger.annotations.SwaggerDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SwaggerDefinition(produces = "application/json", schemes = {SwaggerDefinition.Scheme.HTTP})
/**
 * Created by hariharank12 on 19/02/21.
 */
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.anz.wholesale.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Wholesale Accounts Application", "Wholesale Accounts API to get the accounts and transaction list.",
                "1.0", "Terms of service", new Contact("Hariharan Kumar", "www.hariharankumar.com", "hariharank12@gmail.com"),
                "ANZ Wholesale Accounts API 1.0", "API license URL", ApiInfo.DEFAULT.getVendorExtensions());
    }
}
