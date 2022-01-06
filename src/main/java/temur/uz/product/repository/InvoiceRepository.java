package temur.uz.product.repository;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import temur.uz.product.entity.Invoice;
import temur.uz.product.payload.DueInvoiceDto;
import temur.uz.product.payload.OverpaidInvoicesDto;
import temur.uz.product.payload.WrongDateInvoiceDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    /**
     * 1. IInvoices issued after their due date. Return all attributes.
     * @param date
     * @return List<DueInvoiceDto>
     */
    @Query(value = "SELECT e.id as id, e.order_id as orderId, e.amount as amount, e.issued as issued, e.due as due\n" +
            "FROM Invoice e\n" +
            "WHERE e.due < ?1", nativeQuery = true)
    List<DueInvoiceDto> findAllValid(Date date);

    /**
     * 2. Invoices that were issued before the date in which the order they refer to was placed.
     * Return the ID of the invoice, the date it was issued, the ID of the order associated with it
     * and the date the order was placed.
     * @return List<WrongDateInvoiceDto>
     */
    @Query(value = "select i.id as id, i.issued as issued," +
            "i.order.id as orderId, i.order.date as date " +
            "from Invoice i where i.issued < i.order.date", nativeQuery = true)
    List<WrongDateInvoiceDto> findAllBeforeDue(Date date);

    /**
     * /overpaid_invoice
     *6. Invoices that have been overpaid. Observe that there may be more
     * than one payment referring to the same invoice. Return the invoice
     * number and the amount that should be reimbursed
     * @return List<OverpaidInvoicesDto>
     */
    @Query(value = "select p.inv_id_id as id, sum(p.amount)-i.amount as amount\n" +
            "from payment p\n" +
            "         inner join invoice i on p.inv_id_id = i.id\n" +
            "group by p.inv_id_id, i.amount\n" +
            "having count(p.inv_id_id) > 1", nativeQuery = true)
    List<OverpaidInvoicesDto> findAllOverpaidInvoices();


}