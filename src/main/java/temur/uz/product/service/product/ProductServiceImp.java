package temur.uz.product.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import temur.uz.product.entity.Product;
import temur.uz.product.payload.DetailDto;
import temur.uz.product.repository.DetailRepository;
import temur.uz.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final DetailRepository detailRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Object getDetailsProduct(Integer product_id) {
        Pageable pageable = PageRequest.of(0, 10);
        List<Object> allByProductId = detailRepository.findAllByProductId(product_id, pageable);
        if (allByProductId.isEmpty()){
            return  null;
        }
        return allByProductId;
    }
}
