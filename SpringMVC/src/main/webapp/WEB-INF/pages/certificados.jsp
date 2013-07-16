<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Certificados</title>
</head>
<body>		
<%@ include file="common/header.jsp"%>
<div class="linkComunidades">
		<h2>Certificados infoCertificado.estado:  <c:out value="${infoCertificado.estado }"/></h2>
		<form:form modelAttribute="pojoViviendas" method="post">
		
			<c:if test="${infoCertificado.estado == 'KO' || infoCertificado.estado == ''}">
				<p class="failure">
				 Debes completar todos los pasos anteriores para que puedas contratar con el despacho
				</p>
			</c:if>
			
			<c:if test="${infoCertificado.estado == 'OK'}">
			
				<p class="successInfoCertificado">
					Esto es un resumen de la información necesaria que te hemos pedido para poder generar la demanda y empezar el proceso.
					Pulsa el boton Contactar con el despacho para empezar el proceso y en breve nos pondremos en contacto con Ud.
				</p>
				
				<p class="successInfoCertificado">
					Código Postal: <c:out value="${infoCertificado.cp }"/>
				</p>
				<p class="successInfoCertificado">
					Dirección del moroso: <c:out value="${infoCertificado.direccionMoroso }"/>
				</p>
				
				<p class="successInfoCertificado">
					Identificador Fiscal: <c:out value="${infoCertificado.nif }"/>
				</p>
				<p class="successInfoCertificado">
					Nombre: <c:out value="${infoCertificado.nombre }"/>
				</p>
				<p class="successInfoCertificado">
					Teléfono Fijo: <c:out value="${infoCertificado.tlf_fijo }"/>
				</p>
				<p class="successInfoCertificado">
					Teléfono movil: <c:out value="${infoCertificado.tlf_movil }"/>
				</p>
				<p class="successInfoCertificado">
					Ciudad Moroso: <c:out value="${infoCertificado.ciudadMoroso }"/>
				</p>
				<p class="successInfoCertificado">
					Ciudad Comunidad: <c:out value="${infoCertificado.ciudadComunidad }"/>
				</p>
				<p class="successInfoCertificado">
					Nombre Comunidad: <c:out value="${infoCertificado.nombreComunidad }"/>
				</p>
				<p class="successInfoCertificado">
					Dirección de la comunidad: <c:out value="${infoCertificado.direccionComunidad }"/>
				</p>
				<p class="successInfoCertificado">
					Presidente: <c:out value="${infoCertificado.presi }"/>
				</p>
				<p class="successInfoCertificado">
					Administrador de la comunidad: <c:out value="${infoCertificado.adminComunidad }"/>
				</p>
				
				
				<p class="successInfoCertificado">
					Fecha de celebracion de la junta: <c:out value="${infoCertificado.fechaCelebracion }"/>
				</p>
				<p class="successInfoCertificado">
					Conclusiones de la junta de vecinos: <c:out value="${infoCertificado.textoLibre }"/>
				</p>
				
				
				<table>
				<tr>
					<td>
						<a href="${flowExecutionUrl}&_eventId=volverAFincasMorosas">
							<img src="<c:url value="/resources/images/retroceder.jpg"/>" alt="Retroceder" />
						</a>
					</td>
					<td>
						<input type="submit" name="_eventId_contactarDespacho" 
							   value="Contactar con el despacho" class="botonSave" />
						<!-- esto tiene que cambiar, mensajeCertificado es ahora un objeto complejo con un boolean y el mensaje -->
						<c:if test="${mensajeCertificado.estado == 'true'}">
							<p class="success">
								YEAH! <c:out value="${mensajeCertificado.mensaje}"/>
							</p>
						
						</c:if>
		
						<c:if test="${mensajeCertificado.estado == 'false'}">
							<p class="failure">
								UPPPS! <c:out value="${mensajeCertificado.mensaje}"/>
							</p>
						
						</c:if>				
					</td>
					<td>
						<a href="${flowExecutionUrl}&_eventId=acabarProcesoCertificado1"> 
							<img src="<c:url value="/resources/images/avanzar.jpg"/>" alt="Avanzar" />
						</a>
					</td>
				</tr>
				</table>
			</c:if>
				
				
		
		
		</form:form>
	</div>
	<div class="linkMuroComunidades">
	aqui va a venir todo lo que el jorge diga
	</div>

<%@ include file="common/footer.jsp"%>

</body>
</html>