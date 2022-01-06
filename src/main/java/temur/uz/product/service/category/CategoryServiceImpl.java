package temur.uz.product.service.category;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import temur.uz.product.entity.Category;
import temur.uz.product.entity.Detail;
import temur.uz.product.repository.CategoryRepository;
import temur.uz.product.repository.DetailRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final DetailRepository detailRepository;



    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Object> getDetails(Integer pr_id) {
        Pageable pageable = PageRequest.of(0, 5);
        List<Object> allByProductId = detailRepository.findAllByProductId(pr_id, pageable);

        if (!allByProductId.isEmpty()){
            return allByProductId;
        }
        return null;
    }
}
