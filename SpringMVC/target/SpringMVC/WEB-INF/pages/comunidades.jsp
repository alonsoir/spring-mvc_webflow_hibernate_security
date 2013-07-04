<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comunidades de vecinos</title>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="linkComunidades">
		<h2>Comunidad de vecinos</h2>
		<form:form modelAttribute="pojoComunidades" method="post" id="comunidadesForm">
			<table>
				<tr>
					<td>
					<form:label path="refCatastral">
						Referencia Catastral
					</form:label>
						<%--<input type="text" name="refCatastral" id="refCatastral" maxlength="20" required="true"/>--%>
						
 					<form:input id="refCatastral" path="refCatastral" maxlength="20" required="false"/>
						 
					</td>
					<td>
						<form:label path="direccion">Dirección. (obligatorio)</form:label>
						<form:input path="direccion" required="true" maxlength="100"/>
					</td>
					<td><form:label path="ciudad">Ciudad</form:label> 
					<form:input path="ciudad" required="true" maxlength="20"/></td>
					
				</tr>
				<tr>
					<td>
						<form:label path="tipoParcela">
							Tipo de parcela
							<form:select path="tipoParcela" required="true">
								<form:options items="${tipoParcela}" />
							</form:select>
						</form:label>
					</td>
					<td><form:label path="nombreComunidad">Nombre de la Comunidad.</form:label>
						<form:input path="nombreComunidad" required="true" maxlength="255"/>
					</td>
					<td><form:label path="cp">Código postal.</form:label> 
					<form:input path="cp" required="true" maxlength="5"/></td>
				</tr>
				<tr>
					<td>
						<form:label path="presidenteCC">Presidente de la comunidad.</form:label>
						<form:input path="presidenteCC" maxlength="25"/>
					</td>
					<td>
						<form:label path="administradorFincas">Administrador de la comunidad</form:label>
						<form:input path="administradorFincas" required="true" maxlength="25"/>
					</td>
				</tr>
			</table>

			<table>
				<tr>
					<td>
						<a href="${flowExecutionUrl}&_eventId=volverAJuntas"> 
							<img src="<c:url value="/resources/images/retroceder.jpg"/>" alt="Retroceder" />
						</a>
					</td>
					<td>
						<input type="submit" name="_eventId_guardarComunidad" value="Guardar comunidad" class="botonSave" />
						<c:if test="${mensajeComunidades == 'true'}">
							<p class="success">Comunidad creada exitósamente</p>								
						</c:if>
						<c:if test="${mensajeComunidades == 'false'}">
							<p class="failure">
								Comunidad actualizada exitósamente
							</p>
						</c:if>
						
					</td>
					<td>
						<a href="${flowExecutionUrl}&_eventId=avanzaAMorosos"> 
							<img src="<c:url value="/resources/images/avanzar.jpg"/>" alt="Avanzar" />
						</a>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	<div class="linkMuroComunidades">
	aqui va a venir todo lo que el jorge diga
	</div>
	<script type="text/javascript">
<%--
	$("#refCatastral").change(
			function(event) {
				$("#pojoComunidades").attr("action",
						"${flowExecutionUrl}&_eventId=traerComunidad")
				$("#pojoComunidades").submit();
			});
--%>	
	$(".boton").click(function() {

		$("#comunidadesForm").validate(
			{
			rules: {
				refCatastral: {
					required: false,
					minlength: 20,
					maxlength: 20
				},
				ciudad: {
					required: true,
					minlength: 5,
					maxlength: 20
				},
				cp: {
					required: true,
					minlength: 5,
					maxlength: 5
				},
				tipoParcela: {
					required: true
				},
				nombreComunidad: {
					required: true,
					maxlength: 255
				},
				direccion: {
					required: true,
					maxlength: 100
				},
				presidenteCC: {
					required: true,
					maxlength: 25
				},
				administradorFincas: {
					required: true,
					maxlength: 25
				}
			},
			messages: {
				refCatastral: { 
					required: "Escribe la referencia catastral",
					minlength: "Escribe la referencia catastral",
					error: "Mail erróneo"
				},
				ciudad: { 
					required: "Introduzca la ciudad de la comunidad",
					maxlength: 20
				},
				cp: { 
					required: "Introduzca el código postal",
					maxlength: 5
				},
				tipoParcela: { 
					required: "Seleccione el tipo de parcela"
				},
				nombreComunidad: { 
					required: "Introduzca el nombre de la comunidad",
					maxlength: 30
				},
				direccion: { 
					required: "Introduzca la dirección de la comunidad",
					maxlength: 100
				},
				presidenteCC: { 
					required: "Introduzca el nombre completo del presidente",
					maxlength: 25
				},
				administradorFincas: { 
					required: "Introduzca el nombre completo del administrador",
					maxlength: 25
				}
			},
			errorPlacement: function(error, element) {
					error.appendTo(element.parent());
				}
			});
		});

</script>
<%@ include file="common/footer.jsp"%>
</body>
</html>