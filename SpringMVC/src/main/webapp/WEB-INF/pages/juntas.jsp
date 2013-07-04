<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Juntas de vecinos</title>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="linkComunidades">
		<h2>Juntas Ordinarias de comunidades de vecinos</h2>
		<form:form modelAttribute="pojoJuntas" method="post" id="juntasForm">
			<table>
				<tr>
					<td><label> Fecha de celebración</label> 
						<form:input path="fechaCelebracion" 
									id="fechaCelebracion" 
									readonly="readonly" 
									maxlength="12" 
									required="true" />
						
					</td>
					<td><form:label path="textoLibre">Introduzca los datos relevantes</form:label>
						<form:textarea path="textoLibre" 
									id="textoLibre"  
									maxlength="255" 
									required="true"
									cols="100"
									rows="20" />
						
					</td>

				</tr>
			</table>

			<table>
				<tr>
					<td>
						<a href="${flowExecutionUrl}&_eventId=inicio"> 
							<img src="<c:url value="/resources/images/retroceder.jpg"/>" alt="Retroceder" />
						</a>
					</td>
					<td>
						<input type="submit" name="_eventId_guardarJunta" value="Guardar" class="botonSave" />
						<c:if test="${mensajeJuntas == 'true'}">
							<p class="success">Datos de la junta creados o actualizados exitósamente</p>
								
						</c:if>
					</td>
					<td>
						<a href="${flowExecutionUrl}&_eventId=avanzarAComunidades"> 
							<img src="<c:url value="/resources/images/avanzar.jpg"/>" alt="Avanzar" />
						</a>
					</td>
				</tr>
			</table>

			
				
		</form:form>
		
		
	</div>
	<div class="linkMuroComunidades">aqui va a venir todo lo que el
		jorge diga</div>
<script type="text/javascript">

jQuery(function($){
	$.datepicker.setDefaults($.datepicker.regional['es']);

    $("#fechaCelebracion").datepicker({
        closeText: 'Cerrar',
        prevText: '<Ant',
        nextText: 'Sig>',
        currentText: 'Hoy',
        monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
        dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
        dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
        dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''});
    });
    
$(".botonSave").click(function() {

	$("#juntasForm").validate(
		{
		rules: {
			fechaCelebracion: {
				required: true
			},
			textoLibre: {
				required: true,
				maxlength: 255
			}
		},
		messages: {
			fechaCelebracion: { 
				required: "Escribe la fecha de celebración de la junta de vecinos",
				error: "Fecha de celebración erróneo"
			},
			textoLibre: { 
				required: "Introduzca los hechos acaecidos en la junta de vecinos",
				maxlength: 255
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