(function() {
    angular.module('travelRole').controller('RoleAddController', ['$scope', '$http', function ($scope, $http) {
        
        $scope.roleAdd = {
                api: 'admin/api/role'
        };
        
        $scope.submitRole = function () {
            console.log($scope.roleAdd);
            
            if ($scope.roleAdd.formObj.$valid) {
                $http({method: 'post', url: $scope.roleAdd.api, params : $scope.roleAdd.formData})
                .success(function(data, status) {
                    if (data.success) {
                        $scope.roleAdd.formData = {};
                    }
                })
                .error(function(data, status) {
                    console.log(data, status);
                });
            } 
            
        }
    }])
})();