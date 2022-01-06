package temur.uz.product.service.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import temur.uz.product.Response;
import temur.uz.product.entity.Invoice;
import temur.uz.product.payload.DueInvoiceDto;
import temur.uz.product.repository.InvoiceRepository;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService{

    private final InvoiceRepository invoiceRepository;

    @Override
    public Response getExpiredInvoice() {
        Date date=new Date();
        System.out.println(date);
        List<DueInvoiceDto> allValid = invoiceRepository.findAllValid(date);
        if (allValid.isEmpty()) {
            return Response.builder()
                    .body(null)
                    .code(-1)
                    .message("malumot mavjud emas").build();
        } else {
            return Response.builder()
                    .body(allValid.stream().toArray())
                    .code(0)
                    .message("Natija").build();
        }

    }


}
