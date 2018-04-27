<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>多文件上传</title>
        <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/default.css">
        <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="js/fileinput.js" type="text/javascript"></script>
        <!--简体中文-->
        <script src="js/locales/zh.js" type="text/javascript"></script>
</head>
<body>

<!-- 隐藏表单 -->
<form action="/Photo/findTest.do" method="post" id="index"></form>
<c:if test="commodities==null">
            <script>
                window.onload = function () {
                    document.getElementById("index").submit();
                }
            </script>
</c:if>
欢迎：${sessionScope.str}
<hr>



		
<form action="/Photo/upload.do?albumName=${msg.id}" enctype="multipart/form-data" method="post">
	<input type="file" name="image" multiple/><br>
	<select name="albumName"> 
		<c:forEach var="msg" items="${sessionScope.list}">
			<option value='${msg.id}'>${msg.albumName}</option> 
		</c:forEach>
	</select><br> 
	<input type="submit" value="提交上传">
</form>
</body>
</html>