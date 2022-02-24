package com.model.persistence.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private String profile;
	public String getUsername() {
		return username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public User(String username, String password, String profile) {
		this.username = username;
		this.password = password;
		this.profile = profile;
	}
	public User() {}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", profile=" + profile + "]";
	}
	
	
	
}
