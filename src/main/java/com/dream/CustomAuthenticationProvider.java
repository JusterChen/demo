package com.dream;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
    private CustomUserService customUserService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        password = password.toLowerCase();
        if(password==""||password==null){
        	throw new UsernameNotFoundException("请输入密码");
        }else{
        	UserDetails user = customUserService.loadUserByUsername(username);
        	//加密过程在这里体现
        	if (!password.equals(user.getPassword())) {
        		throw new BadCredentialsException("密码错误");
        	}else{
        		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        		return new UsernamePasswordAuthenticationToken(user, password, authorities);
        	}
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}