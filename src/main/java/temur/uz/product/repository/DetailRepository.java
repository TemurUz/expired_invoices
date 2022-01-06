package temur.uz.product.repository;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import temur.uz.product.entity.Detail;
import temur.uz.product.payload.DetailDto;
import temur.uz.product.payload.HighDemandProduct;

import java.util.List;
import java.util.Optional;

public interface DetailRepository extends JpaRepository<Detail, Integer> {
    /**
     * /high_demand_products
     * 7. Products that were ordered more than 10 times in total,by taking into
     * account the quantities in which they appear in thr order details.
     * Return the product code and the total number of times it was ordered
     */
    @Query(value = "select p.id as id, quantity as quantity\n" +
            "from detail d\n" +
            "         inner join product p on p.id = d.pr_id\n" +
            "where d.quantity > 10;", nativeQuery = true)
    List<HighDemandProduct> findAllHighDemandProductList();

    @Query(value = "select d.id, d.quantity, d.or_id, d.pr_id\n" +
            "from detail d\n" +
            "where d.pr_id = ?1", nativeQuery = true)
    List<Object> findAllByProductId(Integer product_id, Pageable pageable);


    Optional<DetailDto> findByIdAndProductId(Integer id, Integer product_id);

}
