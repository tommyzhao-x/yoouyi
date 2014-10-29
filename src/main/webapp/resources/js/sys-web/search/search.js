angular.module('travelWebSearch', [ 'ngRoute', 'ui.bootstrap' ]).config(
    function($routeProvider) {
        $routeProvider.when('/index', {
            templateUrl : 'search-main.html',
            controller : 'SearchController'
        }).when('/index/:searchItems*', {
            templateUrl : 'search-main.html',
            controller : 'SearchController'
        })
    });