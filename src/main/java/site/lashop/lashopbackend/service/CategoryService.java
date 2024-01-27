package site.lashop.lashopbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.lashop.lashopbackend.model.Category;
import site.lashop.lashopbackend.repo.CategoryRepo;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }
}
