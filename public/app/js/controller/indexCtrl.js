/**
 * Created by diendvz on 7/6/16.
 */
myapp.controller('indexCtrl',function($scope, $http) {
    $scope.addCoder = function(){
        $http.post('/addCoder',{'name':$scope.fullName, 'age':$scope.age}).success(function (data) {
            console.log(data);
            $scope.getListCoders();
        }).error(function (data) {
            console.log(data);
        });
    };

    $scope.coders = {};

    $scope.getListCoders = function() {
        $http.get('/listCoder').success(function (data) {
            $scope.coders = data;
        });
    }
    
    $scope.rcoders = {};
    
    $scope.searchCoderByName = function () {
        $http.get('/search/' + $scope.sname).success(function (data) {
            $scope.rcoders = data;
            $scope.getListCoders();
        });
    }
});