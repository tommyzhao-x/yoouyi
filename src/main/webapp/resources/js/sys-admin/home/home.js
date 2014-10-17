angular.module('travelHome',  ['ngRoute']).
    config(function ($routeProvider) {
        $routeProvider.
            when('/main', {
                templateUrl: 'resources/views/sys-admin/home/main.html'
            }).otherwise({
                redirectTo: '/main'
            });
    });