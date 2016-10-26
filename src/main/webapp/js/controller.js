var app = angular.module('routerApp', []);
app.controller('chapterForm', function($scope, $http) {
    $http({
        data:{'id':3},
        url:'/novel/queryChapterContent',
        method:'POST',
        headers: {'Content-Type': 'application/json'}
    }).success(function(data){
        $scope.title = data.result.data.title;
        $scope.content = data.result.data.content;
    }).error(function(){
        alert("回掉！错了");
    });
});
app.controller('chapterList', function($scope, $http) {
    $http({
        data:{'novelId':1},
        url:'/novel/queryChapterList',
        method:'POST',
        headers: {'Content-Type': 'application/json'}
    }).success(function(data){
        $scope.chapterlist = data.result.data;
//            $scope.detail = function(id){
//                alert(id)
//            };
    }).error(function(){
        alert("回掉！错了");
    });
});
app.controller('saveChapter', function($scope, $http) {
    $scope.requestData = {'novelId':1,'title':$scope.title,'content':$scope.content,'authorId':1};
    $scope.save = function(){
        $http({
            data:{'novelId':1,'title':$scope.title,'content':$scope.content,'authorId':1},
            url:'/novel/saveOrupdateChapter',
            method:'POST',
            headers: {'Content-Type': 'application/json'}
        }).success(function(data){
            if(data.meta.errno == 0){
                alert("添加成功");
            }else{
                alert("添加失败");
            }
        }).error(function(){
            alert("回掉！错了");
        });
    }
});

app.controller('bookList', function($scope, $http) {
    //$scope.requestData = {'novelId':1,'title':$scope.title,'content':$scope.content,'authorId':1};
    $scope.save = function(){
        $http({
            //data:{'novelId':1,'title':$scope.title,'content':$scope.content,'authorId':1},
            url:'/novel/queryNovelList',
            method:'POST',
            headers: {'Content-Type': 'application/json'}
        }).success(function(data){
            $scope.novelList = data.result.data;
            $scope.noveldetail = function(){
              //todo
            };
        }).error(function(){
            alert("回掉！错了");
        });
    }
});

app.controller('bookDetail', function($scope, $http) {
    //$scope.requestData = {'novelId':1,'title':$scope.title,'content':$scope.content,'authorId':1};
    $scope.save = function(){
        $http({
            data:{'id':id},
            url:'/novel/queryNovelDetail',
            method:'POST',
            headers: {'Content-Type': 'application/json'}
        }).success(function(data){
            $scope.name = data.result.data.name;
            $scope.intro = data.result.data.intro;
            $scope.authorId = data.result.data.authorId;
            $scope.id = data.result.data.id;
        }).error(function(){
            alert("回掉！错了");
        });
    }
});
