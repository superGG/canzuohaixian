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

OrdersModule.directive("pagination",function(){
	
	return {
		restrict: 'E',
		scope:{
			arr:'@'
		},
		templateUrl: 'tpls/pagination.html',                 
		replace: true,

		link: function($scope,$element,$attr){


		}
	}
});