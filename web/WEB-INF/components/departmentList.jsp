<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-06-18
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Dao.departmentDao" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light border border-dark">
    <div class="container">
        <a class="navbar-brand">部门列表</a>
    </div>
</nav>
<c:set var="departmentList" value='<%=new departmentDao().getDepartmentList()%>'></c:set>

<div class="table-responsive border border-dark">
    <table class="table table-sm table-striped table-dark text-nowrap">
        <thead>
        <tr>
            <th scope="col" style="width: 48px;">#</th>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Info</th>
            <th scope="col">Employee</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${departmentList}">
            <tr>
                <th scope="row">${item.rownum}</th>
                <td>${item.name}</td>
                <td>${item.address}</td>
                <td><a href="/admin/index.jsp?aside=departmentInfo&id=${item.id}" class="btn btn-sm btn-outline-info" role="button" aria-disabled="true">查看${item.name}详情</a></td>
                <td><a href="/admin/index.jsp?aside=employeeList&deptno=${item.id}" class="btn btn-sm btn-outline-warning" role="button" aria-disabled="true">${item.name}雇员清单</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<hr>