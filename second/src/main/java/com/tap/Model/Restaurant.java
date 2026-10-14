package com.tap.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "rating")
    private int rating;

    @Column(name = "cusine_type", length = 50)
    private String cusineType;

    @Column(name = "is_active")
    private boolean isActive;

    // Direct admin user ID column
    @Column(name = "admin_user_id", nullable = false)
    private int adminUserId;

    // Many-to-One relationship with Users table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_user_id1", updatable = false)
    private Users admin;

    @Column(name = "image", length = 255)
    private String image;
    
    @OneToMany(mappedBy="restaurant",cascade= {CascadeType.DETACH,CascadeType.MERGE,
			 CascadeType.PERSIST,CascadeType.REFRESH
	 },fetch = FetchType.EAGER)
    private List<Menu>menu;
    @OneToMany(mappedBy="restaurant",cascade= {CascadeType.DETACH,CascadeType.MERGE,
			 CascadeType.PERSIST,CascadeType.REFRESH
	 },fetch = FetchType.EAGER)
    private List<Orders>orders;

    

	// Constructors
    public Restaurant() {
    		super(); }

    public Restaurant(String name, String address, String phone, int rating,
                      String cusineType, boolean isActive, int adminUserId, String image) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
        this.cusineType = cusineType;
        this.isActive = isActive;
        this.adminUserId = adminUserId;
        this.image = image;
    }

    // Getters and Setters
    public int getRestaurantId() { return restaurantId; }
    public void setRestaurantId(int restaurantId) { this.restaurantId = restaurantId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getCusineType() { return cusineType; }
    public void setCusineType(String cusineType) { this.cusineType = cusineType; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public int getAdminUserId() { return adminUserId; }
    public void setAdminUserId(int adminUserId) { this.adminUserId = adminUserId; }

    public Users getAdmin() { return admin; }
    public void setAdmin(Users admin) { this.admin = admin; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
}
