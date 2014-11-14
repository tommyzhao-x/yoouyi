angular.module('travelWeb').controller('UserModalController', ['$scope', '$modalInstance', '$http', 'pageInfo', function ($scope, $modalInstance, $http, pageInfo) {

    $scope.pageInfo = pageInfo;

    $scope.user = {
        rememberMe: false,
        username: pageInfo.username
    };

    $scope.pageError = {
        invalidUsername: false,
        username: {
            tip: '请输入正确的邮箱格式！'
        },
        invalidPassword: false
    }

    $scope.ok = function () {
        console.log($scope.user, !$scope.user.username);

        if (!$scope.user.username) {
            $scope.pageError.invalidUsername = true;
        } else {
            
            var config = {method: 'post', url: $scope.pageInfo.api};
            
            if ($scope.pageInfo.isLogin) {
                config.params = $scope.user;
            } else {
                config.data = $scope.user;
            }
            
            $http(config)
            .success(function(data, status) {
                if ($scope.pageInfo.isLogin && data.success) {
                    $modalInstance.close(data);
                } else if (!$scope.pageInfo.isLogin) {
                    data.data = $scope.user;
                    $modalInstance.close(data);
                }
            })
        }
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancesl');
    };
}]);