package com.dream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	UserDetailsService customUserService(){
		return new CustomUserService();
	}
	
	@Bean
	public CustomUserService userDetailsService() {
		return new CustomUserService();
	}
	 
	@Bean
	public CustomAuthenticationProvider authenticationProvider() {
		return new CustomAuthenticationProvider();
	}
	 
	@Override 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService()); //自定义验证
		 auth.authenticationProvider(authenticationProvider());//自定义验证
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        .antMatchers("/scripts/**", "/images/**", "/styles/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/homePage/home",true)//登录成功指向页面
        .permitAll()
        .and()
        .logout()
        .logoutSuccessUrl("/login")//退出成功跳转
        .invalidateHttpSession(true)//注销session
        .permitAll();
	}

}
