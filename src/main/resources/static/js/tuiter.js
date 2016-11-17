var app = angular.module("tuiter", ['ngRoute']);

app.controller("TuiterController", function ($scope, $http) {

    $scope.mensagem = {mensagem:'teste'};



    $http.get("http://localhost:8080/mensagem")
        .then(function(resultado){
            $scope.mensagens = resultado.data;
        }, function(erro){
            $scope.error = erro.status;
            console.log(erro);
        })
        .then(function(){
            $scope.carregando = false;
        })

    $scope.tuitar = function(mensagem){
        $scope.carregando = true;
        $http.post("http://localhost:8080/mensagem", mensagem)
            .then(function(resultado){
                console.log(resultado.data);
                $scope.mensagens.push(resultado.data);
            }, function(erro){

            })
            .then(function(){
                $scope.carregando = false;
            })
    }

});