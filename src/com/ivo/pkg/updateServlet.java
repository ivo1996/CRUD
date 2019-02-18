package com.ivo.pkg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
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
		String usrID=request.getParameter("Id");
		int intID = Integer.parseInt(usrID);
		String message = "Incorrect field: ";
		//int intID = Integer.parseInt(usrID);
		UserBean u = new UserBean();
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String birthDate = request.getParameter("BirthDate");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");
		request.setAttribute("Id", intID);
		request.setAttribute("FirstName", firstName);
		request.setAttribute("LastName", lastName);
		request.setAttribute("BirthDate", birthDate);
		request.setAttribute("Phone", phone);
		request.setAttribute("Email", email);
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
		UserDAO.updateRecord(u,usrID);
		message = "Update successful!";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("update.jsp").forward(request,response);
		doGet(request, response);
	}

}
