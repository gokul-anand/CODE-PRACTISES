package com.visa.prj.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoImpl;
import com.visa.prj.entity.Product;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(false);
		if(ses != null) {
			String[] items = request.getParameterValues("items");
			List<Product> products = (List<Product>)ses.getAttribute("cart");
			ProductDao productDao = new ProductDaoImpl(); // use factory to get DAO instance
			try {
				List<Product> prds = productDao.getProduct();
				for(String id : items) {
					Product pr = prds.stream()
							.filter(p -> p.getId() == Integer.parseInt(id)).findFirst().get();
					products.add(pr);
				}
				ses.setAttribute("cart", products);
				response.sendRedirect("Cart.jsp");
			} catch (FetchException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("login.html");
		}
	}

}
