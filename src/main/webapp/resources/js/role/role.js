angular.module('travelRole',  ['ngRoute', 'ui.bootstrap']).
    config(function ($routeProvider) {
        $routeProvider
            .when('/role', {
                templateUrl: 'resources/views/role/index.html',
                controller: 'RoleController'
            })
            .when('/role/add', {
                templateUrl: 'resources/views/role/add.html',
                controller: 'RoleAddController'
            })
    });