<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8"/>
    <title>统一异常处理</title>
</head>
<body>
<h1>Error Handler</h1>
<div th:text="${url}">${url}</div>
<div th:text="${exception.message}">${exception.message}</div>
</body>
</html>