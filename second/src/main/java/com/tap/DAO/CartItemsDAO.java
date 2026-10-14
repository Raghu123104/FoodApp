package com.tap.DAO;

import com.tap.Model.CartItems;

public interface CartItemsDAO {
	
	void saveCart(CartItems cartItems,int itemId,int id);

}
