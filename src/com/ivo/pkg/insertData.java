package com.ivo.pkg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insertData")
public class insertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public insertData() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Initialization of an object of type UserBean
		UserBean user = new UserBean();
		//Initialization of error/success message and getting all parameters from page index.jsp
		String message = "Incorrect field: ";
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String birthDate = request.getParameter("BirthDate");
		String phone = request.getParameter("Phone");
		String email = request.getParameter("Email");
		//Checks if data is incorrect so a proper message is set
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
		//Checks if all the data is correct
		else if(validate.validateName(firstName)&&validate.validateName(lastName)&&validate.validateDate(birthDate)&&validate.validateNumber(phone)&&validate.validateEmail(email)){
		//Sets the parameters for the object of type UserBean
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setBirthDate(birthDate);
		user.setPhone(phone);
		user.setEmail(email);
		//Executes method insert user from class UserDAO, passing object User
		UserDAO.insertUser(user);
		//Resets the message to successful since all the data is correct and "Incorrect field: " from above is no longer needed
		message = "Submit successful!";
		}
		//sets the attribute for index.jsp to receive and forwards
		request.setAttribute("message", message);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

}
