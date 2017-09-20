package com.dream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dream.model.User;
import com.dream.repository.UserRepository;

public class CustomUserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username==null || username==""){
			 throw new UsernameNotFoundException("请输入帐号");
		}else{
			//重写loadUserByUsername 方法获得 userdetails 类型用户
			User user = userRepository.findByUserName(username);
			if(user == null){
				throw new BadCredentialsException("帐号不存在");
			}else{
				return user; 
			}
		}
	}

}