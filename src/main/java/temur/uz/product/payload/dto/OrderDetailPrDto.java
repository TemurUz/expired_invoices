package temur.uz.product.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailPrDto {

    private Date date;

    private int quantity;

    private String name;
}
