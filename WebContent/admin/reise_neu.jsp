<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Neue Reise</h3>

<form action="reise_save" method="post">
	<div class="form-element">
		<label>Titel</label>
		<input type="text" name="titel" id="titel" />
	</div>
	
	<div class="form-element">
		<label>Beschreibung</label>
		<input type="text" name="beschreibung" id="beschreibung" />
	</div>
	
	<div class="form-element">
		<label>Beginn</label>
		<input type="text" name="beginn" id="beginn" />
	</div>
	
	<div class="form-element">
		<label>Dauer</label>
		<input type="text" name="dauer" id="dauer" />
	</div>
	
	<div class="form-element">
		<label>Art</label>
		<input type="text" name="art" id="art" />
	</div>
	
	<div class="form-element">
		<label>Preis</label>
		<input type="text" name="preis" id="preis" />
	</div>
	
	<div class="form-element">
		<label>Land</label>
		<input type="text" name="land" id="land" />
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

</form>

</body>
</html>