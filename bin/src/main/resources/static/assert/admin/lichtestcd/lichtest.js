app.controller("lichtest", function($scope, $http) {
	$scope.items = [];
	$scope.diaphuong = [];
	$scope.cates = [];
	$scope.maxdate = new Date();
	/*$scope.form = {};*/
	$scope.form = {
		ngaytest: new Date(),
		tinhthanh: 'Thành phố Hà Nội',
	};

	$scope.initialize = function() {
		//load lich test
		$http.get("/rest/lichtest").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.ngaytest = new Date(item.ngaytest);
			})
		});

		$http.get("https://provinces.open-api.vn/api/").then(resp => {
			$scope.diaphuong = resp.data;
		});
	}

	// Khởi đầu
	$scope.initialize();

	// Xóa form
	$scope.reset = function() {
		$scope.form = {
			ngaytest: new Date(),
			tinhthanh: 'Thành phố Hà Nội',
		};
		
		$("#delete").attr("disabled", 'disabled');
		$("#create").removeAttr("disabled");
		$("#update").attr("disabled", 'disabled');
	}

	// Hiển thị lên form
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
		
		$("#create").attr("disabled", 'disabled');
		$("#update").removeAttr("disabled");
		$("#delete").removeAttr("disabled");
	}

	// Thêm lịch test mới
	$scope.create = function() {
		var item = angular.copy($scope.form);
		if (item.soluongnguoitest == null) {
			$scope.thongbao = "Không được để trống số lượng người test"
		} else if (item.soluongnguoitest <= 0) {
			$scope.thongbao = "Số lượng người test phải từ 1 trở lên"
		} else if (item.mauamtinh == null) {
			$scope.thongbao = "Không được để trống số lượng mẫu âm tính"
		}
		else if (item.ngaytest == null) {
			$scope.thongbao = "Không được để trống ngày test"
		}
		else if (item.tinhthanh == null) {
			$scope.thongbao = "Không được để trống tỉnh thành"
		}
		else if (item.mauduongtinh == null) {
			$scope.thongbao = "Không được để trống số lượng mẫu dương tính"
		}
		else if (item.mauamtinh < 0) {
			$scope.thongbao = "Số lượng mẫu âm tính không được nhỏ hơn 0"
		}
		else if (item.mauduongtinh < 0) {
			$scope.thongbao = "Số lượng mẫu dương tính không được nhỏ hơn 0"
		}
		else if ((item.mauduongtinh + item.mauamtinh) != item.soluongnguoitest) {
			$scope.thongbao = "Số lượng mẫu thu được chưa tương ứng với số lượng người đã test"
		}
		else {
			$http.post(`/rest/lichtest`, item).then(resp => {
				resp.data.ngaytest = new Date(resp.data.ngaytest)
				$scope.items.push(resp.data);
				$scope.reset();
				alert("Thêm sản lịch test mới thành công");
				$scope.initialize();
			}).catch(error => {
				alert("Lỗi thêm lịch test mới");
				console.log("Error", error);
			});
		}
	}

	// Cập nhật lịch test
	$scope.update = function() {
		var item = angular.copy($scope.form);
		if (item.soluongnguoitest == null) {
			$scope.thongbao = "Không được để trống số lượng người test"
		} else if (item.soluongnguoitest <= 0) {
			$scope.thongbao = "Số lượng người test phải từ 1 trở lên"
		} else if (item.mauamtinh == null) {
			$scope.thongbao = "Không được để trống số lượng mẫu âm tính"
		}
		else if (item.ngaytest == null) {
			$scope.thongbao = "Không được để trống ngày test"
		}
		else if (item.tinhthanh == null) {
			$scope.thongbao = "Không được để trống tỉnh thành"
		}
		else if (item.mauduongtinh == null) {
			$scope.thongbao = "Không được để trống số lượng mẫu dương tính"
		}
		else if (item.mauamtinh < 0) {
			$scope.thongbao = "Số lượng mẫu âm tính không được nhỏ hơn 0"
		}
		else if (item.mauduongtinh < 0) {
			$scope.thongbao = "Số lượng mẫu dương tính không được nhỏ hơn 0"
		}
		else if ((item.mauduongtinh + item.mauamtinh) != item.soluongnguoitest) {
			$scope.thongbao = "Số lượng mẫu thu được chưa tương ứng với số lượng người đã test"
		}
		else {
			$http.put(`/rest/lichtest/${item.idlichtestcd}`, item).then(resp => {
				var index = $scope.items.findIndex(p => p.id == item.id);
				$scope.items[index] = item;
				alert("Cập nhật lịch test thành công");
				$scope.initialize();
			}).catch(error => {
				alert("Lỗi cập nhật lịch test");
				console.log("Error", error);
			});
		}
	}

	// Xóa lịch test
	$scope.delete = function(item) {
		$http.delete(`/rest/lichtest/${item.idlichtestcd}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa lịch test thành công");
			$scope.initialize();
		}).catch(error => {
			alert("Lỗi xóa lịch test");
			console.log("Error", error);
		});
	}

	$scope.pager = {
		page: 0,
		size: 8,
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
	};
});