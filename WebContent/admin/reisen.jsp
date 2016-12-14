<%@page import="de.cmt.reisebuero.core.kunde.KundeState"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="de.cmt.reisebuero.core.reise.Reise"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reisen</title>
</head>
<body>
	<h3>Reisen</h3>
	<table border="1" style="width: 100%">
		<tr>
			<td>Id</td>
			
			<td>Titel</td>

			<td>Beginn</td>

			<td>Dauer</td>

			<td>Preis</td>

			<td>Status</td>
		</tr>


		<%
			SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
			Reise[] reisen = (Reise[]) request.getAttribute("reisen");

			for (int i = 0; i < reisen.length; i++) {
				Reise r = reisen[i];

				out.println("<tr>");
				out.println("<td>");
				out.println(k.getId());
				out.println("</td>");
				out.println("<td>");
				out.println(k.get());
				out.println("</td>");
				out.println("<td>");
				out.println("<a href=\"kunde_edit?id=" + k.getId() + "\">");
				out.println(k.getNachname());
				out.println("</a>");
				out.println("</td>");
				out.println("<td>");
				out.println(k.getBenutzername());
				out.println("</td>");
				out.println("<td>");
				out.println(sf.format(k.getGeburtsdatum()));
				out.println("</td>");
				out.println("<td>");
				out.println(KundeState.getText(k.getState()));
				out.println("</td>");

				out.println("</tr>");

			}
		%>
	</table>
</body>
</html>