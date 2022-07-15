package com.discom.springboot;

import com.discom.springmvc.configuration.SecurityProperties;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.io.IOException;

@Configuration
@EnableResourceServer
@Order(1)
@EnableConfigurationProperties(SecurityProperties.class)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String ROOT_PATTERN = "/**";

    private final SecurityProperties securityProperties;

    private TokenStore tokenStore;

    public ResourceServerConfig(final SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    //@Autowired
    // private ResourceServerTokenServices tokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // resources.tokenServices(getRemoteTokenServices ());
        resources.tokenStore(tokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/api/**")
                .authorizeRequests()
                /*
                 * .antMatchers(HttpMethod.GET, ROOT_PATTERN).access("#oauth2.hasScope('read')")
                 * .antMatchers(HttpMethod.POST,
                 * ROOT_PATTERN).access("#oauth2.hasScope('write')")
                 * .antMatchers(HttpMethod.PATCH,
                 * ROOT_PATTERN).access("#oauth2.hasScope('write')")
                 * .antMatchers(HttpMethod.PUT,
                 * ROOT_PATTERN).access("#oauth2.hasScope('write')")
                 * .antMatchers(HttpMethod.DELETE,
                 * ROOT_PATTERN).access("#oauth2.hasScope('write'")
                 */
                .antMatchers("/actuator/**", "/v2/api-docs/**", "/oauth/*", "/**", "/swagger-ui.html**").permitAll()
                .anyRequest().authenticated().antMatchers("/**").authenticated();
        //.and().oauth2Login();

        http.csrf().disable();
    }


    @Primary
    @Bean
    public DefaultTokenServices tokenServices(final TokenStore tokenStore) {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        return tokenServices;
    }


    @Bean
    public TokenStore tokenStore() {
        if (tokenStore == null) {
            tokenStore = new JwtTokenStore(jwtAccessTokenConverter());
        }
        return tokenStore;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        System.out.println(getPublicKeyAsString());
        converter.setVerifierKey(getPublicKeyAsString());
        return converter;
    }

    private String getPublicKeyAsString() {
        try {
            return IOUtils.toString(securityProperties.getJwt().getPublicKey().getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    @Bean
//    RemoteTokenServices getRemoteTokenServices () {
//        RemoteTokenServices rts = new RemoteTokenServices();
//        rts.setCheckTokenEndpointUrl("http://localhost:8087/auth-service/oauth/check_token");
//        rts.setAccessTokenConverter(jwtAccessTokenConverter());
//        rts.setClientId("Admin");
//        rts.setClientSecret("chauhan");
//        return rts;
//    }
}