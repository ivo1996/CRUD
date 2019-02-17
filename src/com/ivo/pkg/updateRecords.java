package com.ivo.pkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateRecords
 */
@WebServlet("/updateRecords")
public class updateRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateRecords() {
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
		new UserDAO();
		UserBean u = new UserBean();
		String ID=request.getParameter("usrID");
		int usrID = Integer.parseInt(ID);
		u=UserDAO.getUser(ID);
		request.setAttribute("Id", usrID);
		request.setAttribute("FirstName",u.getFirstName());
		request.setAttribute("LastName",u.getLastName());
		request.setAttribute("BirthDate",u.getBirthDate());
		request.setAttribute("Phone",u.getPhone());
		request.setAttribute("Email",u.getEmail());
		RequestDispatcher rd=request.getRequestDispatcher("update.jsp"); rd.forward(request, response);
		doGet(request, response);
		
	}

}
