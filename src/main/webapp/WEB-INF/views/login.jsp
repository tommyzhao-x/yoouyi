<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="http://${header.host}${pageContext.request.contextPath}/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>旅游比价系统 - 登录</title>
	<link href="resources/css/bootstrap.css" rel="stylesheet">

    <link href="resources/css/signin.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form class="form-signin" method='post' action="login/signIn" >
        <h2 class="form-signin-heading">管理中心</h2>
        <input type="text" class="form-control" name="username" placeholder="用户名" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="密码" required>
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> 记住我
        </label>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div>

</body>

