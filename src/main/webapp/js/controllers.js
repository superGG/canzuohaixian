





UsersListModule.controller('UsersCtrl',function($scope,$http){

//    $http.get('test/usersinfo.json').
    $http.get('/fishshop/user_findAllUser.action').
    	success(function(data){

    		$scope.usersInfo = data.resultParm.userList;
    		$scope.databox.number = data.resultParm.number;
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

	$scope.doDelete = function(idKey,id,url,callback){

		$http.post(url,
			idKey + "=" + id,
			{
				headers:{
					"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
				}
			}).success(function(data){
				callback();
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

		fd.append("categoryId",$scope.editCompent.categoryId);
		fd.append("categorySimpleName",$scope.editCompent.categorySimpleName);

		$http(Ninico.getFormDataRequestConfig("/fishshop/category_updateCategory.action",fd)).success(function(data){

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

//			$http.get('test/goodscategoryleafinfo.json').success(function(data){
		$http.get('/fishshop/category_getAllNextLevelCategory.action').success(function(data){

			$scope.gclsInfo = data.resultParm.categoryList;
//				$scope.gclsInfo = data.result;
		});

		$http.get('/fishshop/category_getTopCategory.action').success(function(data){

			$scope.gccsInfo = data.resultParm.categoryList;
		});
	};



	$scope.unitType = "1";

	$scope.toEdit = function(gclInfo){
		$scope.editLeaf = gclInfo;
		$scope.editLeaf.unit = $scope.editLeaf.unitName;

		if($scope.editLeaf.unit === "斤"){

			$scope.editLeaf.skulista = $scope.editLeaf.skulist;
			$scope.editLeaf.skulistb = [
				{skuName:"最小规格",lowscale:0,highscale:0},
				{skuName:"较小规格",lowscale:0,highscale:0},
				{skuName:"中等规格",lowscale:0,highscale:0},
				{skuName:"较大规格",lowscale:0,highscale:0},
				{skuName:"最大规格",lowscale:0,highscale:0}
			];
		}else if($scope.editLeaf.unit === "个"){

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

		if($scope.newLeaf.unit === "斤"){

			$scope.newLeaf.skuArrayList = $scope.newLeaf.skulista;
		}else if($scope.newLeaf.unit === "个"){

			$scope.newLeaf.skuArrayList = $scope.newLeaf.skulistb;
		}

		fd.append("category",angular.toJson($scope.newLeaf));

		$http(
			Ninico.getFormDataRequestConfig("/fishshop/category_addSubCategory.action",fd)).success(function(data){

		});
	};

	$scope.doEdit = function(){

		console.log($scope.editLeaf);

		var fd = Ninico.getImgShow("#leafPhoto","categoryFile.file");

		if($scope.editLeaf.unit === "斤"){

			$scope.editLeaf.skuArrayList = $scope.editLeaf.skulista;
		}else if($scope.editLeaf.unit === "个"){

			$scope.editLeaf.skuArrayList = $scope.editLeaf.skulistb;
		}

		fd.append("category",angular.toJson($scope.editLeaf));

		$http(Ninico.getFormDataRequestConfig("/fishshop/category_updateSubCategory.action",fd)).success(function(data){

		});

		history.back();

	};

	$scope.test = function(){
		console.log($scope.editcategoryleaf);
	};

	$scope.getData();


});

/**
 *
 * 养殖户管理模块控制器
 *
 */
FarmersModule.controller("FarmersCtrl",function($scope,$http,$location){

	$scope.newFarmerinfo = {};
	$scope.editFarmerinfo = {};

	$http.get("/fishshop/gettype_getFarmerGetType.action").success(function(data){

		$scope.multiGetTypes = data.resultParm.gettypelist;
	});

	//更新数据
	$scope.getData = function(){

	//$http.get('test/farmersinfo.json').success(function(data){
		$http.get('/fishshop/shop_getAllFarmersShop.action').success(function(data){

			$scope.farmersInfo = data.resultParm.shopInfo;
			//$scope.farmersInfo = data.result;
			$scope.databox.number = data.resultParm.number;
		});

	//$http.get("test/farmersapplyinfo.json").success(function(data){
		$http.get("/fishshop/user_getVerifyFarmers.action").success(function(data){
			//$scope.farmersapplyinfo = data.result;
			$scope.farmersapplyinfo = data.resultParm.userlist;
		});
	};

	//获取养殖户的申请信息

	$scope.getApplyInfo = function(userId){

		//保存用户的userId
		console.log(userId);
		$scope.userId = userId;
			$http.
				get("/fishshop/user_getFarmerByUser.action"
				//get("test/farmerapplyinfo.json"
				, {params:{'userId':userId}}).success(function(data){
				$scope.farmerapplyinfo = data.resultParm.farmer;
					//$scope.farmerapplyinfo = data.result;
			}).success(function(data){
				$location.path("/farmer/applyform");
			});
	};


	//


	//新建养殖户基本信息
	$scope.doNew = function(farmerId){

		$http.post("test/",Ninico.JsonToKeyVal($scope.newFarmerinfo),{
			headers:{
				"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
			}
		}).success(function(data){

		});
	};


	//养殖户验证通过的方法
	$scope.setStatus = function(farmerId,userId){

		$scope.newFarmerinfo.farmersId = farmerId;

		var data = {
			"userId":userId,
			"farmersId": farmerId
		};

		$http.post("/fishshop/farmers_passAuthenticationFarmers.action",Ninico.JsonToKeyVal(data),{
			headers:{
				"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
			}
		}).success(function(data){

			if(data.resultInfo === "success"){
				$scope.status = true;
			}else{
				$scope.status = false;
			}
			$location.path("/farmer/applyform/success");
		});

	};

	//修改养殖户基本信息的准备方法
	$scope.toEdit = function(farmerinfo){

		$scope.editFarmerinfo = farmerinfo;
	};


	$scope.doEdit = function(){
		
		delete $scope.editFarmerinfo.createTime;
		console.log($scope.editFarmerinfo)
		$http.post("/fishshop/farmers_updateFarmers.action",Ninico.JsonToKeyVal($scope.editFarmerinfo),{
			headers:{
				"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
			}
		}).success(function(data){
			$location.path("/farmer");

		});
	};

	//得到养殖户更多信息的方法
	$scope.getFarmerMoreInfo = function(farmerId,shipId){

		$scope.isActive = [true,false,false];

		//获取养殖户基本信息
		$http.get("/fishshop/farmers_getFarmers.action", {params:{"farmersId":farmerId}}).success(function(data){
			$scope.farmerinfo = data.resultParm.farmers;
			$scope.phoneNumber = data.resultParm.phoneNumber;
			$scope.farmerapplyinfo = data.resultParm.farmers;
			console.log($scope.farmerinfo);
		});

//		//获取养殖户的验证信息
//		$http.get("test/farmerapplyinfo.json", {params:{"userId":farmerId}}).success(function(data){
//			$scope.farmerapplyinfo = data.result;
//		});

		 //获取养殖的商店信息
		$http.get("/fishshop/shop_getShop.action", {params:{"shopId":shipId}}).success(function(data){
			$scope.shopinfo = data.resultParm.shop;
		});



		$scope.activeshow = function(j){

			for(var i = 0; i < $scope.isActive.length ; i ++){
				if(i === j){
					$scope.isActive[i] = true;
				}else{
					$scope.isActive[i] = false;
				}

			}
		}

		$location.path("farmer/farmerMoreinfo")


	};

	$scope.getData();
});


FishmanModule.controller("FishmanCtrl",function($scope,$http,$location){


	//获取数据更新
	$scope.getData = function(){

		$http.get(
			//'/fishshop/shop_getAllFishmanShop.action'
			'test/fishmaninfo.json'
		).success(function(data){

			//$scope.databox.number = data.resultParm.number;
				//$scope.fishmansInfo = data.resultParm.shopInfo;
				$scope.fishmansInfo = data.result;
			});

		$http.get(
			//"/fishshop/user_getVerifyFishman.action"
			"test/fishmansapplyinfo.json"
		).success(function(data){

				$scope.fishmansapplyinfo = data.result;
			//$scope.fishmanapplyinfo = data.resultParm.userlist;
		});
	};


	//获取渔户的申请信息
	$scope.getApplyInfo = function(userId){

		$scope.userId = userId;

		$http.get(
			"test/fishmanapplyinfo.json"
		//"/fishshop/fishman_getFishmanByUser.action"
			,{
			params:{"userId":userId}
		}).success(function(data){
			$scope.fishmanapplyinfo = data.result;
				//$scope.fishmanapplyinfo = data.resultParm.fishman;

			$location.path("fishman/applyform");
		})
	};

	$scope.setStatus = function(fishmanId,userId){

		$scope.status = false;

		console.log($scope.userId);
		console.log(userId);


		$scope.getStatus = function(){
			return $scope.status;
		};

		var params = {
			"fishmanId":fishmanId,
			"userId":userId
		};

		$http.post("//fishshop/farmers_passAuthenticationFishman.action",Ninico.JsonToKeyVal(params),{
			headers:{
				"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
			}
		}).success(function(data){

			if(data.result === "success"){
				$scope.status = true;
			}else{
				$scope.status = false;
			}

		});

		$location.path("fishman/applyform/success");

	};

	$scope.getData();




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

		$http.post("/fishshop/shipport_addShipPort.action",
			Ninico.JsonToKeyVal($scope.newShipport)
			,{
			headers:{
				"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
			}
		});
	};

	$scope.getData = function(){

//		$http.get("test/shipportinfo.json").success(function(data){
		$http.get("fishshop/shipport_findAllShipPort.action").success(function(data){

			$scope.shipportsInfo = data.resultParm.shipportList;
		});

		$http.get("test/provinceListInfo.json").success(function(data){

			$scope.provincesInfo = data.result;
		});
	};

	$scope.toEdit = function(shipport){

		console.log(shipport);
		$scope.editShipport = shipport;
	};

	$scope.doEdit = function(){

		$http.post("test/shipportinfo.json", Ninico.JsonToKeyVal($scope.editShipport),{
			headers:{
				"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
			}
		}).success(function(data){
			console.log(data);
		});
	};

	$scope.getData();
});


LogisticsModule.controller("LogisticsCtrl",function($scope,$http,$timeout){

	$scope.newLogistic = {};



	$scope.getData = function(){
		$http.get("/fishshop/postage_findAllPostage.action").success(function(data){

			$scope.logisticsInfo = data.resultParm.postageList;
		});

		$http.get("test/provinceListInfo.json").success(function(data){
			$scope.provincesInfo = data.result;
		});
	};


	$scope.doNew = function(){


		$http.post("/fishshop/postage_addPostage.action",
			Ninico.JsonToKeyVal($scope.newLogistic),
			{
				headers:{
					"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
				}
			}).success(function(data){

			});
	};



	$scope.getProvinceList = function(id){


		$http.post("test/provinceListInfo.json",
			"postageId="+id,{
				headers:{
					"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
				}
			}).success(function(data){

				$scope.destinationsList = data.result;
			});
	};



	$scope.toEdit = function(logisticsInfo){

		$scope.editLogistic = logisticsInfo;
	};


	$scope.doEdit = function(){
		
		delete $scope.editLogistic.createTime;

		$http.post("/fishshop/postage_updatePostage.action",
			Ninico.JsonToKeyVal($scope.editLogistic),
			{
				headers:{
					"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
				}
			}).success(function(data){

		});
	};



	$scope.getData();
});