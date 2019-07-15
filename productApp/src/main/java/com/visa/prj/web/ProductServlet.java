package com.visa.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoImpl;
import com.visa.prj.entity.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // Opens a character stream to client - browser
		// ServletOutputStream out = response.getOutputStream(); // opens byte stream to
		// client (for video, image)
		response.setContentType("text/html");
		out.print("<html><body>");
		out.print("<h1>Product List </h1>");
		out.print("<table border = '1'");
		out.print("<tr> <th> <ID> </th> <th> Name</th> <th>Price</th> </tr>");

		ProductDao productDao = new ProductDaoImpl();
		List<Product> prods;
		try {
			prods = productDao.getProduct();
			out.print("<tr>");
			for (Product product : prods) {
				out.print("<th>" + product.getId() + "</th>");
				out.print("<th>" + product.getName() + "</th>");
				out.print("<th>" + product.getPrice() + "</th>");

				out.print("</tr>");

			}
		} catch (FetchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println(e.getMessage());
		}
		out.print("</table></body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product p = new Product();
		p.setName(request.getParameter("name"));
		p.setCategory(request.getParameter("category"));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		p.setCount(Integer.parseInt(request.getParameter("count")));

		response.setContentType("text/html");	
		response.getWriter().println("<html><body>");
		ProductDao productDao = new ProductDaoImpl();
		try {
			int id = productDao.addProduct(p);
			response.getWriter().println("<p>Product added! id ="+id+"</p>");
			response.getWriter().println("<br/><a href = 'index.html'>Back</a>");
		} catch (PersistenceException e) {
			response.getWriter().println(e.getMessage());
			e.printStackTrace();
		}
		response.getWriter().println("</body></html>");
		

	}

}
