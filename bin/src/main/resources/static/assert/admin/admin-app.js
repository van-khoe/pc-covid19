app = angular.module("admin-app", ["ngRoute"]);
app.config(function($routeProvider) {
	$routeProvider
		.when("/product", {
			templateUrl: "/assert/admin/loaivaccin/index.html",
			controller: "loaivaccin"
		})
		.when("/user", {
			templateUrl: "/assert/admin/user/index.html",
			controller: "user-ctrl"
		})
		.when("/dottiem", {
			templateUrl: "/assert/admin/dottiem/index.html",
			controller: "dottiem"
		})
		.when("/tiemchung", {
			templateUrl: "/assert/admin/tiemchung/index.html",
			controller: "tiemchung"
		})
		.when("/lichtest", {
			templateUrl: "/assert/admin/lichtestcd/index.html",
			controller: "lichtest"
		})
		.when("/baiviet", {
			templateUrl: "/assert/admin/blog/index.html",
			controller: "blog"
		})
		.when("/report", {
			templateUrl: "/assert/admin/thongke/index.html",
			controller: "report-ctrl"
		})
		.otherwise({
			templateUrl: "/assert/admin/home.html",
			controller: "home"
		});
})