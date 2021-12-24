
app.controller("dottiem", function($scope, $http) {
	$scope.link = 'product';
	$scope.items = [];
	$scope.vaccine = [];
	$scope.show2 = false;
	$scope.thongbao2 = 'Lỗi của bạn là';
	$scope.form = {
	};

	$scope.inttialize = function() {
		$http.get("/rest/dottiem").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.ngaytiem = new Date(item.ngaytiem)
			})
			console.log($scope.items);
		});
		$http.get("/rest/vaccine").then(resp => {
			$scope.vaccine = resp.data;
		});
	}

	$scope.inttialize();

	$scope.reset = function() {
		$scope.form = {

		}
		$("#us").removeAttr("readonly");
		$("#delete").attr("disabled", 'disabled');
		$("#create").removeAttr("disabled");
		$("#update").attr("disabled", 'disabled');
	}

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
		$("#us").attr("readonly", 'readonly');
		$("#create").attr("disabled", 'disabled');
		$("#update").removeAttr("disabled");
		$("#delete").removeAttr("disabled");
	}

	$scope.create = function() {
		var item = angular.copy($scope.form);

		if (item.ngaytiem == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập ngày tiêm!';
		}
		else if (item.diadiemtiem == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập địa điểm tiêm!';
		}
		else if (item.vacxin == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng chọn loại vacxin!';
		}
		else {
			$http.post(`/rest/dottiem`, item).then(resp => {
				$scope.items.push(resp.data);
				$scope.reset();
				alert("Thêm mới đợt tiêm thành công!");

			}).catch(error => {
				alert("Lỗi thêm mới đợt tiêm!");
				console.log(error);
			});
		}
	}


	$scope.update = function() {
		var item = angular.copy($scope.form);

		if (item.ngaytiem == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập ngày tiêm!';
		}
		else if (item.diadiemtiem == null || item.diadiemtiem == "") {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập địa điểm tiêm!';
		}
		else if (item.vacxin.idvacxin == null || item.vacxin.idvacxin == "") {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng chọn loại vacxin!';
		}
		else {
			$http.put(`/rest/dottiem/${item.iddottiem}`, item).then(resp => {
				var index = $scope.items.findIndex(p => p.iddottiem == item.iddottiem);
				$scope.items[index] = item;
				alert("Cập nhật đợt tiêm thành công!");

			}).catch(error => {
				alert("Lỗi cập nhật đợt tiêm!");
				console.log(error);
			});
		}

	}


	/*  $scope.pager = {
		  page: 0,
		  size: 10,
		  get items(){
			  var start = this.page * this.size;
			  return $scope.items.slice(start, start + this.size);
		  },
		  get count(){
			  return Math.ceil(1.0 * $scope.items.length / this.size);
		  },
		  first(){
			  this.page = 0;
		  },
		  prev(){
			  this.page--;
			  if(this.page < 0){
				  this.last();
			  }
		  },
		  next(){
			  this.page++;
			  if(this.page >= this.count){
				  this.first();
			  }
		  },
		  last(){
			  this.page = this.count - 1;
		  }
	  }*/
});