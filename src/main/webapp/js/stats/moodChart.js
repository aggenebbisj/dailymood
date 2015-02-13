angular.module('moodChart', ['chart.js']).controller('MoodChartCtrl', function ($scope, $rootScope, $http) {
    'use strict';

    // TODO $rootScope.resourcePath does not get set for some weird reason
    // seems like app.js is not loaded correctly
    //var moodStatsResourceUrl = $rootScope.resourcePath + 'mood/today/stats';
    var moodStatsResourceUrl = '/dailymood/resources/mood/today/stats';

    function loadCumulativeMood() {
        $scope.series = ['Happy', 'Neutral', 'Sad'];
        $scope.labels = ['Happiness'];
        $scope.colours = ['#00ff00','#ff6600','#ff0000'];
        
        $http({
            method: 'GET',
            url: moodStatsResourceUrl
        }).success(function (data) {
            $scope.data = [[data.happy], [data.neutral], [data.sad]];
        }).error(function (data) {
            // ignore
        });
    }

    loadCumulativeMood();
});



