angular.module('travelWeb', [ 'travelWebSearch' ]).run(function() {
    console.log('travelWeb');
}).config(function($locationProvider) {
    $locationProvider.html5Mode(true);
});