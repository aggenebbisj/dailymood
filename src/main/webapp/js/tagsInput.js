angular.module('tagsInput', ['ngTagsInput']).controller('TagsInputCtrl', function ($scope, $http) {
    'use strict';

    // TODO load tags for autocompletion
    $scope.tags = [];

    $scope.tagValues = function () {
        return $scope.tags.map(function (tag) {
            return tag.text;
        }).join(", ");
    };

});



