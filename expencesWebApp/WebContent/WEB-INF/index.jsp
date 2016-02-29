

<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${message}</title>
<link type="text/css" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
<link type="text/css" rel="stylesheet"
	href="global/vendors/font-awesome/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="global/vendors/simple-line-icons/simple-line-icons.css">
<link type="text/css" rel="stylesheet"
	href="global/vendors/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="global/vendors/animate.css/animate.css">
<link type="text/css" rel="stylesheet"
	href="global/vendors/iCheck/skins/all.css">
<link type="text/css" rel="stylesheet"
	href="assets/vendors/bootstrap-switch/css/bootstrap-switch.css">
<link type="text/css" rel="stylesheet"
	href="assets/vendors/google-code-prettify/prettify.css">
<link type="text/css" rel="stylesheet" href="form_wizard.html"
	id="font-layout">
<link type="text/css" rel="stylesheet"
	href="assets/vendors/jquery-steps/css/jquery.steps.css">
<link type="text/css" rel="stylesheet" href="global/css/core.css">
<link type="text/css" rel="stylesheet" href="assets/css/system.css">
<link type="text/css" rel="stylesheet"
	href="assets/css/system-responsive.css">

<link type="text/css" rel="stylesheet" href="assets/css/style.css">

<link type="text/css" rel="stylesheet" href="assets/css/mobile.css">
</head>

<body style="background: url(img/pp.jpg)">
	<ng-view></ng-view>



	<!-- Libraries -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-resource.min.js"></script>





	<script src="js/login.js"></script>
	<script src="global/js/jquery-2.1.4.js"></script>
	<script src="global/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="global/js/jquery-ui.js"></script>
	<script src="global/vendors/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="global/vendors/bootstrap-hover-dropdown/bootstrap-hover-dropdown.js"></script>
	<script src="global/js/html5shiv.js"></script>
	<script src="global/js/respond.min.js"></script>
	<script src="global/vendors/metisMenu/jquery.metisMenu.js"></script>
	<script src="global/vendors/slimScroll/jquery.slimscroll.js"></script>
	<script src="global/vendors/iCheck/icheck.min.js"></script>
	<script src="global/vendors/iCheck/custom.min.js"></script>
	<script
		src="assets/vendors/bootstrap-switch/js/bootstrap-switch.min.js"></script>
	<script src="assets/vendors/google-code-prettify/prettify.js"></script>
	<script src="assets/vendors/jquery-cookie/jquery.cookie.js"></script>
	<script src="assets/vendors/jquery.pulsate.js"></script>
	<!--LOADING SCRIPTS FOR PAGE-->
	<script src="assets/vendors/jquery-validation/dist/jquery.validate.js"></script>
	<script src="assets/vendors/jquery-steps/js/jquery.steps.min.js"></script>
	<script
		src="assets/vendors/jquery-bootstrap-wizard/jquery.bootstrap.wizard.js"></script>
	<script src="assets/js/form-wizard.js"></script>
	<!--CORE JAVASCRIPT-->
	<script src="global/js/core.js"></script>
	<script src="assets/js/system-layout.js"></script>
	<script src="assets/js/jquery-responsive.js"></script>
	<script>
		jQuery(document).ready(function() {
			jQuery('.dropdown-toggle').dropdown();
		});
	</script>
	<script>
		jQuery(document).ready(function() {
			"use strict";
			JQueryResponsive.init();
			Layout.init();
		});
	</script>
	<script>
		jQuery(document).ready(function() {
			table_advanced.init();
		});
	</script>

	<script>
		jQuery(document).ready(function() {
			index.init();
		});
	</script>
</body>
</html>