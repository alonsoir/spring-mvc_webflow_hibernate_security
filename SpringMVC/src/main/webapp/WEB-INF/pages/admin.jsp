<%@ include file="common/header.jsp"%>
<!-- PAGINA DE INICIO PROVISIONAL -->
<div class="linkComunidades">
	<h2>
		Bienvenido
		<c:out value="${currentUser.name}" />
	</h2>
	<h4>Como administrador de Juridia Ud es el encargado de asignar un abogado a la demanda entrante.</h4>

	<h4>Para ello seleccione un abogado de la tabla.</h4>
	
	<form:form commandName="datosAbogado" method="post">
	<c:if test="${errorlistaDatosAbogados == 'true'}">
		<p class="failure">
			NO hay abogados disponibles en el sistema.
		</p>

	</c:if>

	<c:if test="${errorlistaDatosAbogados == 'false'}">
		
		<form:select path="idAbogado">
			<form:option value="">Seleccione un abogado</form:option>
   			<form:options items="${listaDatosAbogados}" />
		</form:select>

	
	</c:if>
	<h4>Seleccione una demanda</h4>
	
	<c:if test="${errorlistaDatosDemanda == 'true'}">
		<p class="failure">
			NO hay demandas.
		</p>

	</c:if>
	<c:if test="${errorlistaDatosDemanda == 'false'}">
		<table id="tablaDatosDemandasFincas" class="dataTable">
			<thead>
				<tr>
					<th></th>
					<th>ESTADO DEMANDA</th>
					<th>NOMBRE MOROSO</th>
					<th>TLF FIJO</th>
					<th>TLF MOVIL</th>
					<th>DIRECCION</th>
					<th>CP</th>
					<th>CIUDAD</th>
					<th>FECHA INICIAL DEMANDA</th>
					<th>MONTANTE</th>
					<th>USUARIO ADMIN FINCAS</th>
					<th>CERTIFICADO</th>
					<th>accion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="datosDemanda" items="${listaDatosDemanda}">
					<tr>
						<td>
							<form:radiobutton path="idDemanda" value="${datosDemanda.idDemanda}"/>
						</td>
						<td>${datosDemanda.estadoDemanda}</td>
						<td>${datosDemanda.nombreMoroso}</td>
						<td>${datosDemanda.tlfFijoMoroso}</td>
						<td>${datosDemanda.tlfMovilMoroso}</td>
						<td>${datosDemanda.direccionVivienda}</td>
						<td>${datosDemanda.cp}</td>
						<td>${datosDemanda.ciudad}</td>
						<td>${datosDemanda.fechaIniciaDemanda}</td>
						<td>${datosDemanda.montante}</td>
						<td>${datosDemanda.usernameFincas}</td>
						<td>
							<!-- esto esta fatal, por lo menos tengo que averiguar como se llama el nombre del contexto, es decir, el
					equivalente a /SpringMVC --> <a
							href="/SpringMVC/files/<c:out value="${datosDemanda.rutaCertificado}"/>"
							target="_blank">ver certificado</a>
						</td>
						<td>
							<input type="submit" name="" 
							   value="Asignar abogado seleccionado"  />
						
						</td>
						<td>
							<c:if test="${serviceResponse.estado == 'true'}">
								<p class="success">
				 					<c:out value="${serviceResponse.mensaje}"/>
								</p>
							</c:if>
			
							<c:if test="${serviceResponse.estado == 'false'}">
								<p class="failure">
				 					<c:out value="${serviceResponse.mensaje}"/>
									</p>
							</c:if>
			
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>

	</form:form>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('.dataTable').dataTable();
<%-- 
		$('#tablaDatosDemandasFincas').dataTable();
		$('#tablaListaDatosAbogados').dataTable();

--%>		
	});
</script>
<%@ include file="common/footer.jsp"%>
