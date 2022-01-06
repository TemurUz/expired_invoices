package temur.uz.product.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Integer c_id;

    private Integer p_id;

    private int quantity;

}
