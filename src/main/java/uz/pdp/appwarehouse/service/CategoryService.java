package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    // CREAT Parent category
    public Result addParentCategory(Category category) {
        try {
            Category parentCategory = new Category(category.getName(), category.isActive());
            categoryRepository.save(parentCategory);
            return new Result("Parent category added", true);
        } catch (Exception e) {
            return new Result("ERROR!", false);
        }
    }

    // CREAT
    public Result addCategory(CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getCategoryId());
        if (optionalCategory.isPresent()) {
            Category addedCategory = new Category();
            addedCategory.setName(categoryDto.getName());
            addedCategory.setActive(categoryDto.isActive());
            addedCategory.setParentCategory(optionalCategory.get());

            categoryRepository.save(addedCategory);
            return new Result("Category added", true);
        } else return new Result("ERROR! This category not found", false);
    }

    // Get all category
    public List<Category> getAllParentCategory() {
        return categoryRepository.findAll();
    }

    // Get one category
    public Category getCategoryById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElseGet(Category::new);
    }

    // UPDATE
    public Result editCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getCategoryId());
        if (optionalCategory.isPresent()) {
            Category category = new Category();
            category.setName(categoryDto.getName());
            category.setActive(categoryDto.isActive());
            category.setParentCategory(optionalCategory.get());

            categoryRepository.save(category);
            return new Result("Category edited", true);
        }
        return new Result("ERROR", false);
    }

    // DELETE
    public Result deleteCategory(Integer id) {
        try {
            categoryRepository.deleteById(id);
            return new Result("Category deleted", true);
        } catch (Exception e) {
            return new Result("Category not found", false);
        }
    }
}
