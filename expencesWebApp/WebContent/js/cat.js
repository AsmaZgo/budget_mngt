angular.module('app', ['ngRoute', 'ngResource'])

        //---------------
        // Services
        //---------------

		 .factory('Users', ['$resource', function($resource){
      // pour mongo api
			 //   return $resource('/expencesWebApp/rest/data/categories/:id', null, {
			    return $resource('/expencesWebApp/rest/cassandra/categories/:id', null, {
			        
			 'update': { method:'PUT' }
          });
         }])
		 .factory('UseLog', ['$resource', function($resource){
          return $resource('/UseLog/:id', null, {
            'update': { method:'PUT' }
          });
         }])

 .factory('leuser',function(){
      var formData = {};

    return {
        getData: function () {
            //You could also return specific attribute of the form data instead
            //of the entire data
            return formData;
        },
        setData: function (newFormData) {
            //You could also set specific attribute of the form data instead
            formData = newFormData
        },
        resetData: function () {
            //To be called when the data stored needs to be discarded
            formData = {};
        }
    };
})


        //---------------
        // Controllers
        //---------------

    

  .controller('UsersDetailCtrl', ['$scope', '$routeParams', 'Users','$location','leuser', function ($scope, $routeParams, Users, $location,
  leuser) {
           //$scope.user = Users.get({login: $routeParams.login });
		  // $scope.user = leuser
		  $scope.user =   leuser.getData();
     	 console.log($routeParams.login);  
     	 console.log($scope.user );  
     	// console.log(leuser);  
    
		 // Add a Item to the list
          $scope.update = function(){
            Users.update({id: $scope.user._id}, $scope.user, function(){
			  $location.url('/');
           });
	
		
		    
          }
		  	  	  
		    $scope.remove = function(){
           Users.remove({id: $scope.user._id}, function(){
             $location.url('/');
            });
          }
		  

        }])
		 .controller('UsersShowCtrl', ['$scope', '$routeParams', 'Users', '$location', function ($scope, $routeParams, Users, $location) {
           $scope.user = Users.get({id: $routeParams.id });

        }])
		
	.controller('UsersHomeController', ['$scope','$http','$location','leuser' ,function($scope,$http,$location,leuser) {
		  
	}])		
	 .controller('UsersController', ['$scope','$http','$location','Users' ,function($scope,$http,$location,Users) {
	 //['$scope', 'Users', 'UseLog','$location',  function ($scope, Users ,UseLog, $location) {
		       
		 $scope.users = Users.query();

		   	  console.log($scope.users );
		 $scope.loggedin = function(){
			 if($scope.user=== undefined)
				{$location.path("/");} 
			 
		 };
		// $scope.loggedin();
            $scope.save = function(){

  		   	  console.log($scope.login );
            	 console.log('klkkkkk' );
	        
		   	   //pour mongo api
            	 //  $http( {url: '/expencesWebApp/rest/data/categories',
    $http( {url: '/expencesWebApp/rest/cassandra/categories',
            method: 'GET' 
        }).success(function(response,request) {
     
    $scope.user=response;
        console.log( $scope.user);
	     
  }).error(function(data, status) {
	  console.error('Repos error', status, data);
	//  $location.path("/nohome");
	  $scope.error="user and password don't match , try again!";
	  $location.path("/");
  })
  .finally(function() {
    console.log("finally finished repos");
  }); 
     /* $http.post('/test', user).success(function(response) {
    console.log(response); 
	
      console.log("test");
	 // $location.path('/').replace();*/
	// $location.absUrl('/') ; 
 //  $location.path("/");
 /* }); */
        //    });
			
			 
           // console.log(req.body);
		   
          }
            $scope.save();
		 
          
 }])
 
 
		
		
	
    //---------------
        // Routes
        //---------------

        .config(['$routeProvider', function ($routeProvider) {
          $routeProvider
            .when('/', {
              templateUrl: 'template/categ/liste.html',
              controller: 'UsersController'
            })
   .when('/home', {
              templateUrl: 'template/login/home_page1.html',
              controller: 'UsersController'
            })
            .when('/test', {
              templateUrl: 'template/login/home_page1.html',
              controller: 'UsersController'
            })
            .when('/users', {
                templateUrl: 'template/login/home_page1.html',
                controller: 'UsersController'
              })
            
		/*	  .when('/home', {
              templateUrl: 'template/login/home_page.html',
              controller: 'UsersDetailCtrl'
           })

            .when('/profile/:login', {
              templateUrl: 'template/login/userDetails.html',
              controller: 'UsersDetailCtrl'
           })
		     .when('/details_user/:id', {
              templateUrl: 'template/login/userView.html',
              controller: 'UsersShowCtrl'
           })
		    .when('/detailsform/:id', {
              templateUrl: 'template/login/userView.html',
              controller: 'UsersShowCtrl'
           })*/
		   
        }]);