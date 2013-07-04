<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>
	<%@ include file="common/header.jsp"%>
	<div class="login">
		<h3>Ingrese usuario y contraseña</h3>

		<c:if test="${not empty error}">
			<div class="errorblock">
				No has podido entrar en el sistema, intentalo de nuevo.<br /> 
				Causa : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>

		<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
			<table>
				<tr>
					<td>Usuario:</td>
					<td><input type='text' name='j_username' value='Introduzca un usuario y contraseña validos'></td>
				</tr>
				<tr>
					<td>Contraseña:</td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td colspan='2' valign="middle">
						<input name="submit" type="submit" value="Entrar" />
					</td>
				</tr>
				<tr>
					<td colspan='2' valign="middle">
						<input name="reset" type="reset" value="Borrar todo"/>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<%@ include file="common/footer.jsp"%>
</body>
</html>