package temur.uz.product.repository;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import temur.uz.product.entity.Customer;
import temur.uz.product.payload.CustomerLastOrders;
import temur.uz.product.payload.CustomerWithoutOrdersDto;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * 4.
     * @return
     */
    @Query(value = "select c.name as name, c.country as country, c.address as address, c.phone as phone, o.date as date\n" +
            "from customer c\n" +
            "         join orders o on c.id = o.customer_id\n" +
            "where extract(year from date) <> '2016'", nativeQuery = true)
    List<CustomerWithoutOrdersDto> findAlOrderNotCustomerDate();

    /**
     * 5.ID and name of customers and the date of their last order. For customers who did not
     * place any orders, no rows must be returned. For each customer who placed more than
     * one order on the date of their most recent order, only one row must be returned.
     * @return
     */
    @Query(value = "SELECT c.id as id, c.name as name, (SELECT max(o.date) FROM customer c WHERE c.id = o.customer_id) as date\n" +
            "FROM customer c\n" +
            "         inner join orders o on c.id = o.customer_id\n" +
            "where o.customer_id is not null\n" +
            "group by c.id, c.name, o.customer_id", nativeQuery = true)
    List<CustomerLastOrders> getAllCustomersLastOrders();


}
