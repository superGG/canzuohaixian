seaTable.directive("deletebtn",function(){
	return {
		restrict: "AE",

		scope:{
			delete:"&"
		},
		template:'<button class="btn btn-danger btn-xs delete" ng-click="delete()"><i class="fa fa-trash-o ficon" >&#xe824;</i> 删除</button>'
	}
}).directive("eidtbtn",function(){
	return {
		restrict:"AE",
		scope:{
			eidtone:"&"
		},
		template:'<button href="#" class="btn btn-info btn-xs edit" ng-click="eidtone()"><i class="fa fa-edit ficon">&#xe820;</i> 编辑</butto>'
	}
});

UsersListModule.directive('onFinishRenderFilters', function($timeout,$location){
	// Runs during compile
	return {
		restrict: 'A', // E = Element, A = Attribute, C = Class, M = Comment
		
		link: function($scope, iElm, iAttrs, controller) {
			if($scope.$last === true){            //当队列执行到最后一个的时候
				$timeout(function(){				//延迟执行这个函数
					if($location.path() === "/categorycompent"){
						InitiateGCCDataTable.init();
					}else if($location.path() === "/users"){
						InitiateSimpleDataTable.init();
					}else if($location.path() === "/categoryleaf"){
						InitiateGCLDataTable.init();
					}else if($location.path() === "/farmer"){
						InitiateSimpleDataTable.init();
					}else if($location.path() === "/fishman"){
						InitiateSimpleDataTable.init();
					}
				});
			}
		}
	};
}).directive('userdatabox',function(){

	scope:{}
	return {
		restrict: 'E',
		templateUrl: 'tpls/dataBox.html',                 
		replace: true,

		// controller: function($scope){
		// 	$scope.
		// },

		link: function($scope,$element,$attr){

			console.log($attr.role === "fishman");

			if($attr.role === "user"){
				$scope.databox = {
					number: '2600',
					info:'总用户数'
				}
			}else if($attr.role === "fishman"){
				$scope.databox = {
					number: '90',
					info:'当前渔户数量'
				}
			}else if($attr.role === "farmer"){
				$scope.databox = {
					number: '10',
					info:'当前养殖户的数量'
				}
			}
		}
	}
});

// GoodsCategoryCompentModule.directive('onFinishRenderFilters', function($timeout){
// 	// Runs during compile
// 	return {
// 		restrict: 'A', // E = Element, A = Attribute, C = Class, M = Comment
		
// 		link: function($scope, iElm, iAttrs, controller) {

// 			if($scope.$last === true){            //当队列执行到最后一个的时候
// 				$timeout(function(){				//延迟执行这个函数
// 					console.log("ninico");
//     				InitiateExpandableDataTable.init();
// 					$scope.$emit('ngRepeatFinished');       //注册一个叫做ngRepeatFinished的事件
// 				});
// 			}
// 		}
// 	};
// });

GoodsCategoryLeafModule.directive('skumodule',function(){
	
	// scope:{}
	return {

		restrict: 'E',
		templateUrl: 'tpls/goodscategoryleaf/editcategoryleaf-skulist.html',                 
		replace: true,

		link: function($scope,$element,$attr){

			$scope.leafskus = eval("(" + $attr.leaf + ")").skulist;

			$scope.unitType = 1;
			

			if($scope.editleafName == "斤"){

				$scope.otherModule = ["最小","较小","中等","较大","最大"];
			}else if($scope.editleafName == "只"){


				$scope.otherModule = ["较小","中等","较大"];
			}

		},

		controller: function(){
			$("#unitType").bind("change",function(){

				console.log($("#jin"));
				if($(this).val() == 1){
					$("#jin").show();
					$("#zhi").hide();
				}else if($(this).val() == 2){
					$("#jin").hide();
					$("#zhi").show();
				}
			})
		}

	}
});




OrdersModule.directive("pagination",function(){
	
	return {
		restrict: 'E',
		scope:{
			arr:'@'
		},
		templateUrl: 'tpls/pagination.html',                 
		replace: true,

		// controller: function($scope){
		// 	$scope.
		// },

		link: function($scope,$element,$attr){


		}
	}
});