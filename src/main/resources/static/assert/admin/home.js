app.controller("home", function($scope, $http) {
	$scope.tongnguoidung;
	$scope.tongnguoidktiem;
	$scope.tongnguoimui1;
	$scope.tongnguoimui2;
	
	$scope.inttialize = function() {
		$http.get("/rest/taikhoan/counttk").then(resp => {
			$scope.tongnguoidung = resp.data;
		});
		
		$http.get("/rest/nguoitiem/counttc").then(resp => {
			$scope.tongnguoidktiem = resp.data;
		});
		
		$http.get("/rest/nguoitiem/countm1").then(resp => {
			$scope.tongnguoimui1 = resp.data;
		});
		
		$http.get("/rest/nguoitiem/countm2").then(resp => {
			$scope.tongnguoimui2 = resp.data;
		});

	}

	$scope.inttialize();
});