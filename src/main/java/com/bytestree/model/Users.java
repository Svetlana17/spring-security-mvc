package com.bytestree.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1948638898199176136L;
	
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 100)
	private String username;

	@Column(name = "password", nullable = false, length = 100)
	private String password;

	@Column(name = "failed_logins")
	private Integer failedLogins;

	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "locked")
	private Boolean locked;

	@Column(name = "last_login_date", length = 23)
	private Date lastLoginDate;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "authorities", joinColumns = {
			@JoinColumn(name = "user", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role", nullable = false, updatable = false) })
	private Set<Roles> roleses = new HashSet<Roles>(0);

	public Users() {
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Users(String username, String password, Integer failedLogins,
			Boolean enabled, Boolean locked, Date lastLoginDate,
			Set<Roles> roleses) {
		this.username = username;
		this.password = password;
		this.failedLogins = failedLogins;
		this.enabled = enabled;
		this.locked = locked;
		this.lastLoginDate = lastLoginDate;
		this.roleses = roleses;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getFailedLogins() {
		return this.failedLogins;
	}

	public void setFailedLogins(Integer failedLogins) {
		this.failedLogins = failedLogins;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

}
