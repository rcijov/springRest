function listController($scope, $http) {

    $scope.item = {};

    $http.get('http://192.168.1.110:8080/list').
      success(function(data) {
        $scope.data = data;
        $scope.itens = data;
    });

    $scope.addItem = function () {
        $http.post("http://192.168.1.110:8080/product", {description: $scope.item.description, price: $scope.item.price, imageUrl: $scope.item.imageUrl}, {headers: {'Content-Type': 'application/json'} })
        .then(function (response) {
            $scope.itens.push({id: response.data.id, description: $scope.item.description, price: $scope.item.price, imageUrl: $scope.item.imageUrl});
            toastr.success("Item added succesfully");
        });
    };

    $scope.editItem = function(index){
        $scope.item = $scope.itens[index];
        $scope.edit = true;
    };

    $scope.applyChanges = function(index){
        $http.put("http://192.168.1.110:8080/product", {id: $scope.item.id, description: $scope.item.description, price: $scope.item.price, imageUrl: $scope.item.imageUrl}, {headers: {'Content-Type': 'application/json'} })
        .then(function (response) {
            $scope.item = {};
            $scope.edit = false;
            toastr.success("Item modified with sucesso.");
        });
    };

    $scope.deleteItem = function(index){
        $http.delete("http://192.168.1.110:8080/product/"+$scope.itens[index].id, {}, {headers: {'Content-Type': 'application/json'} })
        .then(function (response) {
            $scope.itens.splice(index, 1);
            toastr.success("Item removed with sucesso.");
        });
    };
}