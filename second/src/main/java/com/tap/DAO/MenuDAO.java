package com.tap.DAO;

import java.util.List;

import com.tap.Model.Menu;

public interface MenuDAO {
	
	  void addItem(Menu item,int id);
	  List<Menu> getItemsByRestaurantId(int id);
	  Menu getItemByMenuId(int id);

}
