package com.tap.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Column(name="userid")
	private int userid;
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="username", nullable = false)
	private String username;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="email", nullable = false)
	private String email;
	@Column(name="phone",nullable=false)
	private String phone;
	@Column(name="address", nullable = false)
	private String address;
	@Column(name="role", nullable = false)
	private String role;
	 @Column(name = "created_date", updatable = false)
	    private LocalDateTime createdDate;

	 @Column(name = "last_login_date")
	    private LocalDateTime lastLoginDate;
	 
	 @OneToMany(mappedBy="admin",cascade= {CascadeType.DETACH,CascadeType.MERGE,
			 CascadeType.PERSIST,CascadeType.REFRESH
	 },fetch = FetchType.EAGER)
	 private List<Restaurant> restaurant;
	 @OneToMany(mappedBy="userId",cascade= {CascadeType.DETACH,CascadeType.MERGE,
			 CascadeType.PERSIST,CascadeType.REFRESH
	 },fetch = FetchType.EAGER)
	   private List<Orders>orders;
	 
	 

	public Users() {
		super();
	}



	public Users(String name, String username, String passsword, String email, String phone, String address,
			String role) {
		super();
		this.name = name;
		this.username = username;
		this.password = passsword;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasssword() {
		return password;
	}

	public void setPasssword(String passsword) {
		this.password = passsword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	// ✅ Automatically set createdDate before insert
    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    // ✅ Automatically update lastLoginDate before update (optional)
    @PreUpdate
    protected void onUpdate() {
        this.lastLoginDate = LocalDateTime.now();
    }



	public List<Restaurant> getRestaurant() {
		return restaurant;
	}



	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}
    

}
