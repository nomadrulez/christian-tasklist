var users = angular.module('tasks', []);
 
function mainController($scope, $http) {    
 
	var atualizar = function (){
        $http.get('/api/tasklists')
            .success(function(data) {
                $scope.tasks = data._embedded.tasklists;
                $scope.taskForm = {};
                console.log("tasks: ", data);
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    };
    atualizar();

    $scope.criar = function() {
        $http.post('/api/tasklists', $scope.taskForm)
            .success(function(data) {
                atualizar();
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    };
 
    $scope.editar = function(id) {
        $http.get('/api/tasklists/' + id)
            .success(function(data) {
                $scope.taskForm = data;
                console.log(data);
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    };

    $scope.atualizar = function() {
        $http.put('/api/tasklists/' + $scope.taskForm.key1, $scope.taskForm)
        .success( function(response){
            atualizar();
        });
    };
    
    $scope.remover = function(id) {
        $http.delete('/api/tasklists/' + id, $scope.taskForm)
        .success( function(response){
            atualizar();
        });
    };
}