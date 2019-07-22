package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class OrderClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// ApplicationContext ctx = new ClassPathXmlBeanApplicationContext("beans.xml");
		ctx.scan("com.visa");
		ctx.refresh();
		OrderService service = ctx.getBean("orderService",OrderService.class);
		/*
		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		
		Product p = new Product(0,"Camlin Marker","Stationary",20,500);
		service.addProduct(p);
		
		List<Product> products = service.getProducts();
		for (Product product : products) {
			System.out.println(product.getName()+ " "+product.getPrice());
		}*/
		
		Customer c = new Customer();
		c.setEmail("c1@visa.com"); //should get it from session
		Order o = new Order();
		o.setCustomer(c);
		
		Product p1 = service.getProduct(1);
		Product p2 = service.getProduct(3);
		
		
		Item i1 = new Item();
		i1.setProduct(p1);
		i1.setQty(10);
		i1.setAmount(p1.getPrice());
		
		
		Item i2 = new Item();
		i2.setProduct(p2);
		i2.setQty(20);
		i2.setAmount(p2.getPrice());
		
		o.getItems().add(i1);
		o.getItems().add(i2);
		service.executeOrder(o);
		
		
	}
}
