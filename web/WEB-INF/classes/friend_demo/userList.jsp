<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/friend_demo/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							2020/06/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">Main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>

				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome! ${userLogin.username}
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Username
							</td>
							<td>
								Gender
							</td>
							<td>
								Age
							</td>
							<td>
                                操作
							</td>
						</tr>
						<c:forEach items="${userList}" var="user" varStatus="i">
							<tr class="row1">
								<td>
										${i.index+1}
								</td>
								<td>
										${user.username}
								</td>
								<td>
                                    <c:if test="${user.gender=='1'}">
                                        男
                                    </c:if>
                                    <c:if test="${user.gender=='0'}">
                                        女
                                    </c:if>

								</td>
								<td>
										${user.age}
								</td>

								<td>
									<a href="userDetail?id=${user.id}">详细</a>
									<c:if test="${userLogin.id==user.id}">
										<a href="load?id=${userLogin.id}">修改</a>
									</c:if>
								</td>

							</tr>
						</c:forEach>
					</table>

					<p>
						<input type="button" class="button" value="退出系统"
							onclick="location='login.html'" />
					</p>

				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					suyan@126.com
				</div>
			</div>
		</div>
	</body>
</html>
