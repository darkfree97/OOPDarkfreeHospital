
var app = angular.module("OOPDarkfreeHospital", []);

app.controller("ExaminationCtrl", function($scope, $http){
    $scope.greetings = [];
    $http.get('/examinations').then(function (response){
        $scope.greetings=response.data;
    });
});
app.controller("PatientCtrl", function($scope, $http){
    $scope.greetings = [];
    $http.get('/patients').then(function (response){
        $scope.greetings=response.data;
    });
});
app.controller("DoctorCtrl", function($scope, $http){
    $scope.greetings = [];
    $http.get('/doctors').then(function (response){
        $scope.greetings=response.data;
    });
});
app.controller("DiagnosisCtrl", function($scope, $http){
    $scope.greetings = [];
    $http.get('/diagnosis').then(function (response){
        $scope.greetings=response.data;
        console.log($scope);
    });
});
app.controller("MedLabCtrl", function($scope, $http){
    $scope.greetings = [];
    $http.get('/medLabs').then(function (response){
        $scope.greetings=response.data;
    });
});
