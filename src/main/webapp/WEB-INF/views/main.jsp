<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-ng-app="travel" data-ng-controller="TravelController">
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/" />
    
    <meta charset="utf-8" />
    <title>旅游比价系统 - 管理中心</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <link href="resources/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css" />
    
    <!--[if IE 7]>
    <link rel="stylesheet" href="resources/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- ace styles -->
    <link rel="stylesheet" href="resources/assets/css/ace.min.css" />
    <link rel="stylesheet" href="resources/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="resources/assets/css/ace-skins.min.css" />
    
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="resources/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- ace settings handler -->
    <script src="resources/assets/js/ace-extra.min.js"></script>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    
    <!--[if lt IE 9]>
    <script src="resources/assets/js/html5shiv.js"></script>
    <script src="resources/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div class="navbar navbar-default" id="navbar">
        <script type="text/javascript">
            try {
                ace.settings.check('navbar', 'fixed')
            } catch (e) {
            }
        </script>

        <div class="navbar-container" id="navbar-container">
            <div class="navbar-header pull-left">
                <a href="#" class="navbar-brand"> <small><i
                        class="icon-leaf"></i> 旅游比价系统- 管理中心</small>
                </a>
                <!-- /.brand -->
            </div>
            <!-- /.navbar-header -->

            <div class="navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav">
                    <li class="grey"><a class="dropdown-toggle"
                        href="/fenxiao/index.php?s=/Order/index/status/0.html">
                            待确认订单 <span class="badge badge-grey">4</span>
                    </a></li>

                    <li class="purple"><a class="dropdown-toggle"
                        href="/fenxiao/index.php?s=/Order/index/status/1.html">
                            待完成订单 <span class="badge badge-important">8</span>
                    </a></li>

                    <li class="green"><a class="dropdown-toggle"
                        href="/fenxiao/index.php?s=/Order/index/status/2.html">
                            已完成订单 <span class="badge badge-success">5</span>
                    </a></li>

                    <li class="light-blue"><a
                        data-toggle="dropdown" href="#"
                        class="dropdown-toggle"> 欢迎， admin <i
                            class="icon-caret-down"></i>
                    </a>

                        <ul
                            class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                            <li><a
                                href="/fenxiao/index.php?s=/Public/profile.html">
                                    <i class="icon-cog"></i> 修改资料
                            </a></li>
                            <li><a
                                href="/fenxiao/index.php?s=/Public/password.html">
                                    <i class="icon-user"></i> 修改密码
                            </a></li>
                            <li class="divider"></li>
                            <li><a href="login/signOut">
                                    <i class="icon-off"></i> 退出
                            </a></li>
                        </ul></li>
                </ul>
                <!-- /.ace-nav -->
            </div>
            <!-- /.navbar-header -->
        </div>
        <!-- /.container -->
    </div>
    <div class="main-container" id="main-container">
        <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

        <div class="main-container-inner">
            <a class="menu-toggler" id="menu-toggler" href="#"> <span
                class="menu-text"></span>
            </a>



            <div class="sidebar" id="sidebar">

                <!--sidebar-->
                <ul class="nav nav-list">
                    <li class="active">
                        <a data-ng-href="main">
                                <i class="icon-dashboard"></i> 
                                <span class="menu-text"> 主页 </span>
                        </a>
                    </li>

                    <li>
                        <a data-ng-href="config">
                                <i class="icon-desktop"></i> 
                                <span class="menu-text"> 系统配置 </span>
                        </a>
                    </li>

                    <li>
                        <a href="#" class="dropdown-toggle"> 
                            <i class="icon-group"></i> 
                            <span class="menu-text"> 角色管理 </span> 
                            <b class="arrow icon-angle-down"></b>
                        </a>

                        <ul class="submenu">
                            <li>
                                <a data-ng-href="role/add">
                                    <i class="icon-double-angle-right"></i> 增加角色
                                </a>
                            </li>
                            <li>
                                <a data-ng-href="role">
                                    <i class="icon-double-angle-right"></i>  角色用户
                                </a>
                            </li>

                        </ul>
                    </li>

                    <li>
                        <a href="#" class="dropdown-toggle"> 
                            <i class="glyphicon glyphicon-user"></i> 
                            <span class="menu-text"> 用户管理 </span> 
                            <b class="arrow icon-angle-down"></b>
                        </a>

                        <ul class="submenu">
                            <li>
                                <a data-ng-href="user/add">
                                    <i class="icon-double-angle-right"></i> 增加用户
                                </a>
                            </li>
                            <li>
                                <a data-ng-href="user">
                                    <i class="icon-double-angle-right"></i> 管理用户
                                </a>
                            </li>

                        </ul>
                    </li>
                    
                    <li><a href="#" class="dropdown-toggle"> <i
                            class="icon-bullhorn"></i> <span
                            class="menu-text">公告管理 </span> <b
                            class="arrow icon-angle-down"></b>
                    </a>

                        <ul class="submenu">
                            <li><a
                                href="/fenxiao/index.php?s=/Announce/add.html">
                                    <i class="icon-double-angle-right"></i>  增加公告
                            </a></li>
                            <li><a
                                href="/fenxiao/index.php?s=/Announce/index.html">
                                    <i class="icon-double-angle-right"></i> 管理公告
                            </a></li>


                        </ul></li>

                </ul>
                <!--sidebar-->

                <script type="text/javascript">
                    try {
                        ace.settings.check('sidebar', 'collapsed')
                    } catch (e) {
                    }
                </script>
            </div>


            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <div class="main-content" data-ng-view>

            </div>
            
        </div>


    </div>
    <!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up"
        class="btn-scroll-up btn btn-sm btn-inverse"> <i
        class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
    </div>
    <!-- basic scripts -->

    <script src="resources/js/jquery-1.11.1.min.js"></script>

    <script type="text/javascript">
        if ("ontouchend" in document) document.write("<script src='resources/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
    </script>
    <script src="resources/assets/js/bootstrap.min.js"></script>
    <script src="resources/assets/js/typeahead-bs2.min.js"></script>

    <!-- page specific plugin scripts -->

    <!--[if lte IE 8]>
<script src="resources/assets/js/excanvas.min.js"></script>
<![endif]-->



    <script src="resources/js/underscore-1.7.0/underscore-min.js"></script>

    <script src="resources/js/angular-1.2.25/angular.min.js"></script>
    <script src="resources/js/angular-1.2.25/angular-route.min.js"></script>
    
    <script src="resources/js/sys-admin/app.js"></script>
    <script src="resources/js/sys-admin/common/ui-bootstrap-tpls-0.11.0.js"></script>
    <script src="resources/js/sys-admin/common/TravelController.js"></script>
    
    <script src="resources/js/sys-admin/home/home.js"></script>
    <script src="resources/js/sys-admin/home/HomeController.js"></script>
    
    <script src="resources/js/sys-admin/role/role.js"></script>
    <script src="resources/js/sys-admin/role/RoleController.js"></script>
    <script src="resources/js/sys-admin/role/RoleAddController.js"></script>
    
    <script src="resources/js/sys-admin/user/user.js"></script>
    <script src="resources/js/sys-admin/user/UserController.js"></script>
    <script src="resources/js/sys-admin/user/UserAddController.js"></script>

    <!-- ace scripts -->
    <script src="resources/assets/js/ace-elements.min.js"></script>
    <script src="resources/assets/js/ace.min.js"></script>

    <script type="text/javascript" charset="utf-8"
        src="resources/editor/kindeditor.js"></script>
    <script type="text/javascript">
    var editor;
    KindEditor.ready(function(K) {
        editor = K.create('textarea[id="fx_content"]', {
            allowFileManager : true
        });
        K('#image_input').click(function() {
            editor.loadPlugin('image', function() {
                editor.plugin.imageDialog({
                    imageUrl : K('#url_input').val(),
                    clickFn : function(url, title, width, height, border, align) {
                        K('#url_input').val(url);
                        editor.hideDialog();
                    }
                });
            });
        });
    });

</script>

    <script src="resources/js/sys-admin/commonMenu.js"></script>

</body>