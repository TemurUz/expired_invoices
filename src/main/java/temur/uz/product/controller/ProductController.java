package temur.uz.product.controller;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import temur.uz.product.entity.Detail;
import temur.uz.product.entity.Product;
import temur.uz.product.service.product.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/list")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/details/{product_id}")
    public ResponseEntity<?> getDetailsProduct(@PathVariable Integer product_id){
        Object detailsProduct = productService.getDetailsProduct(product_id);
        if (detailsProduct==null){
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.status(200).body(detailsProduct);
    }


}
