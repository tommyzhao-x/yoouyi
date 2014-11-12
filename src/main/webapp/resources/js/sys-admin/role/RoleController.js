angular.module('travelRole').controller('RoleController', ['$scope', '$http', function ($scope, $http) {
    
    $scope.role = {
            'api': 'admin/api/role'
    };
    
    $scope.rolePage = {
            currentPage: 1,
            roles: []
    };
    
    (function init() {
        getRole($scope.rolePage.currentPage);
    }) ();
    
    
    $scope.deleteRole = function (id) {
        console.log(id);
        $http({method: 'delete', url:  $scope.role.api + '/' + id})
        .success(function(data, status) {
            if(data.success) {
                getRole( $scope.rolePage.currentPage);
            }
        })
        .error(function(data, status) {
            console.log(data, status);
        });
    }
    
    $scope.pageChanged = function() {
        console.log('Page changed to: ' + $scope.rolePage.currentPage);
        getRole($scope.rolePage.currentPage);
      };
    
    function getRole(pageNum) {
        $http({method: 'get', url: $scope.role.api, params : {'page': pageNum}})
        .success(function(data, status) {
            $scope.rolePage.totalNum = data.totalNum;
            $scope.rolePage.roles = data.roles;
        })
        .error(function(data, status) {
            console.log(data, status);
        });
    }
}]);