var app = angular.module('moodBoardApp', []);

app.run(function ($rootScope) {
    'use strict';
    console.log('remfoo');
    $rootScope.resourcePath = '/dailymood/resources/';
    console.log('app: ' + $rootScope);
});


