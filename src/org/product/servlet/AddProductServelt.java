package org.product.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.productDomain.ProductDetails;
import org.productService.ProductJDBCImpl;
import org.productService.ProductServices;


public class AddProductServelt extends HttpServlet {
	ProductServices productLink = new ProductJDBCImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String brandName = request.getParameter("brandName");
		String category = request.getParameter("category");
		String modelYear = request.getParameter("modelYear");
		String listPrice = request.getParameter("listPrice");
		String orderId = request.getParameter("orderId");

		ProductDetails product = new ProductDetails();
		
		product.setProductId(Integer.valueOf(productId));
		product.setProductName(productName);
		product.setBrandName(brandName);
		product.setCategory(category);
		product.setModelYear(Integer.valueOf(modelYear));
		product.setListPrice(Double.valueOf(listPrice));
		product.setOrderId(Integer.valueOf(orderId));
		

		System.out.println(product);
		try {
			productLink.addproduct(product);
			System.out.println("Added Product details ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// todo validate cridentals
		RequestDispatcher rd = request.getRequestDispatcher("productmenu.html");
		rd.include(request, response);
		out.close();
	}

}
