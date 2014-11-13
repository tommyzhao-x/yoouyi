angular.module('travelWebSearch', [ 'ngRoute', 'ui.bootstrap' ]).config(
    function($routeProvider) {
        $routeProvider.when('/index', {
            templateUrl : 'resources/views/sys-web/search.html',
            controller : 'SearchController'
        }).when('/index/:searchItems*', {
            templateUrl : 'resources/views/sys-web/search.html',
            controller : 'SearchController'
        })
    });