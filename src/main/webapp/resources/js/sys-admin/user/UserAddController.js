(function() {
    angular.module('travelUser').controller('UserAddController', ['$scope', '$http', function ($scope, $http) {
        
        $scope.userAdd = {
                api: 'admin/api/user',
                allRoleApi: 'admin/api/role/all'
        };
        
        (function init() {
            getAllRoles();
        })();
        
        $scope.submitUser = function () {
            console.log($scope.userAdd);
            
            if ($scope.userAdd.formObj.$valid) {
                $http({method: 'post', url: $scope.userAdd.api, data: $scope.userAdd.formData})
                .success(function(data, status) {
                    if (data.success) {
                        $scope.userAdd.formData = {};
                    }
                })
                .error(function(data, status) {
                    console.log(data, status);
                });
            } 
            
        }
        
        function getAllRoles() {
            $http({method: 'get', url: $scope.userAdd.allRoleApi}).
            success(function(data, status) {
                $scope.userAdd.allRoles = data.roles;
                console.log(data, status);
            }).
            error(function(data, status) {
                console.log(data, status);
            });
        }
        
    }]);
})();