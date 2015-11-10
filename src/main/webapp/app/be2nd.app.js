(function () {
    'use strict';

	var be2ndApp = angular.module('app', [
	  'ngRoute'
	]);

	be2ndApp.config(['$routeProvider',
	  function($routeProvider) {
		$routeProvider.
		  when('/', {
			templateUrl: 'app/topic-list/topic-list.html',
			controller: 'TopicController',
			controllerAs: 'vm'
		  }).
		  when('/topic/:topicId', {
			templateUrl: 'app/message-list/message-list.html',
			controller: 'MessageController',
			controllerAs: 'vm'
		  }).
		  when('/file_upload', {
				templateUrl: 'app/fileUploader/index.jsp',
				controller: 'MessageController',
				controllerAs: 'vm'
			  }).
		  otherwise({
			redirectTo: '/'
		  });
	  }]);
})();
