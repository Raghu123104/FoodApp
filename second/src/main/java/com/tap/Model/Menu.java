package com.tap.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Menu")
public class Menu {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
        @Column(name="item_id")
		private int menuId;
		@Column(name="item_name")
		private String itemName;
		@Column(name="description")
		private String description;
		@Column(name="price")
		private int price;
		@Column(name="rating")
		private float rating;
		@Column(name="is_available")
		private boolean isAvailable;
		@Column(name="image_url")
		private String image;
		@CreationTimestamp
	    @Column(name = "created_date", nullable = false, updatable = false)
	    private LocalDateTime createdDate;

	    @UpdateTimestamp
	    @Column(name = "updated_date")
	    private LocalDateTime updatedDate;
	    
	    
		@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
				CascadeType.PERSIST,CascadeType.REFRESH
		})
		@JoinColumn(name="restaurant_id")
		private Restaurant restaurant;
		
		public Menu(String itemName, String description, int price, float rating,
				boolean isAvailable,String image) {
			super();
			
			
			this.itemName = itemName;
			this.description = description;
			this.price = price;
			this.rating = rating;
			this.isAvailable = isAvailable;
			this.image=image;
		}
		public int getMenuId() {
			return menuId;
		}
		public void setMenuId(int menuId) {
			this.menuId = menuId;
		}
		
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public float getRating() {
			return rating;
		}
		public void setRating(float rating) {
			this.rating = rating;
		}
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public Restaurant getRestaurant() {
			return restaurant;
		}
		public void setRestaurant(Restaurant restaurant) {
			this.restaurant = restaurant;
		}
	    public LocalDateTime getCreatedDate() {
	        return createdDate;
	    }

	    public LocalDateTime getUpdatedDate() {
	        return updatedDate;
	    }
		public Menu() {
			super();
		}


	}



