package com.vipul.rest.webservices.restfulwebservices.user;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {
	protected User() {}
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message = "Name should have atleast 2 characters")
	//@JsonProperty("user_name")
	private String name;
	
	@Past(message = "Birth Date should be in the past")
	//@JsonProperty("birth_date")
	private LocalDateTime birthDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;	
	
	public User(Integer id, String name, LocalDateTime birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
