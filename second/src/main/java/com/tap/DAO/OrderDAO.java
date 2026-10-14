package com.tap.DAO;

import com.tap.Model.Orders;

public interface OrderDAO {
	
	Orders saveOrder(Orders order,int id,int userId);

}
