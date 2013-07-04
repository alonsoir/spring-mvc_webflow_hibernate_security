<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- ojito has cambiado el lenguaje de en a es -->
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<style>
body {
	margin: 10;
	font-family: verdana;
	background-color: #EFF8FB
}

h1 {
	text-align: center;
	margin: 0;
	padding: 15px;
	font-family: verdana;
}

h2 {
	margin: 0;
	padding: 20px 0px 5px 0px;
	font-family: verdana;
}

.header {
	top: 0px;
	height: 65px;
	border-bottom: 1px #ccc solid;
	background-color: #EFEFFB;
	font-family: verdana;
}

.footer {
	clear: both;
	overflow: hidden;
	border-top: 1px #ccc solid;
	padding: 10px 0px 0px 0px;
	background-color: #EFEFFB;
	font-family: verdana;
}

.footer .text {
	float: right;
	margin-right: 20px;
	font-family: verdana;
}

input[type="textbox"] {
	display: inline !important;
	width: 35px;
}

input[type="checkbox"] {
	display: inline !important;
	width: 20px;
}

input {
	display: block;
	width: 340px;
	margin: 3px 0px 20px 0px;
	padding: 5px;
}

label {
	font-weight: normal;
	font-size: 15px;
	display: block;
}

button {
	background-color: #ccc;
	color: #000;
	border: 1px #f4f4f4 solid;
	margin: 12px 0px;
	box-shadow: 0 3px 2px #AAA;
	margin-right: 5px;
	padding: 5px 10px;
	font-weight: bold;
}

#dialog {
	display: none;
}

.ui-dialog {
	box-shadow: 0 20px 10px #AAA;
}

.error {
	border: 1px solid #FBB3B9;
	color: #f0051e;
	background: #FFECED;
	padding: 5px;
	margin-bottom: 10px;
	font-size: 12px;
	font-weight: bold;
}

.link {
	display: none;
	padding: 0px 30px 20px 30px;
	background-color: #f4f4f4;
	border: 1px solid #ccc;
	font-family: verdana;
	width: 400px;
	margin: 0 auto;
	margin-top: 40px;
	margin-bottom: 40px;
}

.linkComunidades {
	padding: 0px 30px 20px 30px;
	background-color: #f4f4f4;
	border: 1px solid #ccc;
	font-family: verdana;
	width: 1128px;
	margin: 0 auto;
	margin-left: 40px;
	margin-top: 40px;
	margin-bottom: 90px;
}

.linkMuroComunidades {
	padding: 0px 0px 10px 20px;
	background-color: #f4f4f4;
	border: 1px solid #ccc;
	font-family: verdana;
	width: 1128px;
	margin: 0 auto;
	margin-left: 40px;
}

.login {
	display: block;
	width: 380px;
	margin: 0 auto;
	border: 1px solid #ccc;
	padding: 30px;
	margin-top: 40px;
	margin-bottom: 40px;
	margin-left: 40px;
}

.login h2 {
	margin-top: 0px;
}

.success {
	border: 1px solid green;
	color: green;
	background: #90EE90;
	padding: 5px;
	margin-bottom: 10px;
	font-size: 12px;
	font-weight: bold;
}

.failure {
	border: 1px solid green;
	color: red;
	background: #90EE90;
	padding: 5px;
	margin-bottom: 10px;
	font-size: 12px;
	font-weight: bold;
}


.currentUser {
	border: 1px solid green;
	color: green;
	background: #90EE90;
	padding: 5px;
	margin-bottom: 10px;
	font-size: 6px;
	font-weight: bold;
}

.successInfoCertificado {
	border: 1px solid green;
	color: black;
	background: #90EE90;
	padding: 5px;
	margin-bottom: 10px;
	font-size: 12px;
	font-weight: bold;
}

table {
	color: #000000;
	background-color: #F4F4F4;
	border-spacing: 1;
	font: 10px "Palatino Linotype", "Book Antiqua", Palatino, serif;
	padding: 0;
}

th {
	color: #000000;
	font-weight: 100;
	padding: 0;
	text-align: left;
	vertical-align: top;
}

tr {
	font-weight: 100;
}

td {
	padding: 0;
	text-align: left;
	vertical-align: top;
}

table {
	width: 100px;
	margin: 0 auto;
	border: 1px solid #ccc;
	margin-bottom: 40px;
	border-collapse: collapse;
}

tr {
	margin: 0px;
}

th {
	text-align: left;
	border: 1px solid #ccc;
	padding: 5px;
}

td {
	border: 1px solid #ccc;
	padding: 5px;
}
</style>

<script type="text/javascript"
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js'></script>
<script type="text/javascript"
	src=' http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js '></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>

<link rel="stylesheet" 
	  type="text/css"
	  href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css"/>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<link rel="stylesheet" 
	  type="text/css"
	  href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"/>

<link rel="stylesheet" 
	  type="text/css"
	  href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables_themeroller.css"/>

</head>
<body>
	<div class="header">
		<h1>Juridia</h1>
		<p class="currentUser">
			Usuario actual:
			<c:out value="${currentUser.name}" />
			<c:if test="${fn:length(currentUser.name) > 0}">
				<a href="<c:url value="/j_spring_security_logout"/>">Salir del sistema</a>
			</c:if>
			
			<c:if test="${fn:length(currentUser.name) <= 0}">
				ninguno
				<a href="<c:url value="/login"/>">Entrar al sistema</a>
			</c:if>
		</p>
	</div>