describe('Lista of products', function () {

    describe('listController', function () {
        beforeEach(function () {
            this.$scope = {};
            this.controller = new listController(this.$scope, this.$http);
        });

        it('it must have 2 items', function () {
            expect(this.$scope.itens.length).toBe(2);
        });

        describe('addItem', function () {
            it('must have the product ibm', function () {
                this.$scope.item = {};
                this.$scope.item.description = 'ibm';
                this.$scope.item.price = 5;
                this.$scope.item.imageUrl = "img url";
                this.$scope.addItem();
                expect(this.$scope.itens.length).toBe(3);
                expect(this.$scope.itens[2].description).toBe('ibm');
                expect(this.$scope.itens[2].price).toBe(5);
                expect(this.$scope.itens[2].imageUrl).toBe('img url');
            });
        });

    });

});
