





UsersListModule.controller('UsersCtrl',function($scope,$http){

    $http.get('test/usersinfo.json').
    	success(function(data){

    		$scope.usersInfo = data.result;
    	});

    // $scope.$on('ngRepeatFinished', function(ngRepeatFinishedEvent){

    // 	InitiateSimpleDataTable.init();
    // });
});

seaTable.controller('seaTableCtrl',function($rootScope,$scope,$location){
	$scope.tableTitle = "欢迎使用";

	$scope.$on('$stateChangeSuccess', function(){

		if($location.path() === "/categorycompent"){
			$scope.tableTitle = "商品分类管理-商品父分类管理";
		}else if($location.path() === "/users"){
			$scope.tableTitle = "用户信息管理表";
		}else if($location.path() === "/categoryleaf"){
			$scope.tableTitle = "商品分类管理-商品子分类管理";
		}else if($location.path() === "/farmer"){
			$scope.tableTitle = "商铺管理-养殖户管理";
		}else if($location.path() === "/fishman"){
			$scope.tableTitle = "商铺管理-渔户管理";
		}
	});

})


GoodsCategoryCompentModule.controller("GCCCtrl",function($scope,$http){

	$http.get('http://192.168.1.107:8080/fishshop/category_getTopCategory.action')
	// $http.get('http://www.earltech.cn:8080/fishshop/category_getTopCategory.action')
	.success(function(data){

		$scope.gccsInfo = data.resultParm.categoryList;
	})

	$scope.forCompentId = function(id){

		if(id>7){
			return true;
		}else{
			return false;
		}
	}

	$scope.editcategorycompent = {};

	$scope.editOne = function(id){

		for(var i = 0; i < $scope.gccsInfo.length ; i++){

			if($scope.gccsInfo[i].categoryId == id){

				$scope.editcategorycompent = $scope.gccsInfo[i];

				return;
			}
		}
	}

});

GoodsCategoryLeafModule.controller("GCLCtrl",function($scope,$http){

	$http.get('test/goodscategoryleafinfo.json').success(function(data){

		$scope.gclsInfo = data.result;
	})

	$http.get('test/goodscategorycompentinfo.json').success(function(data){

		$scope.gccsInfo = data.result;
	})

	$scope.unitType = "1";

	$scope.editOne = function(id){


		for(var i = 0; i < $scope.gclsInfo.length ; i++){
			if($scope.gclsInfo[i].categoryId == id){

				$scope.editcategoryleaf = $scope.gclsInfo[i];

				if($scope.editcategoryleaf.unitName == "斤"){

					$scope.unitType = 1;
				}else if($scope.editcategoryleaf.unitName == "只"){

					$scope.unitType = 2;
				}

				return;
			}
		}
	}

	$scope.test = function(){
		console.log($scope.editcategoryleaf);
	}

	


});


FarmersModule.controller("FarmersCtrl",function($scope,$http){

	$http.get('test/farmersinfo.json').success(function(data){

		$scope.farmersInfo = data.result;
	});

	$http.get("test/farmersapplyinfo.json").success(function(data){

		$scope.farmersapplyinfo = data.result;
	});
});


FishmanModule.controller("FishmanCtrl",function($scope,$http){

	$http.get('test/fishmaninfo.json').success(function(data){

		$scope.fishmansInfo = data.result;
	});

	$http.get("test/fishmansapplyinfo.json").success(function(data){

		$scope.fishmansapplyinfo = data.result;
	})
});


// FishmanApplyModule.controller("FACtrl",function($scope,$http){

// 	$http.get(url, config)
// })


OrdersModule.controller("ordersCtrl",function($scope,$http){

	$scope.page = 0;
	$scope.total = 0;
	$scope.pagesArr = [];


	$scope.Math = Math;


	$scope.getdata = function(){

		$http.get('test/ordersinfo.json',{params:{page:$scope.page,start:($scope.page*15),limit:15}}).success(function(data){

			$scope.ordersInfo = data.result;

			$scope.totals = data.totals;

			if(($scope.totals/15) > 5){

				if($scope.page >= 4){
				
				$scope.pagesArr = [];

					if($scope.page >= Math.ceil($scope.totals/15)-4){

						for(var i = 0; i < 5; i++){

							$scope.pagesArr.unshift(Math.ceil($scope.totals/15)-i)
						}
					}else{

						for(var i = 0; i < 5 ; i++){

							$scope.pagesArr.push($scope.page -1 + i);
						}
					}

				}else{


					$scope.pageArr = [];
					$scope.pagesArr = [1,2,3,4,5]
				}

			}else if(($scope.totals/15) <= 5){
				
				$scope.pagesArr = [];
				for(var i = 0 ; i < ($scope.totals/15) ; i++){

					console.log($scope.page == Math.ceil($scope.totals/15)-1)
					$scope.pagesArr.push(i+1);
				}
			}

		});
	}

	$scope.getdata();

	

	$scope.update = function(e){

		$scope.page = e-1;

		$scope.getdata();
	}
})