<%@ page contentType="text/html; charset=utf-8" language="java"
		 import="java.sql.*" errorPage="" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/UpdateServlet" method="post" id="form">
        <%--隐藏域--%>
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly="readonly"
                   placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <c:if test="${user.gender=='男'}">
                <label>性别：</label>
                <input type="radio" name="gender" value="男" checked/>男
                <input type="radio" name="gender" value="女"/>女
            </c:if>
            <c:if test="${user.gender=='女'}">
                <label>性别：</label>
                <input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女" checked/>女
            </c:if>

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" id="address" class="form-control">
                <c:if test="${user.address=='陕西'}">
                    <option value="陕西" selected>陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                </c:if>
                <c:if test="${user.address=='北京'}">
                    <option value="陕西">陕西</option>
                    <option value="北京" selected>北京</option>
                    <option value="上海">上海</option>
                </c:if>
                <c:if test="${user.address=='上海'}">
                    <option value="陕西">陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海" selected>上海</option>
                </c:if>

            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" value="${user.qq}" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" value="${user.email}"
                   placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置" id="b3"/>
            <input class="btn btn-default" type="button" value="返回" id="b2"/>
        </div>
    </form>
</div>
<script>
    /*返回*/
    document.getElementById("b2").onclick = function () {
        window.location.href = "${pageContext.request.contextPath}/FindUserByPageServlet";
    };
    /*重置*/
    document.getElementById("b3").onclick = function () {
        document.getElementById("form").reset();
    };
</script>
</body>
</html>