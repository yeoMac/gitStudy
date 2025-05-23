package awsStudy.Study.communication.category.service;

import awsStudy.Study.communication.category.repository.CategoryRepository;
import awsStudy.Study.communication.entity.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public Category create(Category category) {

        return categoryRepository.save(category);
    }
}
