<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-ng-app="travelWeb">
<head>
<base href="http://${header.host}${pageContext.request.contextPath}/" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>旅游比较</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<script src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/js/jsrender.1.0.0-beta/jsrender.js"></script>

<script src="resources/js/sys-web/search.js"></script>

</head>

<body>

    <div class="navbar navbar-default navbar-fixed-top"
        role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle"
                    data-toggle="collapse"
                    data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">旅游比价</a>
            </div>
            <div class="navbar-collapse collapse in">
                <form class="navbar-form navbar-right" role="form">
                    <div class="form-group">
                        <input type="text" placeholder="Email"
                            class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Password"
                            class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success">登录</button>
                </form>
            </div>
            <!--/.navbar-collapse -->
        </div>
    </div>

    <div class="jumbotron">
        <div class="container">
            <form action="search" method="get">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="input-group">
                            <input type="text" id="travelKeyWord"
                                name="keyWord" class="form-control"
                                value="${requestScope.keyWord} ">

                            <div class="input-group-btn">
                                <button type="button"
                                    id="travelSearchBtn"
                                    class="btn btn-info">搜索线路</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    
    <div id="travelLines" class="container">

        
    </div>

<script id="travelLineTemp" type="text/x-jsrender">
        <div class="row">
            <div class="col-md-4">
                <img src="{{>imageLink}}">
            </div>
            <div class="col-md-8">
                <h2>{{>title}}</h2>
                <p>{{>groupsLine}}</p>
            </div>
        </div>
</script>
</body>
</html>
