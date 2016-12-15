<%@page import="de.cmt.reisebuero.core.kunde.KundeState"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="de.cmt.reisebuero.core.reise.Reise"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reisen</title>
<link rel ="stylesheet" href="../media/css/bootstrap.css">
<script type="text/javascript" src ="../media/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src ="../media/js/bootstrap.js"></script>
</head>
<body>
<div class ="container">

	<h3>Reisen</h3>
	<a class="btn btn-success" href="reise_neu.jsp">Neue Reise</a>
	<table class ="table table-striped" >
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
				out.println(r.getId());
				out.println("</td>");
				out.println("<td>");
				out.println("<a href=\"reise_edit?id=" + r.getId() + "\">");
				out.println(r.getTitel());
				out.println("</a>");
				out.println("</td>");
				out.println("<td>");
				out.println(sf.format(r.getBeginn()));
				out.println("</td>");
				out.println("<td>");
				out.println(r.getDauer());
				out.println("</td>");
				out.println("<td>");
				out.println((r.getPreis()));
				out.println("</td>");
				out.println("<td>");
				out.println(KundeState.getText(r.getState()));
				out.println("</td>");

				out.println("</tr>");
			}
		%>
	</table>
	
	</div>
</body>
</html>