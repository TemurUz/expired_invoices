package temur.uz.product.payload;

import java.util.Date;

public interface DueInvoiceDto {

    Integer getId();

    Integer getOrderId();

    Double getAmount();

    Date getIssued();

    Date getDue();

}
