





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


GoodsCategoryCompentModule.controller("GCCCtrl",function($scope,$http){
	
	$scope.newCompent = {};
	$scope.editCompent = {};

	$http.get('/fishshop/category_getTopCategory.action')
	 //$http.get('test/goodscategorycompentinfo.json')
	.success(function(data){

		$scope.gccsInfo = data.resultParm.categoryList;
		//$scope.gccsInfo = data.result;

//		$scope.skuArrayList = data.resultParm.categoryList.skuArrayList;
	})

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


		var file = $("#compentPhoto").get(0).files[0];

		var fd = new FormData();
		fd.append("compentPhoto",file);
		fd.append("categorySimpleName",$scope.editCompent.categorySimpleName);
		fd.append("categoryId",$scope.editCompent.categoryId);

		$("#viewPhoto").attr("src",window.URL.createObjectURL(file));
		var xhr = new XMLHttpRequest();

		xhr.open("post","test/usersinfo.json");
		xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");

		xhr.upload.onprogress = function(evt){

			$scope.precentage = evt.total/evt.loaded * 100;
		}

		xhr.send(fd);

	}

	$scope.doNew = function(){
		
		var file = $("#compentPhoto").get(0).files[0];

		var fd = new FormData();
		fd.append("categoryFile.file",file);
		fd.append("categorySimpleName",$scope.newCompent.categorySimpleName);
		$("#viewPhoto").attr("src",window.URL.createObjectURL(file));
		var xhr = new XMLHttpRequest();
//		xhr.open("post","test/usersinfo.json");
		xhr.open("post","/fishshop/category_addCategory.action");
		xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");

		xhr.upload.onprogress = function(evt){

			$scope.precentage = evt.total/evt.loaded * 100;
		}

		xhr.send(fd);
	}


});

GoodsCategoryLeafModule.controller("GCLCtrl",function($scope,$http){

//	$http.get('test/goodscategoryleafinfo.json').success(function(data){
	$http.get('/fishshop/category_getAllNextLevelCategory.action').success(function(data){

		$scope.gclsInfo = data.resultParm.categoryList;
	})

	$http.get('/fishshop/category_getTopCategory.action').success(function(data){

		$scope.gccsInfo = data.resultParm.categoryList;
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