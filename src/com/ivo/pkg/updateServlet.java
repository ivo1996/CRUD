package com.ivo.pkg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	//Page is accessed from update.jsp and both sets and gets parameters for a single row from the Database
	//It is done that way so that the values of the input fields are not lost upon a refresh of the page which
	//might be necessary due to the fact that a message for validation has to be shown.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gets all parameters
		String usrID=request.getParameter("Id");
		String message = "Incorrect field: ";
		UserBean u = new UserBean();
		int intID = Integer.parseInt(usrID);
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String birthDate = request.getParameter("BirthDate");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");
		//Sets all attributes
		request.setAttribute("Id", intID);
		request.setAttribute("FirstName", firstName);
		request.setAttribute("LastName", lastName);
		request.setAttribute("BirthDate", birthDate);
		request.setAttribute("Phone", phone);
		request.setAttribute("Email", email);
		//Validation used to create a proper message.
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
		//Final validation before executing query
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
