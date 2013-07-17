<%@ include file="common/header.jsp"%>
<!-- PAGINA DE INICIO PROVISIONAL -->
<div class="linkComunidades">
	<h2>
		Bienvenido
		<c:out value="${currentUser.name}" />
	</h2>
	<h4>Este es un listado de tus certificados emitidos por Juridia.</h4>
	
	<!-- Como hacer que este cacho solo lo vean el que tenga el perfil de los admin fincas -->
	<table id="tablaCertificadosFincas">
		<thead>
			<tr>
				<th>ESTADO DEMANDA</th>
				<th>NOMBRE MOROSO</th>
				<th>MONTANTE</th>
				<th>NOMBRE COMUNIDAD</th>
				<th>DIRECCION COMUNIDAD</th>
				<th>REF. CATASTRAL</th>
				<th></th>

			</tr>
		</thead>
		<tbody>
		<c:forEach var="certificado" items="${listaCertificados}">
			<tr>
				<td>${certificado.estadoDemanda}</td>
				<td>${certificado.nombreMoroso}</td>
				<td>${certificado.montante}</td>
				<td>${certificado.nombreComunidad}</td>
				<td>${certificado.direccionComunidad}</td>
				<td>${certificado.refCatastral}</td>
				<td>
				<!-- esto esta fatal, por lo menos tengo que averiguar como se llama el nombre del contexto, es decir, el
				equivalente a /SpringMVC -->
					<a href="/SpringMVC/files/<c:out value="${certificado.urlCertificado}"/>" target="_blank">ver
						certificado</a>
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
	
	<p>
	
		<h4>Tambien puedes empezar un nuevo proceso</h4>

		<a href="${flowExecutionUrl}&_eventId=start">Generar certificado de
		demanda y contactar con el despacho.</a>
	</p>
</div>
 
<script type="text/javascript">
$(document).ready(function() {
    $('#tablaCertificadosFincas').dataTable();
} );
</script>
<%@ include file="common/footer.jsp"%>
