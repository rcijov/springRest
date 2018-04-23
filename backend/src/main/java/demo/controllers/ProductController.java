package demo.controllers;

import demo.domain.Product;
import demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import javax.validation.Valid;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listProducts(){
        return new ResponseEntity(productService.listAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity(productService.saveOrUpdateProductForm(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        productService.delete(Long.valueOf(id));
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PATCH)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity(productService.saveOrUpdateProductForm(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable String id){
        return new ResponseEntity(productService.getById(Long.valueOf(id)), HttpStatus.OK);
    }

}
