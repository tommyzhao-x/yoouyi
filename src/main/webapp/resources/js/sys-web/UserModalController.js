angular.module('travelWeb').controller('UserModalController', function ($scope, $modalInstance, pageInfo) {

    $scope.pageInfo = pageInfo;

    $scope.user = {
        rememberMe: false
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

            $modalInstance.close($scope.user);
        }
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancesl');
    };
});