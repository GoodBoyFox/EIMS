<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-06-19
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="border border-dark p-4 rounded">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputName">Name</label>
            <input name="name" type="text" class="form-control" id="inputName" placeholder="Name">
        </div>
        <div class="form-group col-md-6">
            <label for="inputJob">Job</label>
            <input name="job" type="text" class="form-control" id="inputJob" placeholder="Job">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="inputSal">Sal</label>
            <input name="sal" type="number" class="form-control" id="inputSal" placeholder="Sal">
        </div>
        <div class="form-group col-md-4">
            <label for="inputComm">Comm</label>
            <input name="comm" type="text" class="form-control" id="inputComm" placeholder="Comm">
        </div>
        <div class="form-group col-md-4">
            <label for="inputHiredate">Hiredate</label>
            <input name="hiredate" type="text" class="form-control" id="inputHiredate" placeholder="xxxx-xx-xx">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-5">
            <label for="inputMgr">MGR</label>
            <input name="mgr" type="text" class="form-control" id="inputMgr" placeholder="MGR">
        </div>
        <div class="form-group col-md-5">
            <label for="inputDept">Dept</label>
            <input name="dept" type="text" class="form-control" id="inputDept" placeholder="Dept">
        </div>
        <div class="form-group col-md-2" style="position: relative;">
            <button style="position: absolute; right: 0; bottom: 0;" id="submit" type="submit" class="btn btn-block btn-primary">查找</button>
        </div>
    </div>
</form>