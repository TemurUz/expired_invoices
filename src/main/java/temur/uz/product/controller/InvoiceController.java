package temur.uz.product.controller;
/**
 * Author - Temirmalik Nomozov Hakimovich
 *
 * @TUITsecurity04
 */

import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import temur.uz.product.Response;
import temur.uz.product.entity.Invoice;
import temur.uz.product.service.invoice.InvoiceService;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @GetMapping("/expaired_invoice")
    public Response getExparedInvoice() {
        return invoiceService.getExpiredInvoice();
    }
}
