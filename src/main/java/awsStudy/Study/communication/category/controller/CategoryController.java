package awsStudy.Study.communication.category.controller;

import awsStudy.Study.communication.category.service.CategoryService;
import awsStudy.Study.communication.entity.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto dto, BindingResult bindingResult) {

        Category category = Category.builder().name(dto.getName()).build();

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body((Category) bindingResult.getAllErrors());
        }


        log.info("게시판 생성 요청 {}", dto.toString());

        return ResponseEntity.ok().body(categoryService.create(category));
    }
}
