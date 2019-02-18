package com.ivo.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteRecord")
public class deleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteRecord() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Receives ID as a string from the page view.jsp
		String ID=request.getParameter("usrID");
		//Executes the method deleteRecord from UserDAO class
		UserDAO.deleteRecord(ID);
		//Forwards to servlet showRecords
		request.getRequestDispatcher("showRecords").forward(request,response);
		doGet(request, response);
	}

}
