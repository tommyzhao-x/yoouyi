angular.module('travelHome',  ['ngRoute']).
    config(function ($routeProvider) {
        $routeProvider.
            when('/main', {
                templateUrl: 'resources/views/home/main.html'
            }).otherwise({
                redirectTo: '/main'
            });
    });