var app = angular.module('moodBoardApp', ['chart.js']);

app.controller('StatsCtrl', function ($scope, $rootScope, $http) {
    'use strict';
    
    // TODO $rootScope.resourcePath does not get set for some weird reason
    // seems like app.js is not loaded correctly
    //var moodStatsResourceUrl = $rootScope.resourcePath + 'mood/today/stats';
    var moodStatsResourceUrl = '/dailymood/resources/mood/today/stats';
    
    $scope.labels = ['Happy', 'Neutral', 'Sad'];
    $scope.series = ['Happiness'];

    var stats =
            $http({
                method: 'GET',
                url: moodStatsResourceUrl
            }).success(function (data) {
                $scope.data = [ [ data.happy, data.neutral, data.sad ] ];
            }).error(function (data) {
                // ignore
            });
});



