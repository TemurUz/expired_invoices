package temur.uz.product.service.invoice;

import temur.uz.product.Response;
import temur.uz.product.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    Response getExpiredInvoice();

}
