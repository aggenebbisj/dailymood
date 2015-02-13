angular.module('tagsInput', ['ngTagsInput']).controller('TagsInputCtrl', function ($scope, $http) {
    'use strict';

    var completableTags = [];

    function initAutoComplete() {
        $http({
            method: 'GET',
            url: '/dailymood/resources/mood/tags'
        }).success(function (data) {
            completableTags = data;
        }).error(function (data) {
            // ignore
        });
    };

    $scope.loadTags = function (query) {
        return completableTags.filter(function(suggestion) {
            return suggestion.text.toLowerCase().indexOf(query.toLowerCase()) != -1;
        });
    };

    $scope.tags = [];

    $scope.tagValues = function () {
        return $scope.tags.map(function (tag) {
            return tag.text;
        }).join(", ");
    };

    initAutoComplete();
});



