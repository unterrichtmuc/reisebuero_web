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
import de.cmt.reisebuero.web.helper.DbHelper;

/**
 * Servlet implementation class KundenServlet
 */
@WebServlet("/admin/kunden")
public class KundenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KundenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DbHelper.get();
		try {
			Kunde [] kunden = KundeSqlHelper.getKunden(con, -1);
			request.setAttribute("kunden", kunden);
			getServletContext().getRequestDispatcher("/admin/kunden.jsp").forward(request, response);
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
