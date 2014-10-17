<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-ng-app="travelWeb" >
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

<script src="resources/js/angular-1.2.25/angular.min.js"></script>
<script src="resources/js/angular-1.2.25/angular-route.min.js"></script>

<script src="resources/js/sys-web/app.js"></script>

<script src="resources/js/sys-web/search/search.js"></script>
<script src="resources/js/sys-web/search/SearchController.js"></script>


</head>

<body>

    <div class="container">
        <form action="search" method="get">
            <div class="row">
                <div class="col-lg-6">
                    <div class="input-group">
                        <input type="text" name="keyWord"
                            class="form-control"
                            value="${requestScope.keyWord} ">

                        <div class="input-group-btn">
                            <button type="button" id="travelSearchBtn" class="btn btn-info">搜索线路</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>


</body>
</html>
