var app = angular.module('moodBoardApp', ['tagsInput']);

app.run(function ($rootScope) {
    'use strict';
    $rootScope.resourcePath = '/dailymood/resources/';
});


