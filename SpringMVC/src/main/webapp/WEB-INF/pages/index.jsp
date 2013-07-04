<%@ include file="common/header.jsp" %>
<!-- ESTE CODIGO NO FUNCIONA ADECUADAMENTE,  -->
	<div class="login">
		<h2>Login User, alonso</h2>
		
		<c:if test="${login == 'login'}">
			<p class="success">User logged Successfully</p>
			<a href="${flowExecutionUrl}&_eventId=start">Avanzar al primer paso, comunidades.</a>
		</c:if>
		<form:form modelAttribute="user" method="post">
			<form:label path="userName">usuario o email</form:label><form:input path="userName" />
			<form:label path="password">Password</form:label><form:password  path="password" />
			<button type="submit" id="login">Log in</button>
			<button type="submit" id="create">Create User</button>
		</form:form>
	</div>
	
	<div class="link">
		<h2>Create User</h2>
		<c:if test="${saved == 'success'}">
			<p class="success">User Created Successfully</p>
		</c:if>
		<c:if test="${deleted == 'success'}">
			<p class="success">User Deleted Successfully</p>
		</c:if>
		<c:if test="${status == 'exist'}">
			<p class="error">User Already Exist</p>
		</c:if>
		<form:form modelAttribute="user" method="post">
			<form:label path="userName">User Name</form:label><form:input path="userName" />
			<form:label path="password">Password</form:label><form:password  path="password" />
			<button type="submit" id="save">Save User</button>
		</form:form>
	</div>

	<c:if test="${search == 'true'}">
	<table>
	<tr>
	<th>User Name</th>
	<th colspan="2">Actions</th>
	</tr>
	<c:if test="${empty users}">
	<tr>
		<td colspan="4">No results found!</td>
	</tr>
	</c:if>
	<c:forEach var="current" items="${users}">
		<tr>
		<td>${current.userName}</td>
		<td><a href="/edit/${current.userName}">Edit</a></td>
		<td><a href="/delete/${current.userName}">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	</c:if>

<script type="text/javascript">

	$(function() {
		$("#save").click(function(event) {
        	$("#user").attr("action", "/User/createUser")
			$("#user").submit();
		});

		$("#search").click(function(event) {
        	$("#user").attr("action", "/User/searchUser")
			$("#user").submit();

		});

		$("#login").click(function(event) {
        	$("#user").attr("action", "/User/loginUser")
			$("#user").submit();

		});

	});
</script>

<%@ include file="common/footer.jsp" %>
