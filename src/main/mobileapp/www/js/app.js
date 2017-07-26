var app = (function() {
  return angular.module('MyApp', [
      'ionic',
      'ui.router',
      'ngResource',
      'ngSanitize',
      'custom.controllers',
      'custom.services',
      'datasourcejs',
      'pascalprecht.translate',
      'tmh.dynamicLocale',
      'ui-notification',
      'ngInputDate',
      'ngCordova',
      'ngFileUpload'
    ])

    .constant('LOCALES', {
      'locales': {
        'pt_br': 'Portugues (Brasil)',
        'en_us': 'English'
      },
      'preferredLocale': 'pt_br'
    })
    .run(function($ionicPlatform) {
      $ionicPlatform.ready(function() {
        // Remove splash screen
        setTimeout(function() {
          if (navigator.splashscreen) {
            navigator.splashscreen.hide();
          }
        }, 100);
        // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
        // for form inputs)
        if (window.cordova &&
          window.cordova.plugins.Keyboard) {
          cordova.plugins.Keyboard
            .hideKeyboardAccessoryBar(true);
          cordova.plugins.Keyboard.disableScroll(true);

        }
        if (window.StatusBar) {
          // org.apache.cordova.statusbar required
          StatusBar.styleDefault();
        }
      });
    })
    .config([
      '$httpProvider',
      function($httpProvider) {
        var interceptor = [
          '$q',
          '$rootScope',
          function($q, $rootScope) {
            var service = {
              'request': function(config) {
                var _u = JSON.parse(sessionStorage.getItem('_u'));
                if (_u && _u.token) config.headers['X-AUTH-TOKEN'] = _u.token;
                return config;
              }
            };
            return service;
          }
        ];
        $httpProvider.interceptors.push(interceptor);
      }
    ])
    .config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {
      $ionicConfigProvider.navBar.alignTitle('center')
    })

    .config(function($stateProvider, $urlRouterProvider, NotificationProvider) {
      NotificationProvider.setOptions({
        delay: 5000,
        startTop: 20,
        startRight: 10,
        verticalSpacing: 20,
        horizontalSpacing: 20,
        positionX: 'right',
        positionY: 'top'
      });

      // Set up the states
      $stateProvider

        .state('login', {
          url: "",
          controller: 'LoginController',
          templateUrl: 'views/login.view.html'
        })

        .state('main', {
          url: "/",
          controller: 'LoginController',
          templateUrl: 'views/login.view.html'
        })

        .state('app', {
          url: "/app",
          controller: 'HomeController',
          templateUrl: 'views/logged/menu.view.html'
        })

        .state('app.home', {
          url: "/home",
          controller: 'HomeController',
          views: {
            'menuContent': {
              templateUrl: 'views/logged/home.view.html'
            }
          }
        })

        .state('app.pages', {
          url: "/{name:.*}",
          controller: 'PageController',
          views: {
            'menuContent': {
              templateUrl: function(urlattr) {
                return 'views/' + urlattr.name + '.view.html';
              }
            }
          }
        })

        .state('404', {
          url: "/error/404",
          controller: 'PageController',
          templateUrl: function(urlattr) {
            return 'views/error/404.view.html';
          }
        })

        .state('403', {
          url: "/error/403",
          controller: 'PageController',
          templateUrl: function(urlattr) {
            return 'views/error/403.view.html';
          }
        });

      // For any unmatched url, redirect to /state1
      $urlRouterProvider.otherwise("/error/404");
    })

    .config(
      function($translateProvider, tmhDynamicLocaleProvider) {

        $translateProvider.useMissingTranslationHandlerLog();

        $translateProvider.useStaticFilesLoader({
          prefix: 'i18n/locale_',
          suffix: '.json'
        });

        $translateProvider.registerAvailableLanguageKeys([
          'pt_br', 'en_us'
        ], {
          'en*': 'en_us',
          'pt*': 'pt_br',
          '*': 'pt_br'
        });

        var locale = (window.navigator.userLanguage ||
            window.navigator.language || 'pt_br')
          .replace('-', '_');

        $translateProvider.use(locale.toLowerCase());
        $translateProvider.useSanitizeValueStrategy('escaped');

        tmhDynamicLocaleProvider
          .localeLocationPattern('plugins/angular-i18n/angular-locale_{{locale}}.js');
      })

    .directive('crnValue', ['$parse', function($parse) {
      return {
        restrict: 'A',
        require: '^ngModel',
        link: function(scope, element, attr, ngModel) {
          var evaluatedValue;
          if (attr.value) {
            evaluatedValue = attr.value;
          } else {
            evaluatedValue = $parse(attr.crnValue)(scope);
          }
          element.attr("data-evaluated", JSON.stringify(evaluatedValue));
          element.bind("click", function(event) {
            scope.$apply(function() {
              ngModel.$setViewValue(evaluatedValue);
            }.bind(element));
          });
        }
      };
    }])

    // General controller
    .controller(
      'PageController', [
        "$scope",
        "$stateParams",
        "$location",
        "$http",
        function($scope, $stateParams, $location, $http) {
          for (var x in app.userEvents)
            $scope[x] = app.userEvents[x].bind($scope);

          // save state params into scope
          $scope.params = $stateParams;
          $scope.$http = $http;

          // Query string params
          var queryStringParams = $location.search();
          for (var key in queryStringParams) {
            if (queryStringParams.hasOwnProperty(key)) {
              $scope.params[key] = queryStringParams[key];
            }
          }
        }
      ])

    .run(
      function($rootScope, $state) {
        $rootScope.$on('$stateChangeError', function() {
          if (arguments.length >= 6) {
            var requestObj = arguments[5];
            if (requestObj.status === 404 ||
              requestObj.status === 403) {
              $state.go(requestObj.status.toString());
            }
          } else {
            $state.go('404');
          }
        });
        
        $rootScope.$on('$stateChangeSuccess', function() {
          setTimeout(function() { 
            
            $($('.icon.ion-plus-round').parent()).off('click');
            $($('.icon.ion-plus-round').parent()).on('click',function() {
              $('[required]').removeClass('input-validation-error');
              $('input:invalid').removeClass('input-validation-error');
            });
            
            $($('.icon.ion-checkmark').parent()).off('click');
            $($('.icon.ion-checkmark').parent()).on('click',function() {
              $('[required].ng-invalid-required, [required].ng-invalid, [required].ng-empty').addClass('input-validation-error');
              $('input:invalid').addClass('input-validation-error');
            });
            
            $('input').off('keydown')
            $('input').on('keydown', function() {
              $(this).removeClass('input-validation-error');
            }); 
            
          }, 300);
            
        });
        
      });

}(window));

app.userEvents = {};
app.config.defaultRoute = "/app";