package com.discom.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Created by Spring Source Tool Suite.
 *
 * @author Mark Meany
 */
//@Configuration

@EnableDiscoveryClient
//@EnableFeignClients(basePackages = {"com.discom","com.discom.springmvc.client","com.discom.springmvc.model","com.discom.springmvc.controller"})
@SpringBootApplication(scanBasePackages = {"com.discom", "com.discom.springmvc.client"
        , "com.discom.springmvc.model",
        "com.discom.springmvc.controller"})
@EnableSwagger2
//@EnableAuthorizationServer
@EnableResourceServer
@ComponentScan({"com.discom"})
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class, //
        SecurityAutoConfiguration.class, //
        WebServicesAutoConfiguration.class,
        MultipartAutoConfiguration.class,
        // SecurityFilterAutoConfiguration.class//
        // WebMvcAutoConfiguration.class

})
@EnableWebSecurity
@EnableWebMvc
@EnableOAuth2Sso
@EnableEurekaClient
//@EnableFeignClients(basePackages = {"com.discom","com.discom.springmvc.client","com.discom.springmvc.model","com.discom.springmvc.controller"})
@EnableFeignClients
//@EnableCircuitBreaker
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminApp extends SpringBootServletInitializer {

    final String CLIENT_ID = "";
    final String CLIENT_SECRET = "";
    final String AUTH_SERVER = "http://localhost:8087/auth-service";

    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AdminApp.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.discom.springmvc.controller"))
                .apis(RequestHandlerSelectors.basePackage("com.discom.springmvc.crudapi"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(securityScheme()))
                .securityContexts(Arrays.asList(securityContext()));
                //.apiInfo(new ApiInfoBuilder().version("1.0").title("Admin App API").description("Documentation Admin API v1.0").build());
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

//	private SecurityScheme securitySchemee() {
//	    GrantType grantType = new AuthorizationCodeGrantBuilder()
//	        .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/oauth/token", "oauthtoken"))
//	        .tokenRequestEndpoint(
//	        		new TokenRequestEndpoint(AUTH_SERVER + "/oauth/authorize", CLIENT_ID, CLIENT_SECRET))
//	        .build();
//	 
//	    SecurityScheme oauth = new OAuthBuilder().name("auth-service")
//	        .grantTypes(Arrays.asList(grantType))
//	        .scopes(Arrays.asList(scopes()))
//	        .build();
//	    return oauth;
//	}


    private OAuth securityScheme() {

        List<GrantType> grantTypes = new ArrayList<GrantType>();
        GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER + "/oauth/token");
        grantTypes.add(creGrant);
        return new OAuth("access_token", Arrays.asList(scopes()), grantTypes);

    }

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {
                new AuthorizationScope("read", "for read operations"),
                new AuthorizationScope("write", "for write operations"),
                //  new AuthorizationScope("api", "Access Swagger APIs"),
                new AuthorizationScope("trust", "for trust operations"),
                // new AuthorizationScope("server", "for server operations"),
                new AuthorizationScope("user_info", "for user_info API")};
        return scopes;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Arrays.asList(new SecurityReference("access_token", scopes())))
                .forPaths(PathSelectors.ant("/api/**"))
                .build();
    }

}
