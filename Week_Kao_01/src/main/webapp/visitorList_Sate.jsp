<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage="" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网络在线考试――后台管理</title>
<script src="../../JS/jquery-2.1.0.min.js"></script>
<link href="<%=request.getContextPath()%>/CSS/style.css"
	rel="stylesheet"></link>
<script language="javascript">
	function CheckAll(elementsA, elementsB) {
		for (i = 0; i < elementsA.length; i++) {
			elementsA[i].checked = true;
		}
		if (elementsB.checked == false) {
			for (j = 0; j < elementsA.length; j++) {
				elementsA[j].checked = false;
			}
		}
	}
	//判断用户是否选择了要删除的记录，如果是，则提示“是否删除”；否则提示“请选择要删除的记录”
	function checkdel(delid, formname) {
		var flag = false;
		for (var i = 0; i < delid.length; i++) {
			if (delid[i].checked) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			alert("请选择要删除的记录！");
			return false;
		} else {
			if (confirm("确定要删除吗？")) {
				formname.submit();
			}
		}
	}


	//导出Excel
	function exportExcel() {
		//alert("点击了")
		//获取考生value值

		//跳转页面
		location.href = encodeURI("<%=request.getContextPath()%>/visitor/importZhong")

	}

</script>

</head>
<body>


	<table width="960" border="0" align="center" cellspacing="0"
		cellpadding="0">
		<tr>
		
			<td valign="top" bgcolor="#FFFFFF">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					align="center">
				
					<tr>
						<td align="center" valign="top">
							<form
								action="<%=request.getContextPath()%>/manage/examinee/examineeList"
								method="post" style="margin: 0px">
								<table width="96%" height="40" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td><input type="button" value="导出申请单"
											onclick="exportExcel()" /></td>
									</tr>
									</tr>
								</table>
							</form>
							<form
								action="${pageContext.request.contextPath}/DelSelectServlet"
								id="f1" method="post">
								<table border="1" class="table table-bordered table-hover">
									<tr class="success">
										<th><input type="checkbox" id="i1"></th>
										<th>申请人单号</th>
										<th>申请人id</th>
										<th>申请人</th>
										<th>被申请人</th>
										<th>当前状态</th>
										<th>操作</th>
									</tr>
									<c:forEach items="${zhongList}" var="map" varStatus="s">
										<tr>
											<td><input type="checkbox" name="uid" value="${map.get("id")}"></td>
											<td>${map.get("id")}</td>
											<td>${map.get("visitor_id")}</td>
											<td>${map.get("visitor_name")}</td>
											<td>${map.get("interviewee_name")}</td>
											<td>${map.get("state")}</td>
											<td><a class="btn btn-default btn-sm"
												href="${pageContext.request.contextPath}/visitor/proposer?visitorId=${sessionScope.visitor.get("
												id")}&intervieweeId=${map.get("interviewee_id")}">申请访问</a>&nbsp;
											</td>
										</tr>
									</c:forEach>
								</table>
								<table width="94%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="60%" height="24">&nbsp;</td>
										<td width="40%" align="right"><input name="checkbox"
											type="checkbox" class="noborder"
											onClick="CheckAll(studentForm.delIdArray,studentForm.checkbox)" />
											[全选/反选] [<a style="color: red; cursor: hand;"
											onClick="checkdel(studentForm.delIdArray,studentForm)">删除</a>]
											<!--层ch用于放置隐藏的checkbox控件，因为当表单中只是一个checkbox控件时，应用javascript获得其length属性值为undefine-->
											<div id="ch" style="display: none">
												<input name="delid" type="checkbox" class="noborder"
													value="0" />
											</div></td>
									</tr>
								</table>
							</form>


						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
