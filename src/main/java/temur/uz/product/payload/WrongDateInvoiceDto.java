package temur.uz.product.payload;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import java.util.Date;

public interface WrongDateInvoiceDto {

    Integer getId();

    Date getIssued();

    Integer getOrderId();

    Date getDate();

}
