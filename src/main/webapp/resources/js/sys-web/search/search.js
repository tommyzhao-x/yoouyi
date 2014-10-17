angular.module('travelWebSearch', [ 'ngRoute' ]).config(
    function($routeProvider) {
        $routeProvider.when('/search', {
            templateUrl : 'resources/views/sys-web/search/index.html',
            controller : 'SearchController'
        })
    });