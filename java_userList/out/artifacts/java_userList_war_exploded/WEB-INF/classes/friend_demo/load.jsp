<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/9/14
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl标准标签库-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/friend_demo/css/style.css" />
    <title>Title</title>
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
                    <a href="#">Load</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>

        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                修改信息页面
            </h1>
            <form action="update" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="left">
                            <input type="hidden" class="inputgri" name="id" value=${userLode.id}>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            昵称:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value=${userLode.name}>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="pwd" value=${userLode.password}>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            年龄:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age" value=${userLode.age}>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            性别:
                        </td>
                        <td valign="middle" align="left">
                            男
                            <input type="radio" class="inputgri" name="gendar" checked="checked"/>
                            女
                            <input type="radio" class="inputgri" name="gendar" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            电话:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="phone" value=${userLode.phone}>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;" />
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            rxx17362415996@sina.com
        </div>
    </div>
</div>
</body>
</html>
