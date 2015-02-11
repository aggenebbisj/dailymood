angular.module('moodBoardApp').controller('StatsCtrl', function ($scope, $rootScope, $http) {
    'use strict';
    var moodStatsResourceUrl = $rootScope.resourcePath + 'mood/today/stats';

    $scope.labels = ['Happy', 'Neutral', 'Sad'];
    $scope.series = ['Happiness'];

    var stats =
            $http({
                method: 'GET',
                url: moodStatsResourceUrl
            }).success(function (data) {
                $scope.data = [ [ data.happy, data.neutral, data.sad ] ];
                console.log(data);
            }).error(function (data) {
                // ignore
            });
});



