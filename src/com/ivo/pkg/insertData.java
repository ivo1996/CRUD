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
		String message = "Incorrect field: ";
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String birthDate = request.getParameter("BirthDate");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");
		if(!validate.validateName(firstName)) {
			message=message+"First Name.";
		}
		else if(!validate.validateName(lastName)) {
			message=message+"Last Name.";
		}
		else if(!validate.validateDate(birthDate)) {
			message=message+"Birth Date.";
		}
		else if(!validate.validateNumber(phone)) {
			message=message+"Phone Number.";
		}
		else if(!validate.validateEmail(email)) {
			message=message+"Email Address ";
			request.setAttribute("message", message);
		}
		else if(validate.validateName(firstName)&&validate.validateName(lastName)&&validate.validateDate(birthDate)&&validate.validateNumber(phone)&&validate.validateEmail(email)){
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setBirthDate(birthDate);
		u.setPhone(phone);
		u.setEmail(email);
		UserDAO.insertUser(u);
		message = "Submit successful!";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("index.jsp").forward(request,response);
		//doGet(request, response);
	}

}
