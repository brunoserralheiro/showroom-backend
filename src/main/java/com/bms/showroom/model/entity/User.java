package com.bms.showroom.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


// change for JPA and MySQL
//@Table
//@Entity


@Data
@Document(collection = "user")
public class User {

//	change for JPA and MySQL
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	private String _id;
	@Indexed(unique=true, direction=IndexDirection.DESCENDING)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private  boolean accountNonExpired = true;
	private  boolean accountNonLocked = true;
	private  boolean credentialsNonExpired ;
	private  boolean enabled ;
	private boolean active ;
	private List<String> roles = new ArrayList<>();
	
	
	
	
	public User() {
		
	}





	/**
	 * @param firstName
	 * @param lastName
	 * @param active
	 */
	public User(String _id, String username, String password, 
				String firstName, String lastName,  
				boolean active, boolean enabled, 
				boolean credentialsNonExpired) {
		this._id = _id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.enabled = enabled;
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	
	


	public User(String id, String username, String password, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled, boolean active, List<String> roles) {
		this._id = id;
		this.username = username;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.active = active;
		this.roles = roles;
	}





	/**
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param enabled
	 * @param active
	 * @param roles
	 */
	public User(String username, String password, String firstName, String lastName,List<String> roles,
			boolean accountNonExpired,	boolean accountNonLocked, boolean credentialsNonExpired, 
			boolean enabled, boolean active	) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.active = active;
	}





	public String getId() {
		return _id;
	}





	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
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


	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}





	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}





	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public List<String> getRoles() {
		return roles;
	}





	public void setRoles(List<String> roles) {
		this.roles = roles;
	}





	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}





	public boolean isEnabled() {
		return enabled;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
