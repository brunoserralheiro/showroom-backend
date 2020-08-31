package com.bms.showroom.model.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bms.showroom.model.entity.User;

public class CustomUserDetails implements UserDetails {

	
	 
	
	private User user;

	/**
	 * 
	 */
	public CustomUserDetails(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = 4582720672382601313L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {

		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		
		return user.isEnabled();
	}

}
