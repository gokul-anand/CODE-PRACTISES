package com.visa.prj.entity;

public class Mobile extends Product {
	private String connection;
	
	public Mobile() {
		
	}

	public Mobile(int id, String name, double price, String connection) {
		super(id, name, price);
		this.connection = connection;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean isExpensive() {
		if ( "3G".equals(connection) && getPrice() >15000) {
			return true;
		}
		else if("4G".equals(connection) && getPrice() >35000 ) {
			return true;
		}
		return false;
	}
	

}
