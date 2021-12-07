const app = angular.module("dangky", []);

app.controller("covid", function($scope, $http) {
	$scope.items = [];
	$scope.inttialize = function() {

		$http.get("https://covid---phone-default-rtdb.firebaseio.com/covid-phone.json").then(resp => {
			$scope.items = resp.data;
			console.log("Thanhcong", resp);
		})
	}

	$scope.inttialize();
})

app.controller("home-ctrl", function($scope, $http) {
	$scope.reports = {};
	$scope.locations = [];



	$scope.inttialize = function() {
		$http.get("https://corona.lmao.ninja/v2/countries/vietnam").then(resp => {
			$scope.reports = resp.data;

			console.log($scope.reports);
		});

		$http.get("https://static.pipezero.com/covid/data.json").then(resp => {
			$scope.locations = resp.data.locations;

			console.log($scope.locations);
		});


	}

	$scope.inttialize();

	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.locations.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.locations.length / this.size);
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

})

app.controller("dangky-ctrl", function($scope, $http) {
	$scope.link = 'user';
	$scope.items = [];
	$scope.order = [];
	$scope.form = {};
	$scope.matkhau2;
	$scope.taikhoan;
	$scope.check = false;
	$scope.check2 = false;
	$scope.show = false;
	$scope.show2 = false;
	$scope.show3 = false;
	$scope.thongbao = 'Lỗi của bạn là';
	$scope.thongbao2 = 'Lỗi của bạn là';
	$scope.thongbao3 = 'Lỗi của bạn là';
	$scope.qmkTK;
	$scope.qmkEmail;

	$scope.form = {
		trangthai: true,
		gioitinh: 'Giới tính'
	};

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

	$scope.qmk = function() {
		var index = $scope.items.findIndex(p => p.username == $scope.qmkTK);
		if (index > 0) {
			if ($scope.items[index].trangthai == true) {
				if ($scope.items[index].email == $scope.qmkEmail) {
					$scope.check2 = true;
				}
				else {
					$scope.check2 = false;
				}
			}
			else {
				$scope.check2 = false;
			}

		}
		else {
			$scope.check2 = false;
		}
	}


	$scope.login = function() {
		var index = $scope.items.findIndex(p => p.username == $scope.taikhoan);
		if (index > 0) {
			if ($scope.items[index].trangthai == true) {
				if ($scope.items[index].matkhau == $scope.matkhau) {
					$scope.check = true;
				}
				else {
					$scope.check = false;
				}
			}
			else {
				$scope.check = false;
			}

		}
		else {
			$scope.check = false;
		}
	}

	$scope.thongbao = function() {

		if ($scope.qmkTK == null) {
			$scope.show3 = true;
			$scope.thongbao3 = 'Bạn chưa nhập tài khoản';
		}
		else if ($scope.qmkEmail == null) {
			$scope.show3 = true;
			$scope.thongbao3 = 'Bạn chưa nhập email';
		}
		else {
			var index = $scope.items.findIndex(p => p.username == $scope.qmkTK);
			console.log($scope.items);
			if (index > 0) {
				if ($scope.items[index].trangthai == true) {
					if ($scope.items[index].email == $scope.qmkEmail) {
						alert("Đã gửi");
					}
					else {
						$scope.show3 = true;
						$scope.thongbao3 = 'Tài khoản hoặc email không đúng';
					}
				}
				else {
					$scope.show3 = true;
					$scope.thongbao3 = 'Tài khoản đã bị vô hiệu hóa vui lòng liên hệ admin để được kích hoạt';
				}

			}
			else {
				$scope.show3 = true;
				$scope.thongbao3 = 'Tài khoản không tồn tại';
			}
		}

	}

	$scope.message123 = function() {
		if ($scope.taikhoan == null) {
			$scope.show = true;
			$scope.thongbao = 'Bạn chưa nhập tài khoản';
		}
		else if ($scope.matkhau == null) {
			$scope.show = true;
			$scope.thongbao = 'Bạn chưa nhập mật khẩu';
		}
		else {
			var index = $scope.items.findIndex(p => p.username == $scope.taikhoan);
			console.log($scope.items);
			if (index > 0) {
				if ($scope.items[index].trangthai == true) {
					if ($scope.items[index].matkhau == $scope.matkhau) {
						alert("Đăng nhập thành công");
					}
					else {
						$scope.show = true;
						$scope.thongbao = 'Tài khoản hoặc mật khẩu không đúng';
					}
				}
				else {
					$scope.show = true;
					$scope.thongbao = 'Tài khoản đã bị vô hiệu hóa';
				}

			}
			else {
				$scope.show = true;
				$scope.thongbao = 'Tài khoản không tồn tại';
			}
		}
	}


	$scope.inttialize();

	$scope.reset = function() {
		$scope.form = {
			trangthai
				: true
		}

		$scope.matkhau2 = "";

	}

	$scope.create2 = function() {
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
		else if ($scope.matkhau2 == null) {
			$scope.show2 = true;
			$scope.thongbao2 = 'Vui lòng nhập lại mật khẩu!';
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
			console.log(item);
			$scope.autho.account = angular.copy($scope.form);
			var index = $scope.items.findIndex(p => p.username == item.username);
			console.log(index);
			if (index < 0) {
				if (item.matkhau == $scope.matkhau2) {
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
					$scope.show2 = true;
					$scope.thongbao2 = 'Mật khẩu nhập lại không khớp!';

				}
			}
			else {
				$scope.show2 = true;
				$scope.thongbao2 = 'Tài khoản đã tồn tại!';
			}



		}
	}



})