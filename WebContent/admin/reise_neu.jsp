<%@page import="java.text.SimpleDateFormat"%>
<%@page import="de.cmt.reisebuero.core.reise.Reise"%> 


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 	
Reise reise = (Reise)request.getAttribute("Reise");
SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");

%>
<% 
if (reise==null){
	reise = new Reise();  	
	
	
%>
<h3>Neue Reise</h3>
<% }else{  %>
<h3>Bearbeiten</h3>
<% }  %>
<form action="reise_save" method="post">
	<div class="form-element">
		<label>Titel</label>
		<input type="text" name="titel" id="titel"  value="<%= reise.getTitel() %>"/>
	</div>
	
	<div class="form-element">
		<label>Beschreibung</label>
		<input type="text" name="beschreibung" id="beschreibung" value="<%= reise.getBeschreibung() %>" />
	</div>
	
	<div class="form-element">
		<label>Beginn</label>
		<input type="text" name="beginn" id="beginn" value="<%= sf.format(reise.getBeginn()) %>"/>
	</div>
	
	<div class="form-element">
		<label>Dauer</label>
		<input type="text" name="dauer" id="dauer" value="<%= reise.getDauer() %>" />
	</div>
	
	<div class="form-element">
		<label>Art</label>
		<input type="text" name="art" id="art" value="<%= reise.getArt() %>"/>
	</div>
	
	<div class="form-element">
		<label>Preis</label>
		<input type="text" name="preis" id="preis" value="<%= reise.getPreis()%>" />
	</div>
	
	<div class="form-element">
		<label>Land</label>
		<input type="text" name="land" id="land" value="<%= reise.getLand() %>"/>
	</div>

	<div class="form-element">
		<label>State</label>
		<select name="state" id="state">
			<option value="1">Sichtbar</option>
			<option value="0">Unsichtbar</option>
			<option value="2">Archiviert</option>
			<option value="3">Gelöscht</option>		
		</select>
	</div>

	<div class="form-element" style="margin-top: 15px;">
		<input type="submit" value="Speichern" />
	</div>

	<input type ="hidden" name="id" value="<%= reise.getId() %>"/>
</form>

</body>
</html>