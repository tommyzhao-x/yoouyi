(function() {
    angular.module('travelWebMember').controller('FavoriteController', ['$scope','$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {
    
        
        $scope.memberFavorite = {
            api: {
                list: 'api/user/favorite',
                delete: 'api/user/favorite/delete'
            }
        };
        
        $scope.favoritePage = {
            currentPage: 0
        };
        
        
        
        (function init() {
            showUserFavorites();
        })();
        
        function showUserFavorites() {
            $http({method: 'get', url: $scope.memberFavorite.api.list, params: {pageNum: $scope.favoritePage.currentPage}})
            .success(function(result) {
                $scope.favoritePage.items = angular.forEach(result.data.items, function(item, key) {
                    item.createTime = new Date(item.createDate).getTime();
                });
                    console.log( $scope.favoritePage.items)
            });
        }

        $scope.unFavorite = function(item) {
            console.log(item)
            $http({method: 'post', url: $scope.memberFavorite.api.delete, data: item})
            .success(function(result) {
                    showUserFavorites();
            });
        }
        
    }]);
})();