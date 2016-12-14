package de.cmt.reisebuero.web.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class KundeServlet
 */
@WebServlet({"/ReiseServlet", "/admin/reise_save"})
public class ReiseSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReiseSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
		
		try {
			Reise r = new Reise();
			
			r.setTitel(request.getParameter("titel"));
			r.setBeschreibung(request.getParameter("beschreibung"));
			r.setBeginn(sf.parse(request.getParameter("beginn")));
			r.setDauer(Integer.valueOf(request.getParameter("dauer")) );
			r.setArt(Integer.valueOf(request.getParameter("art")));
			r.setPreis(Double.valueOf(request.getParameter("preis")));
			r.setLand(request.getParameter("land"));
			r.setState(Short.valueOf(request.getParameter("state")));
			
			Connection con = DbHelper.get();
		
			ReiseSqlHelper.create(con, r);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		response.getWriter().append("Reise speichern " + request.getParameter("titel")).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
