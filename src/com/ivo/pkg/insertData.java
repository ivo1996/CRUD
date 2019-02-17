package com.ivo.pkg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertData
 */
@WebServlet("/insertData")
public class insertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean u = new UserBean();
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String birthDate = request.getParameter("BirthDate");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setBirthDate(birthDate);
		u.setPhone(phone);
		u.setEmail(email);
		UserDAO.insertUser(u);
		request.setAttribute("message", "Submit successful!");
		request.getRequestDispatcher("index.jsp").forward(request,response);
		//doGet(request, response);
	}

}
