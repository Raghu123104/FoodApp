package com.tap.DAO;

import java.util.List;

import com.tap.Model.Restaurant;
import com.tap.Model.Users;

public interface RestaurantDAO {



    // Save a new restaurant
    void saveRestaurant(Restaurant restaurant);

    // Update existing restaurant details
    void updateRestaurant(Restaurant restaurant);

    // Delete a restaurant by its ID
    void deleteRestaurant(int restaurantId);

    // Fetch a single restaurant by its ID
    Restaurant getRestaurantById(int restaurantId);

    // Fetch all restaurants
    List<Restaurant> getAllRestaurants();

    // Fetch all restaurants belonging to a specific admin
    Users getAllRestaurantsByAdminId(int id);
}



