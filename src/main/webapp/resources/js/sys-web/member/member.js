angular.module('travelWebMember', [ 'ngRoute', 'ui.bootstrap' ]).config(
    function($routeProvider) {
        $routeProvider.when('/member', {
            templateUrl : 'resources/views/sys-web/member.html',
            controller : 'SearchController'
        }).when('/member/favorites', {
            templateUrl : 'resources/views/sys-web/member/favorite.html',
            controller : 'FavoriteController'
        })
    });