<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	label {
		display: block;
	}
</style>
</head>
<body>
<h3>Neuer Kunde</h3>

<form action="kunde_save" method="post">
	<div class="form-element">
		<label>Vorname</label>
		<input type="text" name="vorname" id="vorname" />
	</div>
	
	<div class="form-element">
		<label>Nachname</label>
		<input type="text" name="nachname" id="nachname" />
	</div>
	
	<div class="form-element">
		<label>benutzername</label>
		<input type="text" name="benutzername" id="benutzername" />
	</div>
	
	<div class="form-element">
		<label>passwort</label>
		<input type="text" name="passwort" id="passwort" />
	</div>
	
	<div class="form-element">
		<label>geburtsdatum</label>
		<input type="text" name="geburtsdatum" id="geburtsdatum" />
	</div>
	
	<div class="form-element">
		<label>Plz</label>
		<input type="text" name="plz" id="plz" />
	</div>

	<div class="form-element">
		<label>State</label>
		<select name="state" id="state">
			<option value="1">Aktiv</option>
			<option value="0">Inktiv</option>
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