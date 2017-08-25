<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head></head>
<body>

<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">添加员工</td>
</tr>
<tr>
<td align="right"> 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">返回</a>
</td>
</tr>
</table>

<br/>

<s:form id="saveForm" action="employee_save" method="post" namespace="/" theme="simple">
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>姓名</td>
<td><s:textfield name="ename"/></td>
<td>性别</td>
<td><s:radio name="sex" list="{'男','女'}"/></td>
</tr>
<tr>
<td>出生年月</td>
<td><s:textfield name="brithday"/></td>
<td>入职时间
<td><s:textfield name="joinDate"/></td>
</tr>

<tr>
<td>所属部门</td>
<td>
<s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"></s:select>
</td>
<td>编号</td>
<td><s:textfield name="eno"/></td>
</tr>
</table>
</s:form>

</body>
</html>