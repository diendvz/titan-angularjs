/**
 * Created by diendvz on 7/6/16.
 */
myapp.controller('indexCtrl',function($scope, httpServices) {
    $scope.addCoder = function(){
        httpServices.addCoder($scope.fullName, $scope.age);
    };

    $scope.coders = {};

    $scope.getListCoders = function() {
        httpServices.listCoder().then(function (response) {
            $scope.coders = response.data;
        });
    };
    
    $scope.rcoders = {};
    
    $scope.searchCoderByName = function () {
        httpServices.searchCoderByName($scope.sname).then(function (response) {
            $scope.rcoders = response.data;
        });
    }
});