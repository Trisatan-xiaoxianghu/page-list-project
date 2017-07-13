<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  		
  			                      <h1 >登陆页面</h1>
<form name="frm1" action="IndexServlet" method="post" >
  		<table>
  			<tr>
  				<td>编号</td>
  				<td>
  					<input type="text" name="empId"/>
  					${requestScope.message } <!-- 如果用户不在系统中，给用户提示 -->
  				</td>
  			</tr>
  			<tr>
  				<td>用户名</td>
  				<td><input type="text" name="empName"/></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="submit" value="开始查询">
  				</td>
  			</tr>
  		</table>
  	
  	</form>
  			
  </body>
</html>
