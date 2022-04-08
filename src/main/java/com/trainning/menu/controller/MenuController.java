package com.trainning.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainning.menu.models.Catgeory;
import com.trainning.menu.models.CreateCategoryRequest;
import com.trainning.menu.service.CategoryService;

@RestController

@RequestMapping("/v1/api")
public class MenuController {
	
	private CategoryService categoryService;
	
	public MenuController(@Autowired CategoryService categoryService) {
		this.categoryService=categoryService;
	}

	//@RequestMapping(value ="/category", method =Requestmethod.POST)	
	@PostMapping("/category")
	public ResponseEntity<?> createNewCategory(@RequestHeader HttpHeaders headers, @RequestBody CreateCategoryRequest createCategoryRequest){
		
		Catgeory category = categoryService.createNewCategory(createCategoryRequest);
		
		return ResponseEntity.ok(category);
	}
	
	
	@GetMapping("/category")
	public ResponseEntity<?> listAllCategories(){
		
		List<Catgeory> categories = categoryService.listAllCategories();
		
		
		return ResponseEntity.ok(categories);
	}
	
}
