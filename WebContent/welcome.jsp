<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 获取list长度 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎</title>

    <style>
        ul {
            list-style-type: none;
        }

        ul li {
            float: left;
        }
    </style>
</head>
<body>
	欢迎${sessionScope.user.name }!!!
	<a href="../upload.jsp">上传图片</a>
	<a href="../picshow.jsp">查看相册</a>
	<br>
	<hr>
	<form action="../addPhoto.do" method="post">
		相册名： <input type="text" name="name" /> <br /> <input type="submit"
			value="添加" />
	</form>
	<hr>
	相册列表：
	<br>
<%-- 	<div style="width: 960px; height: 500px">
		<c:forEach var="msg" items="${sessionScope.list}">
			<div
				style="width: 200px;height: 200px;text-align: left;background-image: url('${pageContext.request.contextPath }/images/1.jpg')">
				<div
					style="width: 35px; height: 60px; padding-top: 165px; padding-left: 140px; font-size: 20px; color: rgba(255, 28, 21, 0.68)">
					${fn:length(sessionScope.list)}</div>
				<div style="width: 200px; height: 35px; text-align: center">
					<a href="../findPhoto.do?albumName=${msg.albumName}">${msg.albumName}</a>
				</div>
			</div>
		</c:forEach>
	</div> --%>
	
	<div style="width: 100%; height: 500px">
	
	    <ul>
	    <c:forEach var="msg" items="${sessionScope.list}">
        <li>
            <div style="padding: 17px">
                <div style="width: 140px;height: 170px;padding: 8px;text-align: left;background-color: #a6a6a6">
                    <div style="width: 140px;height: 145px;background-image: url('${pageContext.request.contextPath }/upload/${sessionScope.showlist[1].photoName})">
                        <img src="${pageContext.request.contextPath }/upload/${sessionScope.showlist[1].photoName}" layer-pname="HTML5资源教程 - 1" style="width: 140px;height: 145px;">
                    </div>
                    <div style="width: 140px;height: 25px;padding-top: 5px;text-align: left;">
                       <!--  <a href="#" style="color: #4f4f4f">999</a> -->
                        <a href="../findPhoto.do?albumName=${msg.albumName}" style="color: #4f4f4f">${msg.albumName}</a>
                    </div>
                </div>
            </div>
        </li>
        </c:forEach>
    </ul>
	</div>
</body>
</html>