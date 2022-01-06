package temur.uz.product.controller;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import temur.uz.product.entity.Category;
import temur.uz.product.entity.Detail;
import temur.uz.product.repository.DetailRepository;
import temur.uz.product.service.category.CategoryServiceImpl;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryServiceImpl categoryService;
//    private final DetailRepository detailRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<List<Object>> getCategory(@PathVariable Integer product_id){

        List<Object> byProductId = categoryService.getDetails(product_id);
        if (byProductId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(byProductId);
//        return ResponseEntity.ok(categoryService.getCategory(product_id));
    }


}
