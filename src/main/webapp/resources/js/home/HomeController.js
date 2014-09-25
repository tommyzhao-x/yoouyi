angular.module('travelHome').controller('HomeController', ['$scope', '$http', function ($scope, $http) {
    $http({method: 'get', url: 'api/getData'}).
        success(function(data, status) {
            console.log(data, status);
        }).
        error(function(data, status) {
            console.log(data, status);
        });
}]);