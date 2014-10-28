angular.module('travelWebSearch', [ 'ngRoute', 'ui.bootstrap' ]).config(
    function($routeProvider) {
        $routeProvider.when('/index', {
            templateUrl : 'resources/views/sys-web/search/index.html',
            controller : 'SearchController'
        })
    });