var app = angular.module('moodBoardApp', ['angular-jqcloud']);

angular.module('moodTagCloud', ['angular-jqcloud']).controller('MoodTagCloudCtrl', function ($scope, $rootScope, $http) {
    'use strict';

    $scope.words = [];

    function mapTagToWordCloudObject(tag) {
        return {text: tag, weight: 10};
    }

    $http({
        method: 'GET',
        url: '/dailymood/resources/mood/today/tags'
    }).success(function (data) {
        $scope.sad = data.sadTags.map(mapTagToWordCloudObject);
        $scope.neutral = data.neutralTags.map(mapTagToWordCloudObject);
        $scope.happy = data.happyTags.map(mapTagToWordCloudObject);
    }).error(function (data) {
        // ignore
    });
});



