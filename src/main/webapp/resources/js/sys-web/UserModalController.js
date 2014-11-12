angular.module('travelWeb').controller('UserModalController', function ($scope, $modalInstance, pageInfo) {

    $scope.pageInfo = pageInfo;

    $scope.ok = function () {
        $modalInstance.close('yes');
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});