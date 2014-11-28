(function() {
    angular.module('travelWebSearch').controller('SearchController', ['$scope','$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {



        $scope.travel = {
            api: 'api/travelSearch',
            apiFavorite: 'api/user/favorite',
            apiMetaData: 'api/travelSearch/metaData',
            apiRecent: 'api/recent',
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
            $scope.parentlog();
            console.log('travelWebSearch', $routeParams);
            // split all search item
           if ($routeParams.searchItems) {
               var searchItems = $routeParams.searchItems.split('_');
               console.log(searchItems, _.size(searchItems));

               if (_.size(searchItems) == 5) {
                   $scope.travelPage.starting = searchItems[0];
                   $scope.travelPage.destination = searchItems[1];
                   $scope.travelPage.selectedItinerary = searchItems[2];
                   $scope.travelPage.selectedPlatform = searchItems[3];
                   $scope.travelPage.selectedOrder = searchItems[4];
//                   $rootScope.$broadcast('onSearchItems', generateParameters());
               }
               // load page data
               getTravel();

               getTravelMetaData();
           }
            
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

            $location.path(generateTravelLink());

        };


        $scope.pageChanged = function() {
            getTravel()
        };
        
        $scope.favorite = function(travel) {
            if (!$scope.travelWeb.userInfo.success) {
                $scope.signIn();
                return;
            }
            console.log(travel, $scope.travelWeb.userInfo);
            $http({method: 'post', url: $scope.travel.apiFavorite, data: {trip: {id: travel.id}}})
            .success(function() {
                
            });
        };
        
        $scope.clickTripLink = function(trip) {
            console.log(trip);
            $http({method: 'post', url: $scope.travel.apiRecent, data: {trip: {id: trip.id}}})
            .success(function() {
                
            });
        };

        function getUserCityByIp() {

        }

        function generateTravelLink() {

            return 'index/' + [$scope.travelPage.starting, $scope.travelPage.destination, $scope.travelPage.travelTime,
                $scope.travelPage.selectedItinerary, $scope.travelPage.selectedPlatform, $scope.travelPage.selectedOrder].join('_');
        }

        function  getTravel() {

            var params = generateParameters();

            $http({method: 'post', url: $scope.travel.api, data: params})
                .success(function(data, status) {
                    $scope.travelPage.totalNum = data.lines.size;
                    $scope.travelPage.lines = data.lines.items;
                })
                .error(function(data, status) {
                    console.log(data, status);
                });
        }

        function getTravelMetaData() {

            var params = generateParameters();

            $http({method: 'get', url: $scope.travel.apiMetaData, params: params})
                .success(function(data, status) {
                    $scope.travelPage.itineraryList = $scope.travel.itineraryList.concat(_.sortBy(data.timeList, function(num){ return Number(num);}));
                    $scope.travelPage.platformList = $scope.travel.platformList.concat(data.platformList);
                })
                .error(function(data, status) {
                    console.log(data, status);
                });
        }

        function generateParameters () {
            var params = {
                    starting: $scope.travelPage.starting,
                    destination : $scope.travelPage.destination,
                    itinerary : $scope.constants.ignoreTest == $scope.travelPage.selectedItinerary ? '': $scope.travelPage.selectedItinerary,
                    platform : $scope.constants.ignoreTest == $scope.travelPage.selectedPlatform ? '': $scope.travelPage.selectedPlatform,
                    order : !!$scope.travelPage.selectedOrder,
                    pageNum : $scope.travelPage.currentPage
                }
            
            return params;
        }
        
        
    }]);
})();