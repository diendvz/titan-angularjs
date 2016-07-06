/**
 * Created by diendvz on 7/6/16.
 */
myapp.factory('httpServices',function ($http) {
    return {
        addCoder: function(name, age) {
            $http.post('/addCoder',{
                name:name, 
                age:age
            }).success(function (response) {
                return response.data;
            });
        },
        listCoder: function() {
            return $http.get('/listCoder').success(function (response) {
                return response.data;
            });
        },
        searchCoderByName: function (sname) {
            return $http.get('/search/' + sname).success(function (response) {
                return response.data;
            });
        }
    }
});