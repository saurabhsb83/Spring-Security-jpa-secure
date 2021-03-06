package com.luv2code.SpringREST1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public MyUserDetails() {}
	
	public MyUserDetails(String userName) {
		this.userName = userName;
		
	}
	
	public MyUserDetails(User user) {
		
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active   = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		return this.authorities;
	}

	@Override
	public String getPassword() {
		
		//return "password";
		return this.password;
	}

	@Override
	public String getUsername() {
		//return userName;
		return this.userName;
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
		
		return true;
		//return this.active;
	}

}
