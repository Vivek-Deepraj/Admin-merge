package com.discom.springmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
@Configuration
@EnableWebSecurity
@Order(99)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.antMatcher("/**").authorizeRequests()
                .antMatchers("/login**", "/sso/**", "/**", "/swagger-ui.html**").permitAll()
                .antMatchers("/api/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .oauth2Login().loginPage("/sso/login");//.loginPage("http://localhost:8087/AuthApp/login");
        // http.anonymous().disable();
        //    http
        //        .requestMatchers()
        //      .antMatchers("/login", "/oauth/authorize")
        //      .and()
        //      .authorizeRequests()
        //      .antMatchers("/oauth/token").permitAll()
        //      .antMatchers("/actuator/**", "/api-docs/**","/oauth/*").permitAll()
        //      .antMatchers("/api/**" ).authenticated()
        //      .and().formLogin().loginPage("/login");//.loginProcessingUrl("http://localhost:8080/AuthApp/oauth/token");
        //.and().oauth2Login();//.formLogin().loginPage("/login");
        http.csrf().disable();//.anonymous().disable();

//	        
//	        http
//	          .csrf().disable()
//	          .authorizeRequests()
//	          .antMatchers("/","/api/**", "/login", "/logout", "/register", "/fonts/**").permitAll()
//	          .anyRequest().authenticated()
//	          .and()
//	          .formLogin()
//	          .loginPage("/login")
//	          .loginProcessingUrl("/login")
//	          .failureUrl("/login?error")
//	          .permitAll()
//	          .and()
//	          .rememberMe()
//	          .key("whatever");
//	  http
//	          .logout()
//	          .logoutUrl("/logout")
//	          .logoutSuccessUrl("/login")
//	          .deleteCookies("JSESSIONID")
//	          .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new
                DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return
                authenticationProvider;
    }


    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new
                CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        String origins[] = {"http://localhost:3005", "http://localhost:9090", "http://localhost:4291", "http://localhost:8080", "http://localhost:4292", "http://localhost:4293"
                , "http://104.215.147.107:9090", "http://172.104.62.103:4291", "http://172.104.62.103:8080", "http://172.104.62.103:4292", "http://172.104.62.103:4293"};
        config.setAllowedOrigins(Arrays.asList(origins));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean
                = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }


}
