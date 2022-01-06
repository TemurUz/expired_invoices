package temur.uz.product.controller;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import temur.uz.product.payload.CustomerWithoutOrdersDto;
import temur.uz.product.service.customer.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers_without_orders")
    public ResponseEntity<List<CustomerWithoutOrdersDto>> getCustomerWithoutOrders(){
        return ResponseEntity.ok(customerService.getCustomerWithoutOrders());
    }

}
