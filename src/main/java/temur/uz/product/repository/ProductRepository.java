/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
package temur.uz.product.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import temur.uz.product.entity.Product;
import temur.uz.product.payload.BulkProductsDto;
import temur.uz.product.payload.NumberOfProductsInYearDto;
import temur.uz.product.payload.OverpaidInvoicesDto;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * /bulk_products
     * 8. Typically mass ordered products: when one of these products is ordered,
     * an average of 8 or more will be ordered.Return the product code and price
     * for each such product
     * @return List<BulkProductsDto>
     */
    @Query(value = "select p.id as id, p.price as price\n" +
            "from orders o\n" +
            "         inner join customer c on c.id = o.customer_id\n" +
            "         inner join detail d on o.id = d.or_id\n" +
            "         inner join product p on p.id = d.pr_id\n" +
            "where c.country != 'Uzbekiston' and d.quantity>8", nativeQuery = true)
    List<BulkProductsDto> findAllBulkProducts();

    /**
     * /number_of_products_year
     *Total number of orders placed in 2016 by customers of each country.
     * If all customers from a specific country did not place any orders in 2016,
     * the country will not appear in the output.
     * @return List<NumberOfProductsInYearDto>
     */
    @Query(value = "select count(c.country) as count, c.country as country\n" +
            "from customer c\n" +
            "         inner join orders o on c.id = o.customer_id\n" +
            "where o.date >= '2016-01-01'\n" +
            "  and o.date <= '2016-12-31'\n" +
            "group by c.country\n" +
            "having count(o.customer_id) > 0", nativeQuery = true)
    List<NumberOfProductsInYearDto> findAllNumberOfProductsInYearList();

}
