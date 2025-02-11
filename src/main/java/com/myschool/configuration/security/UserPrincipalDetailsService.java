package com.myschool.configuration.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myschool.entity.UserEntity;
import com.myschool.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	private UserRepository userRepository;

	public UserPrincipalDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		UserEntity user = this.userRepository.findByUserName(s);
		UserPrincipal userPrincipal = new UserPrincipal(user);

		return userPrincipal;
	}
}
