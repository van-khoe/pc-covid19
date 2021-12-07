app.controller("user-ctrl", function($scope, $http) {
	$scope.link = 'user';
	$scope.items = [];
	$scope.order = [];
	$scope.form = {};
	$scope.matkhau2;
	$scope.items2 = [];
	$scope.show2 = false;
	$scope.thongbao2 = 'Lỗi của bạn là';

	$scope.autho = {
		account: {},
		role: {
			idvaitro: 'USER',
			ten: 'User'
		}

	};

	$scope.inttialize = function() {
		$http.get("/rest/taikhoan/all").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.ngaysinh = new Date(item.ngaysinh)
			})
		});

	}

	$scope.inttialize();

	$scope.reset = function() {
		$scope.form = {
			ngaysinh: new Date()
		}

		$("#us").removeAttr("readonly");
		$("#delete").attr("disabled", 'disabled');
		$("#create").removeAttr("disabled");
		$("#update").attr("disabled", 'disabled');
	}
	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		console.log($scope.form);
		$(".nav-tabs a:eq(0)").tab('show')
		$("#us").attr("readonly", 'readonly');
		$("#create").attr("disabled", 'disabled');
		$("#update").removeAttr("disabled");
		$("#delete").removeAttr("disabled");
	}

	$scope.create = function() {
		var item = angular.copy($scope.form);
		console.log(item);
		if (item.hoten == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập họ tên!';
		}
		else if (item.username == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập tài khoản!';
		}
		else if (item.matkhau == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập mật khẩu!';
		}
		else if (item.email == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập email!';
		}
		else if (item.sdt == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập số điện thoại!';
		}
		else if (item.ngaysinh == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập ngày sinh!';
		}
		else if (item.gioitinh == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập giới tính!';
		}
		else if (item.diachi == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập đại chỉ!';
		}
		else {
			$scope.autho.account = angular.copy($scope.form);
			var index = $scope.items.findIndex(p => p.username == item.username);
			console.log(index);
			if (index < 0) {
				$http.post(`/rest/taikhoan`, item).then(resp => {
					resp.data.ngaysinh = new Date(resp.data.ngaysinh)
					$scope.items.push(resp.data);
					$scope.reset();
					alert("Thêm mới tài khoản thành công!");
					$http.post(`/rest/taikhoan/vaitro`, $scope.autho).then(resp => {
					}).catch(error => {
						alert("Lỗi !");
						console.log(error);
					});

				}).catch(error => {
					alert("Lỗi thêm mới tài khoản!");
					console.log(error);
				});
			}
			else {
				alert("Tài khoản đã tồn tại!");
			}
		}


	}



	$scope.update = function() {
		var item = angular.copy($scope.form);
		if (item.hoten == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập họ tên!';
		}
		else if (item.username == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập tài khoản!';
		}
		else if (item.matkhau == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập mật khẩu!';
		}
		else if (item.email == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập email!';
		}
		else if (item.sdt == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập số điện thoại!';
		}
		else if (item.ngaysinh == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập ngày sinh!';
		}
		else if (item.gioitinh == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập giới tính!';
		}
		else if (item.diachi == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập đại chỉ!';
		}
		else {
			$http.put(`/rest/taikhoan/${item.username}`, item).then(resp => {
				var index = $scope.items.findIndex(p => p.username == item.username);
				resp.data.ngaysinh = new Date(resp.data.ngaysinh)
				$scope.items[index] = item;
				alert("Cập nhật tài khoản thành công!");

			}).catch(error => {
				alert("Lỗi tài khoản sản phẩm!");
				console.log(error);
			});
		}
	}

	$scope.delete = function(item) {
		$http.get("/rest/nguoitiem").then(resp => {
			$scope.items2 = resp.data;
			var index = $scope.items2.findIndex(p => p.account.username == item);
			console.log(index);
			if (index < 0) {
				$http.delete(`/rest/capquyen/username/${item}`).then(resp => {
					$http.delete(`/rest/taikhoan/${item}`).then(resp => {
						var index = $scope.items.findIndex(p => p.username == item);
						$scope.items.splice(index, 1);
						$scope.reset();
						alert("Xóa tài khoản thành công!");

					}).catch(error => {
						alert("Lỗi xóa sản phẩm!");
						console.log(error);
					});
				});
			}
			else {
				alert("Tài khoản này đã bị vô hiệu hóa vì không thể xóa");
				var index = $scope.items.findIndex(p => p.username == item);
				item = $scope.items[index];
				item.trangthai = false;
				console.log(item);
				$http.put(`/rest/taikhoan/${item.username}`, item).then(resp => {
					var index = $scope.items.findIndex(p => p.username == item);
					resp.data.ngaysinh = new Date(resp.data.ngaysinh)
					$scope.items[index] = item;
				}).catch(error => {
					alert("Lỗi hủy kích hoạt tài khoản");
					console.log(error);
				});
			}
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