package com.table.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
@WebServlet("/table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		
		out.println("<h1>Many Fruits</h1>");
		out.println("<h1>Sapphire</h1>");
		out.println("<table border='1'>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("<td>");
		out.println("apple");
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
