package com.trainning.menu.service;

import java.util.List;


import com.trainning.menu.models.Catgeory;
import com.trainning.menu.models.CreateCategoryRequest;



public interface CategoryService {
	
	Catgeory createNewCategory(CreateCategoryRequest createCategoryRequest);
	
    List<Catgeory> listAllCategories();
	
}
