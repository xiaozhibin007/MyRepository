<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>FileUpload Index</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/uploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="file1" />
		<input type="submit" value="上传文件" />
	</form>
	
</body>
</html>