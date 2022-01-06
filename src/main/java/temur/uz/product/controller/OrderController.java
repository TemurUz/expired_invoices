package temur.uz.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import temur.uz.product.model.ApiResponse;
import temur.uz.product.payload.OrderDetailsProductName;
import temur.uz.product.payload.dto.OrderDetailPrDto;
import temur.uz.product.payload.dto.OrderDto;
import temur.uz.product.service.order.OrderService;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse> save(@RequestBody OrderDto orderDto){
        ApiResponse apiResponse = orderService.saveOrder(orderDto);
        if (!apiResponse.isSuccess())
            return ResponseEntity.status(409).body(apiResponse);
        return ResponseEntity.status(201).body(apiResponse);
    }

    @GetMapping("/details/{order_id}")
    public ResponseEntity<OrderDetailPrDto> get(@PathVariable Integer order_id){
        OrderDetailPrDto detail = orderService.getDetail(order_id);
        if (detail == null){
            return ResponseEntity.status(409).body(null);
        }
        return ResponseEntity.status(200).body(detail);
    }

}
