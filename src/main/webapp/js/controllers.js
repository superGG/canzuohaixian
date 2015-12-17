





UsersListModule.controller('UsersCtrl',function($scope,$http){

//    $http.get('test/usersinfo.json').
    $http.get('/fishshop/user_findAllUser.action').
    	success(function(data){

    		$scope.usersInfo = data.resultParm.userList;
    	});

    // $scope.$on('ngRepeatFinished', function(ngRepeatFinishedEvent){

    // 	InitiateSimpleDataTable.init();
    // });
});

seaTable.controller('seaTableCtrl',function($rootScope,$scope,$location,$http){
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

	$scope.doDelete = function(id,url,callback){

		$http.get(url,{
			params:{"id":id}
		}).success(function(data){
			console.log(data);
		});
	}

});

/**
 *
 * 商品父分类管理模块的controller方法
 *
 *
 */

GoodsCategoryCompentModule.controller("GCCCtrl",function($scope,$http){
	
	$scope.newCompent = {};
	$scope.editCompent = {};

	/**
	 * 数据更新函数
	 */
	$scope.getData = function(){

		$http.get('/fishshop/category_getTopCategory.action')
			//$http.get('test/goodscategorycompentinfo.json')
			.success(function(data){

				$scope.gccsInfo = data.resultParm.categoryList;
				//$scope.gccsInfo = data.result;

//		$scope.skuArrayList = data.resultParm.categoryList.skuArrayList;
			})
	};

	$scope.forCompentId = function(id){

		if(id>7){
			return true;
		}else{
			return false;
		}
	};

	$scope.toEdit = function(gccinfo){

		$scope.editCompent = gccinfo;
	};

	$scope.doEdit = function (){

		var fd = Ninico.getImgShow("#compentPhoto","categoryFile.file");

		fd.append("categorySimpleName",$scope.editCompent.categorySimpleName);
		fd.append("categoryId",$scope.editCompent.categoryId);

		$http(Ninico.getFormDataRequestConfig("/fishshop/category_addCategory.action",fd)).success(function(data){

		});

	};

	$scope.doNew = function(){

		var fd = Ninico.getImgShow("#compentPhoto","categoryFile.file");

		fd.append("categorySimpleName",$scope.newCompent.categorySimpleName);

		$http(Ninico.getFormDataRequestConfig("/fishshop/category_addCategory.action",fd)).success(function(data){

		});
	};

	//初始化数据
	$scope.getData();


});


/**
 *
 *   商品子分类管理模块的controller方法
 *
 *
 */
GoodsCategoryLeafModule.controller("GCLCtrl",function($scope,$http){


	/**
	 * 新建商品子分类页面所用到的变量
	 * @type {{}}
	 */

	$scope.newLeaf = {};
	//按斤计算的商品规格
	$scope.newLeaf.skulista = [
		{skuName:"较小规格",lowscale:0,highscale:0},
		{skuName:"中等规格",lowscale:0,highscale:0},
		{skuName:"较大规格",lowscale:0,highscale:0}
	];
	//按个计算的商品规格
	$scope.newLeaf.skulistb = [
		{skuName:"最小规格",lowscale:0,highscale:0},
		{skuName:"较小规格",lowscale:0,highscale:0},
		{skuName:"中等规格",lowscale:0,highscale:0},
		{skuName:"较大规格",lowscale:0,highscale:0},
		{skuName:"最大规格",lowscale:0,highscale:0}
	];

	/**
	 * 修改商品子分类页面所用到的变量
	 *
	 */

	$scope.editLeaf = {};





	/**
	 * 获取数据的函数
	 */
	$scope.getData = function(){

			$http.get('test/goodscategoryleafinfo.json').success(function(data){
		//$http.get('/fishshop/category_getAllNextLevelCategory.action').success(function(data){

			//$scope.gclsInfo = data.resultParm.categoryList;
				$scope.gclsInfo = data.result;
		});

		$http.get('/fishshop/category_getTopCategory.action').success(function(data){

			$scope.gccsInfo = data.resultParm.categoryList;
		});
	};



	$scope.unitType = "1";

	$scope.toEdit = function(gclInfo){
		$scope.editLeaf = gclInfo;

		if($scope.editLeaf.unit === "斤"){

			$scope.editLeaf.unitType = 1;
			$scope.editLeaf.skulista = $scope.editLeaf.skulist;
			$scope.editLeaf.skulistb = [
				{skuName:"最小规格",lowscale:0,highscale:0},
				{skuName:"较小规格",lowscale:0,highscale:0},
				{skuName:"中等规格",lowscale:0,highscale:0},
				{skuName:"较大规格",lowscale:0,highscale:0},
				{skuName:"最大规格",lowscale:0,highscale:0}
			];
		}else if($scope.editLeaf.unit === "个"){

			$scope.editLeaf.unitType = 2;
			$scope.editLeaf.skulistb = $scope.editLeaf.skulist;
			$scope.editLeaf.skulista =  [
				{skuName:"较小规格",lowscale:0,highscale:0},
				{skuName:"中等规格",lowscale:0,highscale:0},
				{skuName:"较大规格",lowscale:0,highscale:0}
			];
		}
	};

	$scope.doNew = function(){

		console.log($scope.newLeaf);

		var fd = Ninico.getImgShow("#leafPhoto","categoryFile.file");

		if($scope.newLeaf.unit = "斤"){

			$scope.newLeaf.skuArrayList = $scope.newLeaf.skulista;
		}else if($scope.newLeaf.unit = "个"){

			$scope.newLeaf.skuArrayList = $scope.newLeaf.skulistb;
		}

		fd.append("category",angular.toJson($scope.newLeaf));

		//fd.append("categoryAcademicName",$scope.newLeaf.categoryAcademicName);
		//fd.append("categoryEnglishName",$scope.newLeaf.categoryEnglishName);
		//fd.append("parentId",$scope.newLeaf.parentId);
		//fd.append("unit",$scope.newLeaf.unit);
        //
		//fd.append("skuArrayList",$scope.editLeaf.skulista);

		////{"skuName":"最大规格","lowscale":"0.1","highscale":"0.3"}
		//fd.append("skuArrayList.lowscale",$scope.editLeaf.skulista[0].lowscale);
		//fd.append("skuArrayList.highscale",$scope.editLeaf.skulista[0].highscale);

		$http(
			Ninico.getFormDataRequestConfig("/fishshop/category_addSubCategory.action",fd)).success(function(data){

		});
	};

	$scope.doEdit = function(){

		console.log($scope.editLeaf);

		var fd = Ninico.getImgShow("#leafPhoto","categoryFile.file");

		fd.append("categorySimpleName",$scope.editLeaf.categorySimpleName);
		fd.append("categoryAcademicName",$scope.editLeaf.categoryAcademicName);
		fd.append("categoryEnglishName",$scope.editLeaf.categoryEnglishName);
		fd.append("parentId",$scope.editLeaf.parentId);
		fd.append("categoryId",$scope.editLeaf.categoryId);
		fd.append("unit",$scope.editLeaf.unit);
		fd.append("skuArrayList.skuName",$scope.editLeaf.skulista[0].skuName);

		//{"skuName":"最大规格","lowscale":"0.1","highscale":"0.3"}
		fd.append("skuArrayList.lowscale",$scope.editLeaf.skulista[0].lowscale);
		fd.append("skuArrayList.highscale",$scope.editLeaf.skulista[0].highscale);

		$http(Ninico.getFormDataRequestConfig("/fishshop/category_addCategory.action",fd)).success(function(data){

		});

		history.back();

	}

	$scope.test = function(){
		console.log($scope.editcategoryleaf);
	}

	$scope.getData();


});


FarmersModule.controller("FarmersCtrl",function($scope,$http){

//	$http.get('test/farmersinfo.json').success(function(data){
	$http.get('/fishshop/shop_getAllFarmersShop.action').success(function(data){

		$scope.farmersInfo = data.resultParm.shopInfo;
	});

	$http.get("test/farmersapplyinfo.json").success(function(data){
//		$http.get("/fishshop/user_getVerifyFishman.action").success(function(data){
		
		$scope.farmersapplyinfo = data.result;//.userList
	});
});


FishmanModule.controller("FishmanCtrl",function($scope,$http){

	$http.get('/fishshop/shop_getAllFishmanShop.action').success(function(data){

		$scope.fishmansInfo = data.resultParm.shopInfo;
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

//		$http.get('test/ordersinfo.json',{params:{page:$scope.page,start:($scope.page*15),limit:15}}).success(function(data){
		$http.get('/fishshop/orders_findAllOrders.action',{params:{"pageInfo.indexPageNum":$scope.page+1,start:($scope.page*15),"pageInfo.size":15}}).success(function(data){

			$scope.ordersInfo = data.resultParm.ordersList;

			$scope.totals = data.resultParm.total;

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
});


ShipportModule.controller("ShipportCtrl",function($scope,$http){

	$scope.newShipport = {};

	$scope.doNew = function(){

		console.log($scope.newShipport);

		$http.get("test/shipportinfo.json",{
			params:$scope.newShipport
		})
	}

	$scope.getData = function(){

		$http.get("test/shipportinfo.json").success(function(data){

			$scope.shipportsInfo = data.results;
		})
	};

	$scope.toEdit = function(shipport){

		console.log(shipport);
		$scope.editShipport = shipport;
	};

	$scope.doEdit = function(){

		$http.get("test/shipportinfo.json",{
			params:$scope.editShipport
		}).success(function(data){
			console.log(data);
		});
	};

	$scope.getData();
});


LogisticsModule.controller("LogisticsCtrl",function($scope,$http,$timeout){

	$scope.newLogistic = {};

	$http.get("test/provinceListInfo.json").success(function(data){
		$scope.provincesInfo = data.result;
	});

	$scope.getData = function(){
		$http.get("test/logisticsInfo.json").success(function(data){

			$scope.logisticsInfo = data.result;
		});
	};

	$scope.doNew = function(){

		$scope.newLogistic.destination = $('[name="duallistbox_demo1"]').val();

		$http.get("test/logisticsInfo.json",{
			params:$scope.newLogistic
		});
	};

	$scope.editInit = function(provinceName,editName,$index,$last){
		console.log($last);

		

		$scope.hasSelect(provinceName,editName,$index);
		

		if($last){
			$timeout(function(){
				$(function () {
					var demo2 = $('.demo1').bootstrapDualListbox({
						nonSelectedListLabel: '所有省份',
						selectedListLabel: '送达的省份',
						preserveSelectionOnMove: 'moved',
						moveOnSelect: false
					});

					$("#showValue").click(function () {
						alert($('[name="duallistbox_demo1"]').val());
					});
				});
			})
		}


	};
	
	$scope.newInit = function($last){
		
		if($last){
			$timeout(function(){
				$(function () {
					var demo2 = $('.demo1').bootstrapDualListbox({
						nonSelectedListLabel: '所有省份',
						selectedListLabel: '送达的省份',
						preserveSelectionOnMove: 'moved',
						moveOnSelect: false
					});

					$("#showValue").click(function () {
						alert($('[name="duallistbox_demo1"]').val());
					});
				});
			})
		}
	}


	$scope.hasSelect = function(provinceName,editName,$index){

		for(var i = 0,len = editName.length;i < len;i++){

			if(provinceName === editName[i]){

				$(".demo1 option").eq($index).attr("selected","selected");
			}
		}
	};


	$scope.toEdit = function(logisticsInfo){

		$scope.editLogistic = logisticsInfo;
	};


	$scope.doEdit = function(){

		$scope.editLogistic.destination = $('[name="duallistbox_demo1"]').val();


		$http.get("test/logisticsInfo.json",{
			params:$scope.editLogistic
		}).success(function(data){

		});
	};



	$scope.getData();
});