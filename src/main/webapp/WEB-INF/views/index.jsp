<%@ page language="java" pageEncoding="UTF-8"
    contentType="text/html;charset=utf-8"%>
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

<script src="resources/js/underscore-1.7.0/underscore-min.js"></script>
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
            <div class="row">
                <div class="col-lg-6">

                </div>
            </div>
            <div class="row">
                <div class="col-md-4">行程天数：</div>
                <div class="col-md-8" id="travelTimeList"></div>

                <script id="travelTimeTemp" type="text/x-jsrender">
                    <a class="btn btn-default btn-sm">{{:#data}}</a>
                </script>
            </div>
            <div class="row">
                <div class="col-md-4">信息平台：</div>
                <div class="col-md-8" id="platformList"></div>

                <script id="platformTemp" type="text/x-jsrender">
                    <a class="btn btn-default btn-sm">{{:#data}}</a>
                </script>
            </div>
        </div>
    </div>

    <div id="travelLines" class="container"></div>
    <div id="pagination" class="container"></div>

    <script id="travelLineTemp" type="text/x-jsrender">
        <div class="row">
            <div class="col-md-4">
                <img src="{{>imageLink}}">
            </div>
            <div class="col-md-8">
                <h4>{{>title}}</h4>
                <p>{{>groupsLine}}</p>
            </div>
        </div>
    </script>
            

    <script id="paginationTemp" type="text/x-jsrender">
        <ul class="pagination">
          <li><a href="#">&laquo;</a></li>
          {{for nums}}
              <li><a href="#">{{:#index+1}}</a></li>
          {{else}}
              <li><a href="#">No DATA</a></li>
          {{/for}}
          <li><a href="#">&raquo;</a></li>
        </ul>
    </script>

</body>
</html>
