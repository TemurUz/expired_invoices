package temur.uz.product.service.product;

import temur.uz.product.entity.Detail;
import temur.uz.product.entity.Product;
import temur.uz.product.payload.DetailDto;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Object getDetailsProduct(Integer product_id);

}
