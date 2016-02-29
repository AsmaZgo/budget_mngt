angular.module('app', ['ngRoute', 'ngResource'])

        //---------------
        // Services
        //---------------

		 .factory('Users', ['$resource', function($resource){
          return $resource('/listUserS/:id', null, {
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
	 .controller('UsersController', ['$scope','$http','$location','leuser' ,function($scope,$http,$location,leuser) {
	 //['$scope', 'Users', 'UseLog','$location',  function ($scope, Users ,UseLog, $location) {
		     
	//	 $scope.user = leuser; 
		 
		 $scope.loggedin = function(){
			 if($scope.user=== undefined)
				{$location.path("/");} 
			 
		 };
		// $scope.loggedin();
            $scope.save = function(){

  		   	  console.log($scope.login );
            	 console.log('klkkkkk' );
	       if(!$scope.login || $scope.login.length < 1) 
		   return;
		   	  console.log($scope.login );
		    var user =  { login: $scope.login ,
			  passwd: $scope.passwd  } ;
		    
			  console.log(user); 
			  var s ;
			  // user.$save(function(){
             // $scope.users.push(user);
			/*  $http.get('/expencesWebApp/index2.html?msg=Welcome_manager', user).success(function(response,request) {
			  });*/
			  
			 // pour mongo api
			  //   $http( {url: '/expencesWebApp/rest/data/log',
    $http( {url: '/expencesWebApp/rest/cassandra/log',
            method: 'GET',
            params: {
                login: user.login, 
                passwd:  user.passwd
            }
        }).success(function(response,request) {
    console.log(response.message);
    console.log("login");
    console.log("555login");
    
     s=response.session;
	  console.log(s);
	  console.log(request);
	  console.log(user); 
	  console.log(response);
	  console.log(response.msg);
	  $scope.user = response.message;
	     leuser.setData($scope.user);
	   console.log( response.msg === "error");
	   
//   $location.path("/profile/"+$scope.user.login);
	   if(response.msg === "error"){
  $location.path("/home");
  }
	   else{
		   $scope.user=user;
	   //if(response === "ok"){
		   $location.path("/test");}
  //$location.path("/");
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
		 
          
 }])
 
 
		
		
	
    //---------------
        // Routes
        //---------------

        .config(['$routeProvider', function ($routeProvider) {
          $routeProvider
            .when('/', {
              templateUrl: 'template/login/index.html',
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