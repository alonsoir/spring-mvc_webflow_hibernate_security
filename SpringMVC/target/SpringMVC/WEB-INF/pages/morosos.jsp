<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Morosos</title>
</head>
<body>		
<%@ include file="common/header.jsp"%>
<div class="linkComunidades">
		<h2>Datos del moroso</h2>		
		<form:form modelAttribute="pojoMorosos" method="post" id="morososForm">
			<table>
				<tr>
					<td><form:label path="nifCif">Introduzca el Identificador Fiscal</form:label>
						<form:input path="nifCif" minlength="9" maxlength="9" required="true"/>
					</td>
					<td><form:label path="tlffijo">Introduzca el Teléfono fijo del moroso</form:label> 
					<form:input path="tlffijo" minlength="11" maxlength="11" required="true"/>
					</td>
					<td><form:label path="tlfmovil">Introduzca el Teléfono movil del moroso</form:label> 
					<form:input path="tlfmovil" minlength="11" maxlength="11" required="true"/>
					</td>
					<td>
						<form:label path="cp">
							Introduzca el código postal.
							<form:input path="cp" minlength="5" maxlength="5" required="true"/>
						</form:label> 
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="nombreCompleto">
							Introduzca el Nombre completo del moroso
							
						</form:label>
						<form:input path="nombreCompleto" minlength="5" maxlength="25" required="true" />
					</td>
					<td>
						<form:label path="ciudad">
								Introduzca la ciudad del moroso					
						</form:label>
						<form:input path="ciudad" minlength="5" maxlength="25" required="true"/>
					</td>
					<td>
						<form:label path="direccionMoroso">
							Introduzca la dirección fiscal del moroso
						</form:label>
						<form:input path="direccionMoroso" minlength="5" maxlength="50" required="true" />
					</td>
				</tr>
				
			</table>

			<table>
				<tr>
					<td>
						<a href="${flowExecutionUrl}&_eventId=volverAComunidades"> 
							<img src="<c:url value="/resources/images/retroceder.jpg"/>" alt="Retroceder" />
						</a>
					</td>
					<td>
						<input type="submit" name="_eventId_guardarMoroso" 
							   value="Guardar datos de este moroso" class="botonSave" />
						<c:if test="${mensajeMoroso == 'true'}">
							<p class="success">Datos del moroso creados exitósamente</p>								
						</c:if>
						<c:if test="${mensajeMoroso == 'false'}">
							<p class="failure">
								Datos del moroso actualizados exitósamente
							</p>
						</c:if>
						
					</td>
					<td>
						<a href="${flowExecutionUrl}&_eventId=avanzarAFincas"> 
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

		$("#morososForm").validate(
			{
			rules: {
				nifCif: {
					required: true,
					minlength: 9,
					maxlength: 9
				},
				tlffijo: {
					required: true,
					minlength: 9,
					maxlength: 11
				},
				tlfmovil: {
					required: true,
					minlength: 9,
					maxlength: 11
				},
				cp: {
					required: true,
					minlength: 5,
					maxlength: 5
				},
				nombreCompleto: {
					required: true,
					minlength: 5,
					maxlength: 25
				},
				ciudad: {
					required: true,
					minlength: 5,
					maxlength: 25
				},
				direccionMoroso: {
					required: true,
					minlength: 5,
					maxlength: 50
				}
			},
			messages: {
				nifCif: { 
					required: "Escribe un nif o un cif",
					minlength: "Escribe un nif o un cif de 9 caracteres",
					maxlength: "Escribe un nif o un cif de 9 caracteres",
					error: "Nif erróneo"
				},
				tlf: { 
					required: "Introduzca un telefono",
					minlength: "Escribe un tlf de 11 caracteres",
					maxlength: "Escribe un tlf de 11 caracteres",
					error: "Nif erróneo"
				},
				cp: { 
					required: "Introduzca el código postal",
					minlength: jQuery.format("Escribe un tlf de al menos {0} caracteres"),
					maxlength: jQuery.format("Escribe un tlf de {0} caracteres como mucho"),
				},
				nombreCompleto: { 
					required: "Introduzca el nombre completo del moroso",
					minlength: jQuery.format("Escribe un nombre de al menos {0} caracteres"),
					maxlength: jQuery.format("Escribe un nombre de {0} caracteres como mucho")
				},
				ciudad: { 
					required: "Introduzca la ciudad",
					minlength: jQuery.format("Escribe una ciudad de al menos {0} caracteres"),
					maxlength: jQuery.format("Escribe una ciudad de {0} caracteres como mucho")
				},
				direccionMoroso: { 
					required: "Introduzca la dirección del moroso",
					minlength: jQuery.format("Escribe una dirección de al menos {0} caracteres"),
					maxlength: jQuery.format("Escribe una dirección de {0} caracteres como mucho")
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