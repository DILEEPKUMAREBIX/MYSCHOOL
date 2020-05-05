package com.myschool.configuration.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.myschool.entity.UserEntity;

@SuppressWarnings("serial")
public class UserPrincipal implements UserDetails {

	private UserEntity user;

	public UserPrincipal(UserEntity user) {
		this.user = user;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//		this.user.getRolesList().forEach(r -> {
//			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
//			authorities.add(authority);
//		});
//
//		this.user.getPermissionsList().forEach(p -> {
//			GrantedAuthority authority = new SimpleGrantedAuthority(p);
//			authorities.add(authority);
//		});
//
//		return authorities;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();

		// Extract list of permissions (name)
		this.user.getPermissionsList().forEach(p -> {
			GrantedAuthority authority = new SimpleGrantedAuthority(p);
			authorities.add(authority);
		});

		// Extract list of roles (ROLE_name)
		this.user.getRolesList().forEach(r -> {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
			authorities.add(authority);
		});

		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO replace with is active value
		return true;
	}

}
