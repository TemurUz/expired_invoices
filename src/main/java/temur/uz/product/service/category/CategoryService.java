package temur.uz.product.service.category;

import org.springframework.data.domain.Page;
import temur.uz.product.entity.Category;
import temur.uz.product.entity.Detail;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    List<Object> getDetails(Integer pr_id);

}
