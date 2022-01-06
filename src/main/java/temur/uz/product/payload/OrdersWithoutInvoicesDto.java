package temur.uz.product.payload;

import java.util.Date;

public interface OrdersWithoutInvoicesDto {

    Integer getId();

    Date getIssued();

    Double getPrice();

}
