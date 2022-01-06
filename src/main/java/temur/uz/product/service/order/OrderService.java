package temur.uz.product.service.order;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import temur.uz.product.model.ApiResponse;
import temur.uz.product.payload.OrderDetailsProductName;
import temur.uz.product.payload.dto.OrderDetailPrDto;
import temur.uz.product.payload.dto.OrderDto;

public interface OrderService {

    ApiResponse saveOrder(OrderDto orderDto);

    OrderDetailPrDto getDetail(Integer orderId);

}
