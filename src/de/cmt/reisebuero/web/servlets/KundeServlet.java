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
import de.cmt.reisebuero.web.helper.DbHelper;

/**
 * Servlet implementation class KundeServlet
 */
@WebServlet({"/KundeServlet", "/admin/kunde_save"})
public class KundeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KundeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nachname = request.getParameter("nachname");
		
		SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
		
		try {
			Kunde k = new Kunde(nachname);
			
			k.setVorname(request.getParameter("vorname"));
			k.setBenutzername(request.getParameter("benutzername"));
			k.setPassword(request.getParameter("passwort"));
			k.setGeburtsdatum(sf.parse(request.getParameter("geburtsdatum")));
			k.setPlz(request.getParameter("plz"));
			k.setState(Integer.valueOf(request.getParameter("state")));
			
			Connection con = DbHelper.get();
		
			KundeSqlHelper.create(con, k);
			
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
				
		
		response.getWriter().append("Kunde speichern " + nachname).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
