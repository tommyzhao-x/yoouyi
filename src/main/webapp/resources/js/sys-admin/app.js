angular.module('travel', ['travelHome', 'travelRole', 'travelUser' ]).run(
        function() {
            console.log('travel');
        }).config(function($locationProvider) {
            $locationProvider.html5Mode(true);
});