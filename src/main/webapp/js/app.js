'use strict';
angular.module('moodBoardApp', ['chart.js'])
        .run(function ($rootScope) {
            $rootScope.serverUrl = 'localhost:8080/dailymood/';
            $rootScope.resourcePath = '/dailymood/resources/';
        });


