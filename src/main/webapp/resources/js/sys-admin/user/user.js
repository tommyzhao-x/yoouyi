angular.module('travelUser',  ['ngRoute']).
    config(function ($routeProvider) {
        $routeProvider
            .when('/user', {
                templateUrl: 'resources/views/sys-admin/user/index.html',
                controller: 'UserController'
            })
            .when('/user/add', {
                templateUrl: 'resources/views/sys-admin/user/add.html',
                controller: 'UserAddController'
            })
    });