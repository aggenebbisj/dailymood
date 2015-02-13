var app = angular.module('moodBoardApp', ['ngTagsInput']);

app.controller('TagsCtrl', function ($scope, $http) {
    'use strict';

    // TODO make initially empty
    $scope.tags = [];
    
    $scope.tagValues = function () {
        return $scope.tags.map(function(tag) {
            return tag.text;
        }).join(", ");
    };
    
});



