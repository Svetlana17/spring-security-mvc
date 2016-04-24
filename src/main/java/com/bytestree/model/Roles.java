package com.bytestree.model;

import java.io.Serializable;
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
@Table(name = "roles")
public class Roles implements Serializable {

	private static final long serialVersionUID = 8215940655966357715L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "authorities", joinColumns = {
			@JoinColumn(name = "role", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "user", nullable = false, updatable = false) })
	private Set<Users> users = new HashSet<Users>(0);

	public Roles() {
	}

	public Roles(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Roles(int id, String name, Set<Users> users) {
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Users> getUsers() {
		return this.users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

}
