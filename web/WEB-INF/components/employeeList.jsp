<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-06-18
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
    var itemlistsize = ${employeeList.size()};
</script>

<jsp:include page="/WEB-INF/components/filterForm.jsp"></jsp:include>

<div id="main" class="${hiddenList ? "d-none" : ""}">
    <nav class="navbar navbar-expand-lg navbar-light bg-light border border-dark border-bottom-0">
        <div class="container">
            <a class="navbar-brand">雇员列表 查询到${employeeList.size()}条记录</a>
            <span>
                <button type="button" class="btn btn-outline-info">导出Excel</button>
                <button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#deleteModal">删除该查询下的所有记录</button>
            </span>
        </div>
    </nav>

    <div class="table-responsive border border-dark">
        <table class="table table-sm table-striped table-dark text-nowrap">
            <thead>
            <tr>
                <th scope="col" style="width: 48px;">#</th>
                <th scope="col">Name</th>
                <th scope="col">Job</th>
                <th scope="col">Hiredate</th>
                <th scope="col">Sal</th>
                <th scope="col">Comm</th>
                <th scope="col">MGR</th>
                <th scope="col">Dept</th>
                <th scope="col" style="width: 60px;">Edit</th>
                <th scope="col" style="width: 50px;">Del</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${employeeList}">
                <tr class="d-none" id="${item.rownum}">
                    <th scope="row">${item.rownum}</th>
                    <td>${item.name}</td>
                    <td>${item.job}</td>
                    <td>${item.hiredate}</td>
                    <td>${item.sal}</td>
                    <td>${item.comm}</td>
                    <td><a class="btn btn-sm btn-outline-info" role="button" aria-disabled="true">${item.mgrName}</a></td>
                    <td><a class="btn btn-sm btn-outline-warning" role="button" aria-disabled="true">${item.deptName}</a></td>
                    <td><a class="btn btn-sm btn-outline-primary" role="button" aria-disabled="true">编辑</a></td>
                    <td><a class="btn btn-sm btn-outline-danger" role="button" aria-disabled="true">×</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <hr>
    <jsp:include page="/WEB-INF/components/pagination.jsp"></jsp:include>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">操作警告</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                是否确认删除该查询下所有记录？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>

<script src="/staticResource/func/pagination.js"></script>