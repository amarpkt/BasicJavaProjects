package com.jobPortal.model;

public class User {
	
	private Long id;
	private String userName;
	private String email;
	private String password;
	private String role; //Admin, Recruiter, Job_seeker
	private boolean enabled;
	
	public User() {
		
	}
	
	public User(Long id, String userName, String email, String password, String role, boolean enabled) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }
	
	public boolean isEnabled() { return enabled; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", role="
				+ role + ", enabled=" + enabled + "]";
	}

}
