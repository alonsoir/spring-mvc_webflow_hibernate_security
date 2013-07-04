<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-15">
<title>Fincas morosas</title>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="linkComunidades">
		<h2>Fincas morosas</h2>
		<form:form modelAttribute="pojoFincas" method="post" id="fincasMorosasForm">
			<table>
				<tr>
					<td><form:label path="montante">Montante de la deuda</form:label>
						<form:input path="montante" maxlength="19" required="true" />
					</td>
					<td><form:label path="direccionViviendaDeudora">Direccion de la finca</form:label> 
					<form:input path="direccionViviendaDeudora" maxlength="100" required="true"/>
					</td>
					<td>
						<form:label path="tipo">
							Tipo de vivienda
							<form:select path="tipo" required="true">
									<form:options items="${tipo}" />
								</form:select>
						</form:label> 
							
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="textoLibreViviendasConDeudas">
							Introduzca datos relevantes a esta vivienda
							
						</form:label>
						<form:input path="textoLibreViviendasConDeudas" maxlength="255" required="true"/>
					</td>
					
				</tr>
				
			</table>


			<table>
				<tr>
					<td>
						<a href="${flowExecutionUrl}&_eventId=volverAMoroso"> 
							<img src="<c:url value="/resources/images/retroceder.jpg"/>" alt="Retroceder" />
						</a>
					</td>
					<td>
						<input type="submit" name="_eventId_guardarFinca" 
							   value="Guardar Finca" class="botonSave" />
						<c:if test="${idDeuda > 0}">
							<p class="success">Finca morosa creada con exito</p>								
						</c:if>
						<c:if test="${idDeuda <= 0}">
							<p class="failure">
								Datos del moroso actualizados exitósamente
							</p>
						</c:if>
						
					</td>
					<td>
						<a href="${flowExecutionUrl}&_eventId=avanzarACertificados"> 
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
	$(".boton").click(function() {

		$("#fincasMorosasForm").validate(
			{
			rules: {
				montante: {
					required: true,
					minlength: 1,
					maxlength: 19
				},
				direccionViviendaDeudora: {
					required: true,
					minlength: 10,
					maxlength: 100
				},
				tipo: {
					required: true
				},
				textoLibreViviendasConDeudas: {
					required: true,
					minlength: 5,
					maxlength: 255
				}
			},
			messages: {
				montante: { 
					required: "Introduzca el montante de la deuda",
					maxlength: "En serio la deuda es superior a un numero de 19 digitos?",
					error: "montante erróneo"
				},
				direccionViviendaDeudora: { 
					required: "Introduzca una direccion",
					minlength: "Escribe una direccion de al menos 10 caracteres",
					maxlength: "Escribe una direccion como mucho de 100 caracteres",
					error: "Direccion errónea"
				},
				textoLibreViviendasConDeudas: { 
					required: "Introduzca datos relativos a esta finca morosa",
					minlength: jQuery.format("Puede escribir al menos {0} caracteres"),
					maxlength: jQuery.format("Puede escribir {0} caracteres como mucho  ")
				},
				tipo: { 
					required: "Introduzca el nombre completo del moroso"
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