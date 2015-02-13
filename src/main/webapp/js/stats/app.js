var app = angular.module('statsApp', ['moodChart','moodTagCloud']);

app.run(function ($rootScope) {
    'use strict';
    $rootScope.resourcePath = '/dailymood/resources/';
});


