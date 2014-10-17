(function() {
    angular.module('travelUser').controller('UserController', ['$scope', '$http', function ($scope, $http) {
        
        $scope.user = {
                'api': 'api/user'
        };
        

        $scope.userPage = {
                currentPage: 1,
                users: []
        };
        
        (function init() {
            getUser($scope.userPage.currentPage);
        }) ();
        
        $scope.pageChanged = function() {
            getUser($scope.rolePage.currentPage)
        }
        
        function getUser(pageNum) {
            $http({method: 'get', url: $scope.user.api, params: {'page': pageNum}})
            .success(function(data, status) {
                $scope.userPage.totalNum = data.totalNum;
                $scope.userPage.users = data.users;
            })
            .error(function(data, status) {
                console.log(data, status);
            });
        }
        
    }]);
})();