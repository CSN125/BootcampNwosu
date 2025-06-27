package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
// add the annotations to make this a REST controller
// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests
public class CategoriesController {
    private CategoryDao categoryDao;
    private ProductDao productDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }


    // create an Autowired controller to inject the categoryDao and ProductDao

    // add the appropriate annotation for a get action
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        // This handles GET requests to /categories

        List<Category> categories = categoryDao.getAllCategories();

        if (categories == null){ //&& categories.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }


    // find and return all categories3
    //return null;


    // add the appropriate annotation for a get action
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id) {
        // Add this above your method to handle GET requests for a specific ID
        Category category = categoryDao.getById(id);
        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        // get the category byz
    //return null;
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("{categoryId}/products")
    public ResponseEntity<List<Product>> getProductsById(@PathVariable int categoryId) {
        // get a list of product by categoryId
        List<Product> products = productDao.listByCategoryId(categoryId);
        if(products == null && products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
        //return null;
    }

    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) {
        // insert the category
        boolean created = categoryDao.create(category);

        if(created){
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        }

        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public ResponseEntity<Void> updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category existing = categoryDao.getById(id);

        if(existing == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setCategoryId(id);
        boolean updated = categoryDao.update(id, category);

        if(updated){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // update the category by id
    }

    public CategoryDao getCategoryDao() { return categoryDao; }


    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        Category category = categoryDao.getById(id);

        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        boolean successfullyDeleted = categoryDao.delete(id);

        if(successfullyDeleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // delete the category by id
    }
}
