<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-ng-app="travelWeb" data-ng-controller="SearchController">
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>旅游比较</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <script src="resources/js/underscore-1.7.0/underscore-min.js"></script>

    <script src="resources/js/angular-1.2.25/angular.min.js"></script>
    <script src="resources/js/angular-1.2.25/angular-route.min.js"></script>
    <script src="resources/js/ui-bootstrap-0.11.2/ui-bootstrap-tpls-0.11.2.min.js"></script>

    <script src="resources/js/sys-web/app.js"></script>

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
            <div class="col-md-2 ly-left">
                <div class="logo"></div>
                <div class="slogan"></div>
            </div>
            <div class="col-md-10 ly-right">
                <div class="input-group">
                    <input type="text" id="travelDestination" data-ng-model="searchModel.destination"
                           name="destination" class="form-control" value="${requestScope.destination} ">

                    <div class="input-group-btn">
                        <button type="button" data-ng-click="searchTravel()" id="travelSearchBtn" class="btn btn-primary">搜索线路</button>
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
                    <span class="label label-primary">八达岭</span>
                    <span class="label label-primary">北海</span>
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
        <div class="col-md-10 ly-right">


            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">当前位置 > 旅游搜索</h3>
                </div>
                <div class="panel-body ly-meta">

                    <div class="row">
                        <div class="col-md-2 ly-meta-data">
                            行程天数：
                        </div>
                        <div class="col-md-10" id="itineraryList">
                            <span class="label {{ travelPage.selectedItinerary == itinerary ? 'label-primary' : 'label-default' }}"
                                  data-ng-click="selectMetaData({itinerary: itinerary})" data-ng-repeat="itinerary in travelPage.itineraryList">{{itinerary}}</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 ly-meta-data">
                            数据平台：
                        </div>
                        <div class="col-md-10" id="platformList">
                            <span class="label {{ travelPage.selectedPlatform == platform ? 'label-primary' : 'label-default' }}"
                                  data-ng-click="selectMetaData({platform: platform})" data-ng-repeat="platform in travelPage.platformList">{{platform}}</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 ly-meta-data">
                            价格排序：
                        </div>
                        <div class="col-md-10">
                            <span class="label {{ travelPage.selectedOrder == 0 ? 'label-primary' : 'label-default' }}" data-ng-click="selectMetaData({order: 0})" >升序</span>
                            <span class="label {{ travelPage.selectedOrder == 1 ? 'label-primary' : 'label-default' }}" data-ng-click="selectMetaData({order: 1})" >降序</span>
                        </div>
                    </div>

                </div>
            </div>

            <div class="panel panel-default">
                <div id="travelLines" class="panel-body">
                    <div class="col-md-12" data-ng-if="!travelPage.lines">
                        暂无此线路信息！
                    </div>
                    <div class="col-md-4 ly-line" data-ng-repeat="line in travelPage.lines">
                        <div class="thumbnail">
                            <a href="{{line.infoLink}}">
                                <img src="{{line.imageLink}}" class="ly-line-img" alt="{{line.title}}">
                            </a>
                            <div class="row ly-line-title">
                                <div class="col-md-12">{{line.title | limitTo:50}}</div>
                            </div>
                            <div class="ly-dashed"></div>

                            <div class="row ly-line-info">
                                <div class="col-md-6 text-left ly-line-price">￥{{line.price}}元</div>
                                <div class="col-md-6 text-right ly-line-platform">{{line.platform}}</div>
                            </div>
                            <div class="row ly-line-info">
                                <div class="col-md-6 text-left">{{line.port}}天行程</div>
                                <div class="col-md-6 text-right">
                                    <i class="glyphicon glyphicon-heart"></i>收藏
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="paginations">
                <pagination total-items="travelPage.totalNum" ng-model="travelPage.currentPage" ng-change="pageChanged()" max-size="constants.maxSize"
                            class="pagination-sm" boundary-links="true" rotate="false" items-per-page="constants.pageSize" first-text="{{constants.firstText}}"
                            last-text="{{constants.lastText}}" previous-text="{{constants.previousText}}" next-text="{{constants.nextText}}"></pagination>

            </div>

        </div>
    </div>

</div>

<footer class="footer">
    <p class="text-center">Copyright &copy; 2014 游易 版权所有</p>
</footer>
</body>
</html>
