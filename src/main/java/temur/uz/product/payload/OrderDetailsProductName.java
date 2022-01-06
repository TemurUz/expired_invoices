package temur.uz.product.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
public interface OrderDetailsProductName {

     Date getDate();

     int getQuantity();

     String getName();

}
