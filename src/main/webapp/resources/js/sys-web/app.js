angular.module('travelWeb', ['travelWebSearch', 'travelWebMember', 'ui.bootstrap']).run(function() {
    console.log('travelWeb');
}).config(function($locationProvider) {
    $locationProvider.html5Mode(true);
});