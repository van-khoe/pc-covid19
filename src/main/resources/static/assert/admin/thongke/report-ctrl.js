app.controller("report-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.items2 = [];
	$scope.somui = 0;
	var temp = [];

	$scope.inttialize = function() {
		if ($scope.somui == 0) {
			$http.get('/rest/reports/chuatiem').then(resp => {
				$scope.items = resp.data;
			});

			$http.get('/rest/reports/chuatiem1').then(resp => {
				$scope.items2 = resp.data;

			});
		}
		else if ($scope.somui == 1) {
			$http.get('/rest/reports/tiemmui1').then(resp => {
				$scope.items = resp.data;
				$scope.items.forEach(item => {
					item[6] = new Date(item[6])
				})
				var items3 = [];
				for (var i = 0; i < $scope.items.length; i++) {
					temp = $scope.items[i];
					for (var j = 0; j < $scope.items.length; j++) {
						console.log(temp[0]);
						if (temp[0] == $scope.items[j][0]) {
							if (temp[6] < $scope.items[j][6]) {
								items3.push(temp);
							}
							else {
								
							}
							
						}
					}

				}
				$scope.items = items3;
			});
		}
		else {
			$http.get('/rest/reports/tiemmui2').then(resp => {
				$scope.items = resp.data;
				$scope.items.forEach(item => {
					item[6] = new Date(item[6])
				})
				var items3 = [];
				for (var i = 0; i < $scope.items.length; i++) {
					temp = $scope.items[i];
					for (var j = 0; j < $scope.items.length; j++) {
						console.log(temp[0]);
						if (temp[0] == $scope.items[j][0]) {
							if (temp[6] > $scope.items[j][6]) {
								items3.push(temp);
							}
							else {
								
							}
							
						}
					}

				}
				$scope.items = items3;
			});
		}
	}

	$scope.inttialize();


	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		}
	}

	$scope.pager2 = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items2.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		}
	}
});