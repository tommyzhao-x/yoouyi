<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-ng-app="travelWeb">
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>旅游比较</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <script src="resources/js/underscore-1.7.0/underscore-min.js"></script>
    <script src="resources/js/jquery-1.11.1.min.js"></script>
    <script src="resources/js/jsrender.1.0.0-beta/jsrender.js"></script>

    <script src="resources/js/sys-web/search.js"></script>

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
                    <input type="text" id="travelKeyWord"
                           name="keyWord" class="form-control"
                           value="${requestScope.keyWord} ">

                    <div class="input-group-btn">
                        <button type="button" id="travelSearchBtn" class="btn btn-primary">搜索线路</button>
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
                        <div class="col-md-10" id="travelTimeList">
                            <span class="label label-primary">不限</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 ly-meta-data">
                            数据平台：
                        </div>
                        <div class="col-md-10" id="platformList">
                            <span class="label label-primary">不限</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 ly-meta-data">
                            价格排序：
                        </div>
                        <div class="col-md-10">
                            <span class="label label-primary">升序</span>
                            <span class="label label-default">降序</span>
                        </div>
                    </div>

                </div>
            </div>

            <div class="panel panel-default">
                <div id="travelLines" class="panel-body"></div>
            </div>

            <div id="pagination"></div>

        </div>
    </div>

</div>

<script id="travelTimeTemp" type="text/x-jsrender">
    <span class="label label-default">{{:#data}}</span>
</script>

<script id="platformTemp" type="text/x-jsrender">
    <span class="label label-default">{{:#data}}</span>
</script>

<script id="travelLineTemp" type="text/x-jsrender">


{{if  #index%3 == 0}}
<div class="row">
{{/if}}

    <div class="col-md-4 ly-line">
        <div class="thumbnail" href="../examples/dashboard/">
            <a href="{{>infoLink}}">
                <img src="{{>imageLink}}" width="249" height="164" alt="{{>title}}">
            </a>
            <div class="row ly-line-title">
                <div class="col-md-12">{{>title}}</div>
            </div>
            <div class="ly-dashed"></div>

            <div class="row ly-line-info">
                <div class="col-md-6 text-left ly-line-price">￥{{>price}}元</div>
                <div class="col-md-6 text-right ly-line-platform">{{>platform}}</div>
            </div>
            <div class="row ly-line-info">
                <div class="col-md-6 text-left">{{>port}}天行程</div>
                <div class="col-md-6 text-right">
                    <i class="glyphicon glyphicon-heart"></i>收藏
                </div>
            </div>
        </div>
    </div>

{{if #index%3 == 2}}
</div>
{{/if}}
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

<footer class="footer">
    <p class="text-center">Copyright &copy; 2014 游易 版权所有</p>
</footer>
</body>
</html>
