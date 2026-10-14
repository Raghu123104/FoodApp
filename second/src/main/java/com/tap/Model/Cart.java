package com.tap.Model;

import java.util.HashMap;



public class Cart {
	
	private HashMap<Integer,CartItem> ci=new HashMap<>();
	
	public void addItem(CartItem c) {
		int id=c.getId();
		if(ci.containsKey(id)) {
			CartItem cc=ci.get(id);
			cc.setQuantity(cc.getQuantity()+c.getQuantity());
		}
		else {
			ci.put(c.getId(), c);
		}
	}
	public HashMap<Integer,CartItem> getItems()
	{
		return ci;
	}
	public void updateItem(int id) {
		if(ci.containsKey(id)) {
			CartItem cc=ci.get(id);
			if(cc.getQuantity()<=1) {
				ci.remove(id);
			}
			else {
				cc.setQuantity(cc.getQuantity()-1);
				
			}
		}
	}
	public void removeItem(int id) {
		if(ci.containsKey(id)) {
			ci.remove(id);
		}
		
	}
	
}
