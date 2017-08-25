<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666">员工管理</td>
</tr>
<tr>
<td align="right" > <a href="{pageContext.request.contextPath}/employee_saveUI.action">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生年月</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
</thead>

<tbody>
<s:iterator value="list" var="e">
<tr>

<td align="center"><s:property value="#e.eno"/></td>
<td align="center"><s:property value="#e.ename"/></td>
<td align="center"><s:property value="#e.sex"/></td>
<td align="center"><s:date name="#e.brithday" format="yyyy-MM-dd"/></td>
<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
<td align="center"><s:property value="#e.department.dname"/></td>
<!-- 不是did   exception 
java.lang.IllegalArgumentException: id to load is required for loading--> 
<td align="center"><a href="{pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="#e.eid"/>"><img src="{pageContext.request.contextPath}/images/edit.png"</a></td>
<td align="center"><a href="{pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"/>"><img src="{pageContext.request.contextPath}/images/edit.png"</a></td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>

<table table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>
   <apan>
    <s:if test="currPage !=1">
       <a href="{pageContext.request.contextPath}/employee_findAll.action?currPage=1"">[首页]</a>&nbsp;&nbsp;
       <a href="{pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage-1"/>">[第一页]</a>&nbsp;&nbsp;
    </s:if> 
    <s:if test="currPage !=totalPage"> 
       <a href="{pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="{pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="totalPage"/>">[末页]</a>&nbsp;&nbsp;
     </s:if>  
   </span>
</td>
</tr>
</table>
</body>
</html>