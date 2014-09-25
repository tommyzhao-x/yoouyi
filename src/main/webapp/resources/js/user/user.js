angular.module('travelUser',  ['ngRoute']).
    config(function ($routeProvider) {
        $routeProvider
            .when('/user', {
                templateUrl: 'resources/views/user/index.html',
                controller: 'UserController'
            })
            .when('/user/add', {
                templateUrl: 'resources/views/user/add.html',
                controller: 'UserAddController'
            })
    });