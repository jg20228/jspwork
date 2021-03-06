package com.cos.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */

@WebServlet("/*")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getRequestURI();
		System.out.println(address);
		String temp[] = address.split("/");
		System.out.println("temp[0] : "+temp[0]);
		System.out.println("temp[1] : "+temp[1]);
		System.out.println("temp[2] : "+temp[2]);
		 
		String page = temp[2];
		if(page.equals("user")) {
			System.out.println("user page move");
		}else if(page.equals("admin")) {
			System.out.println("admin page move");
		}else if(page.equals("hello")) {
			System.out.println("hello page move");
		}else if(page.equals("table")) {
			System.out.println("table page move");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
