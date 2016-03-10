<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yinyxn.utils.DBPageUtils"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看留言</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
h4{
text-align: center;
}

a {
	text-decoration: none;
}
</style>
  </head>
  
  <body>
    <h2>查看留言信息</h2>
    <h4><a href="Messageboard/index.jsp"><font color="red">传送门</font></a></h4>
    <hr/>
    <%
         DBPageUtils dbp = new DBPageUtils();
         Object p = request.getParameter("page");
         Vector v = new Vector();
         if(p==null){
           v = dbp.getAlls(1);
         }else{
           v = dbp.getAlls(Integer.parseInt(p+""));
         }
         pageContext.setAttribute("dbp",dbp);
    %>
    <table border =1 >
    <c:forEach items="${dbp.datas}" var="row">
      <tr height="40px">
        <td>${row.id}</td>
        <td>${row.username}</td>
        <td>${row.topic}</td>
        <td>${row.content}</td>
        <td>${row.apptime}</td>
      </tr>
    </c:forEach>
    <tr>
    	<td colspan=5 align="center">
    		<a href="Messageboard/view.jsp?page=${dbp.page-1<1?1:dbp.page-1}">上一页</a>
    		<c:forEach begin="2" end="${dbp.max-1}" varStatus="idx">
    		 <a href="Messageboard/view.jsp?page=${idx.count+1}">${idx.count+1}</a>
    		</c:forEach>
    		<a href="Messageboard/view.jsp?page=${dbp.page+1}">下一页</a>
    	</td>
    </tr>
    </table>
  </body>
</html>
