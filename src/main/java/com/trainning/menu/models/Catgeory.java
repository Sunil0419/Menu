package com.trainning.menu.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Catgeory {
	
	private String categoryId;
	private String categoryName;
	private String categoryImageURL;
	
}
