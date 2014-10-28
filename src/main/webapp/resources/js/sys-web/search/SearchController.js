(function() {
    angular.module('travelWebSearch').controller('SearchController', ['$scope', '$http', function ($scope, $http) {

        $scope.constants = {
            maxSize: 10,
            pageSize: 12,
            firstText: '首页',
            lastText: '末页',
            previousText: '上一页',
            nextText: '下一页',
            ignoreTest: '不限'
        };

        $scope.travel = {
            api: 'api/travelSearch',
            apiMetaData: 'api/travelSearch/metaData',
            itineraryList: ['不限'],
            platformList: ['不限']
        };

        $scope.travelPage = {
            currentPage: 1,
            itineraryList: ['不限'],
            platformList: ['不限'],
            selectedItinerary: '不限',
            selectedPlatform: '不限',
            selectedOrder: 0
        };
        
        (function init() {
            console.log('travelWebSearch');
        }) ();

        $scope.selectMetaData = function (metaData) {

            $scope.travelPage.currentPage = 1;

            if (!_.isUndefined(metaData.itinerary)) {
                $scope.travelPage.selectedItinerary = metaData.itinerary;
            } else if (!_.isUndefined(metaData.platform)) {
                $scope.travelPage.selectedPlatform = metaData.platform;
            } else if (!_.isUndefined(metaData.order)) {
                $scope.travelPage.selectedOrder = metaData.order;
            }
            getTravel($scope.travelPage.currentPage);
        };
        
        $scope.searchTravel = function () {
            console.log('search');
            getTravel($scope.travelPage.currentPage);
        };

        (function init() {
//            getUser($scope.userPage.currentPage);
        }) ();

        $scope.pageChanged = function() {
            getTravel($scope.travelPage.currentPage)
        };

        function  getTravel(pageNum) {
            var params = {
                starting: '上海',
                destination : $scope.searchModel.destination,
                itinerary : $scope.constants.ignoreTest == $scope.travelPage.selectedItinerary ? '': $scope.travelPage.selectedItinerary,
                platform : $scope.constants.ignoreTest == $scope.travelPage.selectedPlatform ? '': $scope.travelPage.selectedPlatform,
                order : !!$scope.travelPage.selectedOrder,
                pageNum : pageNum
            }

            getTravelMetaData(params);

            $http({method: 'post', url: $scope.travel.api, data: params})
                .success(function(data, status) {
                    $scope.travelPage.totalNum = data.lines.size;
                    $scope.travelPage.lines = data.lines.items;
                })
                .error(function(data, status) {
                    console.log(data, status);
                });
        }

        function getTravelMetaData(params) {
            $http({method: 'get', url: $scope.travel.apiMetaData, params: params})
                .success(function(data, status) {
                    $scope.travelPage.itineraryList = $scope.travel.itineraryList.concat(_.sortBy(data.timeList, function(num){ return Number(num);}));
                    $scope.travelPage.platformList = $scope.travel.platformList.concat(data.platformList);
                })
                .error(function(data, status) {
                    console.log(data, status);
                });
        }
        
        
    }]);
})();