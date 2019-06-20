<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-06-17
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>管理员登录</title>
</head>
<body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/staticResource/js/jquery.min.js"></script>
<script src="/staticResource/js/popper.min.js"></script>
<script src="/staticResource/js/bootstrap.min.js"></script>

<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="/staticResource/js/vue.js"></script>

<script src="/staticResource/js/axios.min.js"></script>

<div class="container">
    <div id="login" class="container jumbotron">
        <div class="alert alert-primary text-center" role="alert">管理员登录</div>

        <div class="form-group row">
            <label for="email" class="col-sm-2 col-form-label">用户名:</label>
            <div class="col-sm-10">
                <input v-model:value="name" type="text" class="form-control" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group row">
            <label for="password" class="col-sm-2 col-form-label">密码:</label>
            <div class="col-sm-10 input-group">
                <input v-model:value="password" type="password" class="form-control" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group row">
            <label for="vcode" class="col-sm-2 col-form-label">验证码:</label>
            <div class="col-sm-10 input-group">
                <div class="input-group-prepend">
                    <img src="/GetVCode" alt="vcode">
                </div>
                <input v-model:value="vcode" type="text" class="form-control" placeholder="请输入验证码.区分大小写!">
                <div class="input-group-prepend">
                    <button class="btn bg-danger" type="button" v-on:click="submit">Submit</button>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="loginalert" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">登录失败</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        {{loginAlert}}
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<hr class="my-5">

<blockquote class="blockquote text-center">
    <p class="mb-0 text-muted">公开管理员账户为<span class="badge badge-light">admin/pwd</span><br>本站为演示所用,请勿大规模删除数据</p>
    <small class="text-muted">一切解释权归 <cite title="Source Title">mooyyu</cite> 所有</small>
</blockquote>

<script src="/staticResource/func/md5.js"></script>
<script>
    var loginApp = new Vue({
        el: "div#login",
        data: {
            name: "",
            password: "",
            loginAlert: "",
            vcode: ""
        },
        methods: {
            submit: function() {
                if (this.name != "" && this.password != "" && this.vcode != "") {
                    var that = this;
                    axios.post('/checkLogin', {
                        name: that.name,
                        password: that.password.toString().MD5(),
                        vcode: that.vcode
                    }).then(function(res) {
                        if (res.data == "yes") {
                            window.location.href = "/admin/index.jsp";
                        } else {
                            $('div#loginalert').on('hidden.bs.modal', function () {
                                window.location.reload(true);
                            });
                            that.loginAlert = res.data;
                            $('div#loginalert').modal('show');
                        }
                    }).catch(function(error) {
                        console.info(error);
                    });
                } else {
                    this.loginAlert = "请将信息填写完整！";
                    $('div#loginalert').modal('show');
                }
            }
        }
    })
</script>
</body>
</html>