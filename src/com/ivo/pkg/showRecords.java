package com.ivo.pkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showRecords")
public class showRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public showRecords() {
        super();

    }

    //Method for when the page is being accessed through method GET, pages view.jsp and the classes deleteRecord do that
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//initialize an object of type UserDAO
		new UserDAO();
		//gets parameter "sort" which is used as an argument for the method UserDao.getUsers
		//parameter sort is contained in the link which is generated based on which href link is clicked from view.jsp
		String sortBy=request.getParameter("sort");
		//gets an ArrayList from getUsers and sets it as an attribute for view.jsp to receive
		request.setAttribute("usrList", UserDAO.getUsers(sortBy));
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
	}

	//doPost method is accessed through the from on the navbar that contains a search input type="text"
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new UserDAO();
		//receives the value of the search bar
		String sortBy=request.getParameter("sort");
		RequestDispatcher rd;
		//If search contains a string
		if(request.getParameter("search")!=null)
		{
			//usage of method search from class UserDAO, it uses the string that contains the value from the page
			request.setAttribute("usrList", UserDAO.search(request.getParameter("search")));
			rd=request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
		}
		//case for when the search bar is empty, it gets all items from the table sorted by ID
		else {
		request.setAttribute("usrList", UserDAO.getUsers(sortBy));
		rd=request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
		}
	}

}
