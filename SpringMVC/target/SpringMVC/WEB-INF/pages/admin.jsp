<%@ include file="common/header.jsp"%>
<!-- PAGINA DE INICIO PROVISIONAL -->
<div class="linkComunidades">
	<h2>
		Bienvenido
		<c:out value="${currentUser.name}" />
	</h2>
	<h4>Como administrador de Juridia Ud es el encargado de asignar un abogado a la demanda entrante.</h4>

	<h4>Para ello seleccione un abogado de la tabla.</h4>
	
	errorlistaDatosAbogados: <c:out value="${errorlistaDatosAbogados}"/>
	
	<c:if test="${errorlistaDatosAbogados == 'true'}">
		<p class="failure">
			NO hay abogados disponibles en el sistema.
		</p>

	</c:if>

	<c:if test="${errorlistaDatosAbogados == 'false'}">
	
		<form:select path="datosAbogado">
   			<form:option value="NONE" label="--- Select ---"/>
   			<form:options items="${listaDatosAbogados}" />
		</form:select>
		<%-- 
		<table id="tablaListaDatosAbogados" class="dataTable">
			<thead>
				<tr>
					<th>NOMBRE</th>
					<th>APELLIDOS</th>
					<th>TLF CONTACTO</th>
					<th>CIUDAD</th>
					<th>CP</th>
					<th>DIRECCION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="datosAbogado" items="${listaDatosAbogados}">
					<tr>
						<td>${datosAbogado.nombre}</td>
						<td>${datosAbogado.apellidos}</td>
						<td>${datosAbogado.tlfContacto}</td>
						<td>${datosAbogado.ciudad}</td>
						<td>${datosAbogado.cp}</td>
						<td>${datosAbogado.direccion}</td>
						<td>
							<input type="radio" id="idAbogado" value="${datosAbogado.idAbogado}"/>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
			<!-- 
			<tfoot class="nav">
			<tr>
				<td colspan="2">
					<div class="pagination"></div>
					<div class="paginationTitle">Page</div>
					<div class="selectPerPage"></div>
					<div class="status"></div>
				</td>
			</tr>
			</tfoot>
			 -->
		</table>
		--%>
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
					<th>ESTADO DEMANDA</th>
					<th>NOMBRE MOROSO</th>
					<th>TLF FIJO</th>
					<th>TLF MOVIL</th>
					<th>FECHA INICIAL DEMANDA</th>
					<th>MONTANTE</th>
					<th>USUARIO ADMIN FINCAS</th>
					<th>CERTIFICADO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="datosDemanda" items="${listaDatosDemanda}">
					<tr>
						<td>${datosDemanda.estadoDemanda}</td>
						<td>${datosDemanda.nombreMoroso}</td>
						<td>${datosDemanda.tlfFijoMoroso}</td>
						<td>${datosDemanda.tlfMovilMoroso}</td>
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
							<input type="radio" id="idDemanda" value="${datosAbogado.idDemanda}"/>
						</td>
					
					</tr>
				</c:forEach>
			</tbody>
			<!-- 
			<tfoot class="nav">
			<tr>
				<td colspan="2">
					<div class="pagination"></div>
					<div class="paginationTitle">Page</div>
					<div class="selectPerPage"></div>
					<div class="status"></div>
				</td>
			</tr>
			</tfoot>
			 -->
		</table>
		</c:if>
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
