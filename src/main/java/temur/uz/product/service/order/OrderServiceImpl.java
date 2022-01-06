package temur.uz.product.service.order;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import temur.uz.product.entity.Customer;
import temur.uz.product.entity.Detail;
import temur.uz.product.entity.Order;
import temur.uz.product.entity.Product;
import temur.uz.product.model.ApiResponse;
import temur.uz.product.payload.OrderDetailsProductName;
import temur.uz.product.payload.dto.OrderDetailPrDto;
import temur.uz.product.payload.dto.OrderDto;
import temur.uz.product.repository.CustomerRepository;
import temur.uz.product.repository.DetailRepository;
import temur.uz.product.repository.OrderRepository;
import temur.uz.product.repository.ProductRepository;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final DetailRepository detailRepository;

    @Override
    public ApiResponse saveOrder(OrderDto orderDto) {
        Optional<Customer> customerOptional = customerRepository.findById(orderDto.getC_id());
        if (!customerOptional.isPresent())
            return new ApiResponse(false, "Failed");

        Optional<Product> productOptional = productRepository.findById(orderDto.getP_id());
        if (!productOptional.isPresent())
            return new ApiResponse(false, "Failed");

        Order order = new Order();
        order.setCustomer(customerOptional.get());
        order.setDate(new Date());
        orderRepository.save(order);

        Detail details = new Detail();
        details.setOrder(order);
        details.setProduct(productOptional.get());
        details.setQuantity(orderDto.getQuantity());
        detailRepository.save(details);

        return new ApiResponse(true, "Success");
    }

    @Override
    public OrderDetailPrDto getDetail(Integer orderId) {
        Optional<Order> byId = orderRepository.findById(orderId);
        if (!byId.isPresent()) {
            return  null;
        }
        OrderDetailsProductName byOrderId = orderRepository.findByOrderId(byId.get().getId());
        OrderDetailPrDto orderDetailPrDto = new OrderDetailPrDto();
        orderDetailPrDto.setDate(byOrderId.getDate());
        orderDetailPrDto.setQuantity(byOrderId.getQuantity());
        orderDetailPrDto.setName(byOrderId.getName());
        return orderDetailPrDto;
    }

}
