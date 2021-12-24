app.controller("tiemchung", function($scope, $http) {
	$scope.link = 'product';
	$scope.items = [];
	$scope.coso = [];
	$scope.form = {
		cosoyte: 'Thành phố Hà Nội'
	};
	$scope.nguoitiem = [];
	$scope.dottiem = [];


	$scope.inttialize = function() {
		$http.get("/rest/phieutiem").then(resp => {
			$scope.items = resp.data;
		});
		$http.get("/rest/nguoitiem").then(resp => {
			$scope.nguoitiem = resp.data;

		});
		$http.get("/rest/dottiem").then(resp => {
			$scope.dottiem = resp.data;
		});

		$http.get("https://provinces.open-api.vn/api/").then(resp => {
			$scope.coso = resp.data;
		});
	}

	$scope.inttialize();

	$scope.reset = function() {
		$scope.form = {
			cosoyte: 'Thành phố Hà Nội'
		}
		
		$("#dt").removeAttr("disabled");
		$("#nt").removeAttr("disabled");
		
		$("#delete").attr("disabled", 'disabled');
		$("#create").removeAttr("disabled");
		$("#update").attr("disabled", 'disabled');
	}

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
		
		$("#dt").attr("disabled", 'disabled');
		$("#nt").attr("disabled", 'disabled');
		
		$("#create").attr("disabled", 'disabled');
		$("#update").removeAttr("disabled");
		$("#delete").removeAttr("disabled");
	}

	$scope.create = function() {
		var dem = true;
		var item = angular.copy($scope.form);	
		if (item.dangkytiemchung == null) {
			$scope.thongbao = "Không được để trống mã người tiêm";
		}
		else if (item.dottiem == null) {
			$scope.thongbao = "Không được để trống mã đợt tiêm";
		}
		else if (item.diachi == null) {
			$scope.thongbao = "Không được để trống địa chỉ";
		}
		else if (item.cosoyte == null) {
			$scope.thongbao = "Không được để trống cơ sở y tế";
		}
		else {
			for (var i = 0; i < $scope.items.length; i++) {
				if (item.dangkytiemchung.idnguoitiem == $scope.items[i].dangkytiemchung.idnguoitiem
					&& item.dottiem.iddottiem == $scope.items[i].dottiem.iddottiem) {
					dem = true;
					break;
				} else {
					dem = false;
				}
			}
	

			if (dem == false) {
				$http.post(`/rest/phieutiem`, item).then(resp => {
					$scope.items.push(resp.data);
					$scope.reset();
					alert("Thêm mới phiếu tiêm thành công!");
					$scope.inttialize();
				}).catch(error => {
					alert("Lỗi thêm mới phiếu tiêm!");
					console.log(error);
				});
			} else {
				$scope.thongbao = "Đối tượng đã được thêm vào đợt tiêm này không thể thêm tiếp";
			}
		}
	}

	$scope.update = function() {
		var item = angular.copy($scope.form);
		if (item.dangkytiemchung == null) {
			$scope.thongbao = "Không được để trống mã người tiêm";
		}
		else if (item.dottiem == null) {
			$scope.thongbao = "Không được để trống mã đợt tiêm";
		}
		else if (item.diachi == null) {
			$scope.thongbao = "Không được để trống địa chỉ";
		}
		else if (item.diachi == "") {
			$scope.thongbao = "Không được để trống địa chỉ";
		}
		else if (item.cosoyte == null) {
			$scope.thongbao = "Không được để trống cơ sở y tế";
		}
		else if (item.cosoyte == "") {
			$scope.thongbao = "Không được để trống cơ sở y tế";
		}
		else {
			$http.put(`/rest/phieutiem/${item.idphieutiem}`, item).then(resp => {
				var index = $scope.items.findIndex(p => p.idphieutiem == item.idphieutiem);
				$scope.items[index] = item;
				alert("Cập nhật phiếu tiêm thành công!");
				$scope.inttialize();
			}).catch(error => {
				alert("Lỗi cập nhật phiếu tiêm!");
				console.log(error);
			});
		}
	}

	$scope.delete = function(item) {
		$http.delete(`/rest/phieutiem/${item.idphieutiem}`).then(resp => {
			var index = $scope.items.findIndex(p => p.idphieutiem == item.idphieutiem);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa phiếu tiêm thành công!");
			$scope.inttialize();
		}).catch(error => {
			alert("Lỗi xóa phiếu tiêm!");
			console.log(error);
		});
	}


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
});