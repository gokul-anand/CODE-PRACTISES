package com.visa.prj.client;

import com.visa.prj.entity.Product;
import com.visa.prj.util.SQLUtil;

public class SQLClient {

	public static void main(String[] args) {
		
		String SQL = SQLUtil.createStatement(Product.class);
		System.out.println(SQL);
	}

}
