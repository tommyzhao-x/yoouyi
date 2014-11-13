<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-ng-app="travelWeb" data-ng-controller="TravelWebController">
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>旅游比较</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet">


    <script src="http://api.map.baidu.com/api?v=2.0&ak=T0vh70ZX0xIy8YfDQaBdzCAK"></script>
    <script src="resources/js/underscore-1.7.0/underscore-min.js"></script>

    <script src="resources/js/angular-1.2.25/angular.min.js"></script>
    <script src="resources/js/angular-1.2.25/angular-route.min.js"></script>
    <script src="resources/js/ui-bootstrap-0.11.2/ui-bootstrap-tpls-0.11.2.min.js"></script>

    <script src="resources/js/sys-web/app.js"></script>
    <script src="resources/js/sys-web/TravelWebController.js"></script>
    <script src="resources/js/sys-web/UserModalController.js"></script>

    <script src="resources/js/sys-web/search/search.js"></script>
    <script src="resources/js/sys-web/search/SearchController.js"></script>



    <script src="resources/js/jquery-1.11.1.min.js"></script>
    <script src="resources/js/jsrender.1.0.0-beta/jsrender.js"></script>

    <!--script src="resources/js/sys-web/search.js"></script-->

    <link rel="stylesheet/less" type="text/css" href="resources/css/lvyou.less" />
    <script src="resources/js/less-v2.0.0-b1/less.min.js"></script>

</head>

<body>

<header>

    <div class="container">

        <div class="top-ad">
            <img src="resources/images/topad.jpg" width="1140" height="50" alt=""/>
        </div>

        <div class="header">
            <div class="ly-logo-container">
                <div class="logo"></div>
                <div class="slogan"></div>

                <div class="ly-city dropdown">
                        <span class="label label-default dropdown-toggle" data-toggle="dropdown">
                            {{travelWeb.starting}}
                            <i class="caret"></i>
                        </span>
                    <div class="dropdown-menu ly-cities" role="menu" aria-labelledby="dropdownMenu1">
                        <span class="label {{ travelWeb.selectedCity.id == city.id ? 'label-primary' : 'label-default' }}" 
                        data-ng-click="changeCity(city)" data-ng-repeat="city in constants.cities">{{ city.city }}</span>
                    </div>
                    <div id="amap-container"></div>
                </div>
            </div>
            <div class="ly-search-container">
                <div class="col-md-10">
                    <div class="input-group">
                        <input type="text" id="travelDestination" data-ng-model="travelWeb.destination"
                               name="destination" class="form-control">

                        <div class="input-group-btn">
                            <button type="button" data-ng-click="searchTravel()" id="travelSearchBtn" class="btn btn-primary">搜索线路</button>
                        </div>
                    </div>
                </div>

                <div class="col-md-2 text-right">
                    <div data-ng-if="!travelWeb.userInfo.success">
                        <a data-ng-click="signUp()">注册</a>
                        <a data-ng-click="signIn()">登录</a>
                    </div>
                    <div data-ng-if="travelWeb.userInfo.success">
                        <span>{{ travelWeb.userInfo.data.username }}</span>
                    </div>
                </div>
            </div>
        </div>

    </div>

</header>

<div class="container">

    <div class="row main">
        <div class="col-md-2 ly-left">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">旅游线路推荐</h3>
                </div>
                <div class="panel-body ly-tuijian">
                    <a href="#" class="thumbnail">
                        <img src="resources/images/list2.jpg" alt="...">
                    </a>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">北京旅游景点</h3>
                </div>
                <div class="panel-body ly-jingdian">
                    <span class="label label-primary">
                        <a href="index/八达岭">八达岭</a>
                    </span>
                        <span class="label label-primary">
                            <a href="index/list2">北海</a>
                        </span>
                    <span class="label label-primary">天坛</span>
                    <span class="label label-primary">故宫</span>
                    <span class="label label-primary">天安门</span>
                    <span class="label label-primary">颐和园</span>
                    <span class="label label-primary">坤宁宫</span>
                    <span class="label label-primary">同仁堂</span>
                    <span class="label label-primary">卢沟桥</span>
                    <span class="label label-primary">大宅门</span>
                    <span class="label label-primary">大栅栏</span>
                    <span class="label label-primary">故宫</span>
                    <span class="label label-primary">天安门</span>
                    <span class="label label-primary">颐和园</span>
                    <span class="label label-primary">坤宁宫</span>
                    <span class="label label-primary">同仁堂</span>
                    <span class="label label-primary">卢沟桥</span>
                    <span class="label label-primary">大宅门</span>
                    <span class="label label-primary">大栅栏</span>
                    <span class="label label-primary">故宫</span>
                    <span class="label label-primary">天安门</span>
                    <span class="label label-primary">颐和园</span>
                    <span class="label label-primary">坤宁宫</span>
                    <span class="label label-primary">同仁堂</span>
                    <span class="label label-primary">卢沟桥</span>
                    <span class="label label-primary">大宅门</span>
                    <span class="label label-primary">大栅栏</span>
                </div>
            </div>

        </div>
        <div class="col-md-10 ly-right" data-ng-view>

        </div>
    </div>

</div>

<footer class="footer">
    <p class="text-center">Copyright &copy; 2014 游易 版权所有</p>
</footer>


</body>
</html>
