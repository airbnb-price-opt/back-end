package com.lambda.bw_airbnb_price_opt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors
                        .basePackage("com.lambda.bw_airbnb_price_opt")) // To be more specific with our package
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false) // Allows only my exception responses
                .ignoredParameterTypes(Pageable.class) // allows only my paging parameter list
                .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo()
    {
        return new ApiInfoBuilder().title("Restaurant Example")
                .description("BW Airbnb Opt Project")
                .contact(new Contact("Alejandro Mejia", "Alejandro Mejia", "aalejandro.mreyes@gmail.com"))
                .license("MIT").licenseUrl("https://github.com/LambdaSchool/java-crudysnacks/blob/master/LICENSE")
                .version("1.0.0").build();
    }
}
