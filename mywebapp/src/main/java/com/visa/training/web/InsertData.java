package com.visa.training.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = request.getParameter("product_id");
		String s2 = request.getParameter("product_name");
		String s3 = request.getParameter("product_price");
		String s4 = request.getParameter("product_qoh");
		
		double product_price = Double.parseDouble(s3);
		int product_id = Integer.parseInt(s1);
		int product_qoh = Integer.parseInt(s4);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}