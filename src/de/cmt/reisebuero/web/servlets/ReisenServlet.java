package de.cmt.reisebuero.web.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.cmt.reisebuero.core.kunde.Kunde;
import de.cmt.reisebuero.core.kunde.KundeSqlHelper;
import de.cmt.reisebuero.core.reise.Reise;
import de.cmt.reisebuero.core.reise.ReiseSqlHelper;
import de.cmt.reisebuero.web.helper.DbHelper;

/**
 * Servlet implementation class KundenServlet
 */
@WebServlet("/admin/reisen")
public class ReisenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReisenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DbHelper.get();
		try {
			Reise [] reisen = ReiseSqlHelper.getReisen(con, -1);
			request.setAttribute("reisen", reisen);
			getServletContext().getRequestDispatcher("/admin/reisen.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
