package com.example.StoreProejct.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.StoreProejct.entity.Category;
import com.example.StoreProejct.repository.CategoryRepository;;

@Service
public class CategoryService {
	
private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
//	Get all the categories 
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable); 
	}
	
//	create a new category
	public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
	
//	Get category by Id
	public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
	
//	Update category by id
	public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));

        category.setCategoryName(categoryDetails.getCategoryName());
        return categoryRepository.save(category);
    }
	
//	Delete category by id
	public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
