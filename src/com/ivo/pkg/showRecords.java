package com.ivo.pkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showRecords
 */
@WebServlet("/showRecords")
public class showRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new UserDAO();
		String sortBy=request.getParameter("sort");
		request.setAttribute("usrList", UserDAO.getUsers(sortBy));
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new UserDAO();
		RequestDispatcher rd;
		String sortBy=request.getParameter("sort");
		if(request.getParameter("search")!=null)
		{
			request.setAttribute("usrList", UserDAO.search(request.getParameter("search")));
			rd=request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
		}
		else {
		request.setAttribute("usrList", UserDAO.getUsers(sortBy));
		rd=request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
		}
	}

}
