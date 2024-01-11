<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${errorMsg}</h2>
<form method="post">
	AgentId<input type="text" name="AgentId" placeholder="UserId">
	AgentName<input type="text" name="AgentName" placeholder="AgentName">
	<br><br>
	Password<input type="password" name="AgentPassword" placeholder="password">
	<br><br>
	<button>submit</button>
</form>
</body>
</html>