package com.trainning.menu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainning.menu.dao.CategoryDAO;
import com.trainning.menu.dto.CategoryDTO;
import com.trainning.menu.models.Catgeory;
import com.trainning.menu.models.CreateCategoryRequest;
import com.trainning.menu.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDAO;
	
	public CategoryServiceImpl(@Autowired CategoryDAO categoryDAO) {
		this.categoryDAO =categoryDAO;
	}
	
	@Override
	public Catgeory createNewCategory(CreateCategoryRequest createCategoryRequest) {
		
		CategoryDTO categoryDTO = CategoryDTO.builder()
									.categoryId(UUID.randomUUID().toString())
									.categoryName(createCategoryRequest.getCategoryName())
									.categoryImageURL(createCategoryRequest.getCategoryImageURL()).build();
									
		categoryDAO.save(categoryDTO);
		
		return Catgeory.builder()
				.categoryId(categoryDTO.getCategoryId())
				.categoryName(categoryDTO.getCategoryName())
				.categoryImageURL(categoryDTO.getCategoryImageURL())
				.build();
	}

	@Override
	public List<Catgeory> listAllCategories() {
		
		
		List<CategoryDTO> categoryDTOList = categoryDAO.findAll();
		
		List<Catgeory> categories = new ArrayList<>();
		
		for(CategoryDTO categoryDTO : categoryDTOList ) {
			
			categories.add(Catgeory.builder()
							.categoryId(categoryDTO.getCategoryId())
							.categoryName(categoryDTO.getCategoryName())
							.categoryImageURL(categoryDTO.getCategoryImageURL())
							.build());
		}
		
		return categories;
	}

}
