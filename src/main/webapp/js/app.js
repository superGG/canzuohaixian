/**
* seaTable Module
*
* Description
*/
var seaTable = angular.module('seaTable', ['ui.router','UsersListModule','GoodsCategoryCompentModule',
	'GoodsCategoryLeafModule','FarmersModule','FishmanModule',"FishmanApplyModule","OrdersModule",
	"ShipportModule","LogisticsModule"]).
run(function($rootScope,$state,$stateParams,$location){
	$rootScope.$state = $state;
	$rootScope.$stateParams = $stateParams;

}).
config(function($stateProvider,$urlRouterProvider) {
	
	$urlRouterProvider.otherwise('/users');


	$stateProvider.state("users",{
		url:"/users",
		templateUrl: "tpls/users.html"
	}).state("categorycompent",{
		url:"/categorycompent",
		templateUrl: "tpls/goodscategorycompent/goodscategorycompent.html"
	}).state("categorycompent.newcompent",{
		url:"/newcompent",
		templateUrl: "tpls/goodscategorycompent/newcompent.html"
	}).state("categorycompent.editcompent",{
		url:"/editcompent",
		templateUrl: "tpls/goodscategorycompent/editcategorycompent.html"
	}).state("categoryleaf",{
		url:"/categoryleaf",
		templateUrl: "tpls/goodscategoryleaf/goodscategoryleaf.html"
	}).state("categoryleaf.newleaf",{
		url:"/newleaf",
		templateUrl: "tpls/goodscategoryleaf/newleaf.html"
	}).state("categoryleaf.editleaf",{
		url:"/editleaf",
		templateUrl: "tpls/goodscategoryleaf/editcategoryleaf.html"
	}).state("farmer",{
		url:"/farmer",
		templateUrl:"tpls/farmer/farmerstable.html"
	}).state("farmer.editFishmaninfo",{
		url:"/editFarmerinfo/{farmerId}",
		templateUrl:"tpls/farmer/farmereidt.html",
		controller:function($scope,$stateParams,$http){


			$http.get("test/farmerbaicinfo.json", {params:{id:$stateParams.farmerId}}).success(function(data){
				$scope.farmerinfo = data.result;
			})
		}
	}).state("farmer.applyform",{
		url:"/applyform/{farmerId}",
		templateUrl:"tpls/farmer/farmers.applyform.html",
		controller:function($scope,$stateParams,$http){
			// console.log($stateParams.fishmanId);
			$http.get("test/farmerapplyinfo.json", {params:{id:$stateParams.farmerId}}).success(function(data){
				$scope.farmerapplyinfo = data.result;
			})
		}
	}).state("farmer.applyform.success",{
		url:"/success/{farmerId}",
		templateUrl:"tpls/farmer/farmer.applyform.success.html",
		controller:function($scope,$stateParams,$http){

			$scope.status = false;


			$scope.getStatus = function(){
				return $scope.status;
			}

			$http.get("test/farmerapplyinfosuccess.json",{params:{id:$stateParams.farmerId}}).success(function(data){
				
				if(data.result === "success"){
					$scope.status = true;
				}else{
					$scope.status = false;
				}

			})
		}
	}).state("farmer.applyform.success.infoform",{
		url:"/infoform/{farmerId}",
		templateUrl:"tpls/farmer/farmerinfoform.html"
	}).state("farmer.farmerMoreinfo",{
		url:"/farmerMoreinfo/{farmerId}",
		templateUrl:"tpls/farmer/farmerMoreinfo.html",
		controller:function($scope,$stateParams,$http){

			$scope.isActive = [true,false,false];

			$http.get("test/farmerbaicinfo.json", {params:{id:$stateParams.farmerId}}).success(function(data){
				$scope.farmerinfo = data.result;
			})

			$scope.activeshow = function(j){

				for(var i = 0; i < $scope.isActive.length ; i ++){
					if(i === j){
						$scope.isActive[i] = true;
					}else{
						$scope.isActive[i] = false;
					}

				}
			}

		}
	}).state("farmer.farmerMoreinfo.applyform",{
		url:"/applyform",
		templateUrl:"tpls/farmer/farmermoreinfo/moreinfoapply.html",
		controller:function($scope,$stateParams,$http){
			// console.log($stateParams.fishmanId);
			$http.get("test/farmerapplyinfo.json", {params:{id:$stateParams.farmerId}}).success(function(data){
				$scope.farmerapplyinfo = data.result;
			})
		}
	}).state("farmer.farmerMoreinfo.shopinfo",{
		url:"/shopinfo",
		templateUrl:"tpls/farmer/farmermoreinfo/shopinfo.html",
		controller:function($scope,$stateParams,$http){
			// console.log($stateParams.fishmanId);
			$http.get("test/farmershopinfo.json", {params:{id:$stateParams.farmerId}}).success(function(data){
				$scope.farmerinfo = data.result;
			})
		}
	}).state("fishman",{
		url:"/fishman",
		templateUrl:"tpls/fishman/fishmantable.html"
	}).state("fishman.editFishmaninfo",{
		url:"/editFishmaninfo/{fishmanId}",
		templateUrl:"tpls/fishman/fishmaneidt.html",
		controller:function($scope,$stateParams,$http){


			$http.get("test/fishmanbaicinfo.json", {params:{id:$stateParams.fishmanId}}).success(function(data){
				$scope.fishmaninfo = data.result;
			})
		}
	}).state("fishman.fishmanMoreinfo",{
		url:"/fishmanMoreinfo/{fishmanId}",
		templateUrl:"tpls/fishman/fishmanMoreinfo.html",
		controller:function($scope,$stateParams,$http){

			$scope.isActive = [true,false,false];

			$http.get("test/fishmanbaicinfo.json", {params:{id:$stateParams.fishmanId}}).success(function(data){
				$scope.fishmaninfo = data.result;
			})

			$scope.activeshow = function(j){

				for(var i = 0; i < $scope.isActive.length ; i ++){
					if(i === j){
						$scope.isActive[i] = true;
					}else{
						$scope.isActive[i] = false;
					}

				}
			}

		}
	}).state("fishman.fishmanMoreinfo.applyform",{
		url:"/applyform",
		templateUrl:"tpls/fishman/fishmanmoreinfo/moreinfoapply.html",
		controller:function($scope,$stateParams,$http){
			// console.log($stateParams.fishmanId);
			$http.get("test/fishmanapplyinfo.json", {params:{id:$stateParams.fishmanId}}).success(function(data){
				$scope.fishmanapplyinfo = data.result;
			})
		}
	}).state("fishman.fishmanMoreinfo.shopinfo",{
		url:"/shopinfo",
		templateUrl:"tpls/fishman/fishmanmoreinfo/shopinfo.html",
		controller:function($scope,$stateParams,$http){
			// console.log($stateParams.fishmanId);
			$http.get("test/fishmanshopinfo.json", {params:{id:$stateParams.fishmanId}}).success(function(data){
				$scope.fishmaninfo = data.result;
			})
		}
	}).state("fishman.applyform",{
		url:"/applyform/{fishmanId}",
		templateUrl:"tpls/fishman/fishman.applyform.html",
		controller:function($scope,$stateParams,$http){
			// console.log($stateParams.fishmanId);
			$http.get("test/fishmanapplyinfo.json", {params:{id:$stateParams.fishmanId}}).success(function(data){
				$scope.fishmanapplyinfo = data.result;
			})
		}
	}).state("fishman.applyform.success",{
		url:"/success/{fishmanId}",
		templateUrl:"tpls/fishman/fishman.applyform.success.html",
		controller:function($scope,$stateParams,$http){

			$scope.status = false;


			$scope.getStatus = function(){
				return $scope.status;
			}

			$http.get("test/fishmanapplyinfosuccess.json",{params:{id:$stateParams.fishmanId}}).success(function(data){
				
				if(data.result === "success"){
					$scope.status = true;
				}else{
					$scope.status = false;
				}

			})
		}
	}).state("fishman.applyform.success.infoform",{
		url:"/infoform/{fishmanId}",
		templateUrl:"tpls/fishman/fishmaninfoform.html"})
	.state("orders",{
		url:"/orders",
		templateUrl:"tpls/orders.html"
	}).state("shipport",{
		url:"/shipport",
		templateUrl:"tpls/shipport/shipporttable.html"
	}).state("shipport.editShipport",{
		url:"/editShipport",
		templateUrl:"tpls/shipport/editShipport.html"
	}).state("shipport.newShipport",{
			url:"/newShipport",
			templateUrl:"tpls/shipport/newShipport.html"
	}).state("logistics",{
			url:"/logistics",
			templateUrl:"tpls/logistics/logisticsTable.html"
	}).state("logistics.newlogistics",{
			url:"/newlogistics",
			templateUrl:"tpls/logistics/newLogistics.html"
	}).state("logistics.editlogistics",{
			url:"/editlogistics",
			templateUrl:"tpls/logistics/editLogistics.html"
		});
});


seaTable.filter("shopstatus",function(){
	return function(inputArray){
		
		var status = '';

		if(inputArray === '0'){
			status = "正常";
		}else if(inputArray === '1'){
			status = "失败";
		}else if(inputArray === '2'){
			status = "等待审核";
		}else if(inputArray === '3'){
			status = "已被拉黑";
		}

		return status;
	}


});



seaTable.filter("decorateDestination",function(){
	return function(inputArray,$last){

		var str = "";

		if($last){
			str = inputArray;
		}else {
			str = inputArray + ",";
		}


		return str;
	}
});

/**
* UsersListModule Module
*
* 这里为用户管理列表的控制器
*/
var UsersListModule = angular.module('UsersListModule', []);

 /**
* GoodsCategoryCompentModule Module
*
* Description
*/
var GoodsCategoryCompentModule = angular.module('GoodsCategoryCompentModule', []);


/**
* GoodsCategoryLeafModule Module
*
* Description
*/
var GoodsCategoryLeafModule = angular.module('GoodsCategoryLeafModule', []);


/**
* farmers Module
*
* Description
*/
var FarmersModule = angular.module('FarmersModule', []);


 /**
* FishmanModule Module
*
* Description
*/
var FishmanModule  =angular.module('FishmanModule', []);


/**
* FishmanApplyModule Module
*
* Description
*/
var FishmanApplyModule = angular.module('FishmanApplyModule', []);


/**
* OrdersModule Module
*
* Description
*/
var OrdersModule = angular.module('OrdersModule', []);


var ShipportModule = angular.module("ShipportModule",[]);


var LogisticsModule = angular.module("LogisticsModule",[]);