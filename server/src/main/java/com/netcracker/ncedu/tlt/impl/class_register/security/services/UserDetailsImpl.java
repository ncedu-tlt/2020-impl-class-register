package com.netcracker.ncedu.tlt.impl.class_register.security.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.netcracker.ncedu.tlt.impl.class_register.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String fio;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private String photo;

	private Date date;

	private String phone;

	private String address;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String fio, String username,
						   String email, String password,
			String photo, Date date, String phone, String address,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.fio = fio;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.photo = photo;
		this.date = date;
		this.phone = phone;
		this.address = address;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getFio(),
				user.getUsername(),
				user.getEmail(),
				user.getPassword(),
				user.getPhoto(),
				user.getDate(),
				user.getPhone(),
				user.getAddress(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getFio() {
		return fio;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getPhoto() {
		return photo;
	}

	public Date getDate() {
		return date;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
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
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
