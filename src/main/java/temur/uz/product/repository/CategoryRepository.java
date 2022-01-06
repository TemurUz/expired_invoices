package temur.uz.product.repository;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import temur.uz.product.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
