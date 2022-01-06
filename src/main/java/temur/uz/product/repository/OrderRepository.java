package temur.uz.product.repository;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import temur.uz.product.entity.Order;
import temur.uz.product.payload.OrderDetailsProductName;
import temur.uz.product.payload.OrdersWithoutInvoicesDto;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * /orders_without_details
     * 3.Orders that do not have a detail and were placed before 6 September 2016. Return all
     * attributes.
     * @return List<Order>
     */
    @Query(value = "select  o.id, o.date, o.customer_id from orders o\n" +
            "left join detail d on o.id = d.or_id\n" +
            "where o.date<='2016-09-06' and d.id is null", nativeQuery = true)
    List<Order> findAllOrderWithoutDetails(Pageable pageable);


    /**
     * /orders_without_invoices
     *10. For each order without invoice, list its ID, the date it was placed and the
     * total price of the products in its detail,talking into account the quantity
     * of each ordered product and its unit price.Orders without detail must not be
     * included in the answers.
     */
    @Query(value = "select i.id as id, i.issued as issued, p.price as price\n" +
            "from invoice i\n" +
            "         inner join orders o on o.id = i.order_id\n" +
            "         inner join detail d on o.id = d.or_id\n" +
            "         inner join product p on p.id = d.pr_id", nativeQuery = true)
    List<OrdersWithoutInvoicesDto> findAllOrdersWithoutInvoicesList();


    @Query(value = "select p.name as name,o.date as date, d.quantity as quantity\n" +
            "from orders o\n" +
            "         inner join detail d on o.id = d.or_id\n" +
            "         inner join product p on p.id = d.pr_id\n" +
            "where o.id = ?1;", nativeQuery = true)
    OrderDetailsProductName findByOrderId(Integer oder_id);

}
