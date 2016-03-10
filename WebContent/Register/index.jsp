<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="register.do" method="post">
		<table align="center" width="520px" bgcolor="#ffe4b5">
			<caption><h2>注册</h2></caption>
			<tr height="40px">
			 <td colspan="2"><a href="view.jsp">查看所有用户</a></td>
			</tr>
			
			<tr height="40px">
      		<td bgcolor="#ffb700">姓名：</td>
      		<td><input name="name"> <font color="red"> * 姓名不能为空</font></td>
     		</tr>
     		<tr height="40px">
      		<td bgcolor="#ffb700">密码：</td>
      		<td><input name="password"> <font color="red"> * 密码不能为空</font></td>
     		</tr>
			<tr height="40px">
      		<td bgcolor="#ffb700">手机号：</td>
      		<td><input name="phone"> <font color="red"> * 手机号不能为空</font></td>
     		</tr>
			<tr bgcolor="#87cefa" height="40px">
      		<td colspan="2" align="center">
       		<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
       		<input type="reset" value="重置">
      		</td>
     		</tr>
		</table>
	</form>

</body>
</html>