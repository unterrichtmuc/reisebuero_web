package de.cmt.reisebuero.web.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.cmt.reisebuero.core.reise.Reise;
import de.cmt.reisebuero.core.reise.ReiseSqlHelper;
import de.cmt.reisebuero.web.helper.DbHelper;

/**
 * Servlet implementation class ReiseEditServlet
 */
@WebServlet("/admin/reise_edit")
public class ReiseEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReiseEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	int reiseId = Integer.valueOf(request.getParameter("id"));	
    	Connection con = DbHelper.get();
    	try {
			Reise reise = ReiseSqlHelper.getReise(con, reiseId);
			request.setAttribute("Reise", reise);
			getServletContext().getRequestDispatcher("/admin/reise_neu.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
