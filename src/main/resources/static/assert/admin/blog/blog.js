app.controller("blog", function($scope, $http){
    $scope.items = [];
    $scope.country = [];
    $scope.form = {
    };

    $scope.inttialize = function(){
        $http.get("/rest/blog").then(resp => {
            $scope.items = resp.data;
     
        });
        
    	
    }

    $scope.inttialize();

    $scope.reset = function(){
		$scope.form = {
		hinhanh: 'cloud-upload.jpg'
			}
		$("#us").removeAttr("readonly");
		$("#delete").attr("disabled", 'disabled');
        $("#create").removeAttr("disabled");
        $("#update").attr("disabled", 'disabled');
    }
    
    $scope.reset();

    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
        $("#us").attr("readonly", 'readonly');
        $("#create").attr("disabled", 'disabled');
        $("#update").removeAttr("disabled");
        $("#delete").removeAttr("disabled");
    }

    $scope.create = function(){
  
		var item = angular.copy($scope.form);
	
		$http.post(`/rest/blog`,item).then(resp => {
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới bài viết thành công!");
			
		}).catch(error => {
			alert("Lỗi thêm mới bài viết!");
			console.log(error);
		});
    }

    $scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/blog/${item.idblog}`,item).then(resp => {
			var index = $scope.items.findIndex(p => p.idblog == item.idblog);
			$scope.items[index] = item;
			alert("Cập nhật bài viết thành công!");
			
		}).catch(error => {
			alert("Lỗi cập nhật bài viết!");
			console.log(error);
		});
    }

    $scope.delete = function(item){
		
		$http.delete(`/rest/blog/${item.idblog}`).then(resp => {
			var index = $scope.items.findIndex(p => p.idblog == item.idblog);
			$scope.items.splice(index, 1);
			$scope.reset();
			alert("Xóa bài viết thành công!");
			
		}).catch(error => {
			alert("Xóa bài viết thất bại!");
			console.log(error);
		});
    }
    
    $scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.hinhanh = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		})
	}

    
    $scope.pager = {
    	page: 0,
    	size: 5,
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
    }
});