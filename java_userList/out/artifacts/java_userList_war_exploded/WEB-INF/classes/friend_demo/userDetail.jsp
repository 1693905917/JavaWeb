<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/friend_demo/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							2020/06/10
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
						User Detail:
					</h1>
					<table class="table">
						<tr>
							<td>
								姓名
							</td>
							<td>
								电话
							</td>
						</tr>
						<tr>
							<td>
								${detailUser.username}
							</td>
							<td>
								${detailUser.phone}
							</td>
						</tr>
					</table>
					<h1>
						Load Photo:
					</h1>
	
						<form action="userDetail.jsp" method="post"
							  enctype="multipart/form-data">
							Upload File Name:
							<input type="file" name="file1" />
							<input type="submit" value="confirm" />
						</form>

					<h1>
						view photo:
					</h1>
					<table>
								<tr>
									<td>
										<img src="upload/t1.jpg" width="300"
											height="200" />
									</td>
								</tr>
					</table>
				</div>
				<a href="userList.jsp">return</a>
			</div>
			<div id="footer">
				<div id="footer_bg">
					suyan@126.com
				</div>
			</div>
		</div>
	</body>
</html>
