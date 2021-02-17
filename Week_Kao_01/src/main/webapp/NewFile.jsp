<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
        #d1{
            float: right;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">
        <%--指定内容查询--%>
        <form class="form-inline" action="${pageContext.request.contextPath}/FindUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${par.name[0]}" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" value="${par.address[0]}" class="form-control" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" name="email" value="${par.email[0]}" class="form-control" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>
    <div id="d1">
        <a class="btn" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn" href="javascript:void(0)" id="del">删除选中</a>
    </div>
    <form action="${pageContext.request.contextPath}/DelSelectServlet" id="f1" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="i1"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.pb.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/FindUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:del(${user.id}) ">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pb.currentPage==1}">
                <li class="disabled">
            </c:if>
             <c:if test="${pb.currentPage!=1}" >
                 <li>
             </c:if>
                <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage-1}&name=${par.name[0]}&address=${par.address[0]}&email=${par.email[0]}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" var="i" end="${requestScope.pb.totaPage}">
                <li><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${i}&name=${par.name[0]}&address=${par.address[0]}&email=${par.email[0]}">${i}</a></li>
            </c:forEach>
                <c:if test="${pb.currentPage==pb.totaPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage!=pb.totaPage}" >
                <li>
                    </c:if>
                <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage+1}&name=${par.name[0]}&address=${par.address[0]}&email=${par.email[0]}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 25px">共${requestScope.pb.totaCount}条数据，共${requestScope.pb.totaPage}页</span>
        </ul>
    </nav>
</div>
<script>
    //删除单个数据
    function del(id) {
        if (confirm("您确定要删除吗？")){
            window.location.href = "${pageContext.request.contextPath}/DelUserServlet?id=" + id;
        }
    }
    var byName = document.getElementsByName("uid");
    //删除所选中的数据
    document.getElementById("del").onclick = function () {

        if (confirm("您确定要删除所选中的吗？")) {
            //判断是否有选中条目
            var flag = false;

            for (var i = 0; i < byName.length; i++) {
                if (byName[i].checked){
                    flag = true;
                    break;
                }
            }
            //flag为true时
            if (flag) {
                document.getElementById("f1").submit();
            }

        }

    }
    //全选
    document.getElementById("i1").onclick = function () {
        for (var i = 0; i < byName.length; i++) {
            byName[i].checked = this.checked;
        }
    };
</script>
</body>
</html>
