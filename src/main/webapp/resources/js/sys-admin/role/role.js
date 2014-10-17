angular.module('travelRole',  ['ngRoute', 'ui.bootstrap']).
    config(function ($routeProvider) {
        $routeProvider
            .when('/role', {
                templateUrl: 'resources/views/sys-admin/role/index.html',
                controller: 'RoleController'
            })
            .when('/role/add', {
                templateUrl: 'resources/views/sys-admin/role/add.html',
                controller: 'RoleAddController'
            })
    });