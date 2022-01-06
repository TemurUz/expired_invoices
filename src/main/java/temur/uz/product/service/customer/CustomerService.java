package temur.uz.product.service.customer;

import temur.uz.product.payload.CustomerWithoutOrdersDto;

import java.util.List;

public interface CustomerService {

    List<CustomerWithoutOrdersDto> getCustomerWithoutOrders();

}
