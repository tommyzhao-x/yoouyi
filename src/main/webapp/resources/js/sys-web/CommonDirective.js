angular.module('travelWeb').directive('yyShowRefer', [function() {
    return {
        restrict: 'EA',
        link: function (scope, element) {
            element.bind('mouseenter', function () {
                element.parent().addClass("ly-show-refer");
            }).bind('mouseleave', function () {
                element.parent().removeClass("ly-show-refer");
            })

        }
    };
}]);