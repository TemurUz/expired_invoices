package temur.uz.product.service.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import temur.uz.product.payload.CustomerWithoutOrdersDto;
import temur.uz.product.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerWithoutOrdersDto> getCustomerWithoutOrders() {
        return customerRepository.findAlOrderNotCustomerDate();
    }

}
