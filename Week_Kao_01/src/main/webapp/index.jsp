<%@ page contentType="text/html; charset=utf-8" language="java"
		 import="java.sql.*" errorPage="" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
  </head>
  <body>
  	<div class="container" style="width: 400px;">
  		<h3 style="text-align: center;">管理员登录</h3>
        <form action="${pageContext.request.contextPath}/intervieweeId/login" method="post">
	      <div class="form-group">
	        <label for="user">用户名：</label>
	        <input type="text" name="id" class="form-control" id="id" placeholder="请输入用户名" value=""/>
	      </div>
	      
	      <div class="form-group">
	        <label for="password">密码：</label>
	        <input type="password" name="password" value="" class="form-control" id="password" placeholder="请输入密码"/>
	      </div>
	      
	      
	      <hr/>
	      <div class="form-group" style="text-align: center;">
	        <input class="btn btn btn-primary" type="submit" value="登录">
		  </div>
	  	</form>
	  	<div class="form-group" style="text-align: center;">
	       	<a href="add.jsp">我是访客</a>
		 </div>
		
		<!-- 出错显示的信息框 -->
  	</div>
	<script>
		function refreshCode() {
			 var time = new Date().getTime();
			document.getElementById("vcode").src = "${pageContext.request.contextPath}/CheckCodeServlet?time="+time;
		}
	</script>
  </body>
</html>