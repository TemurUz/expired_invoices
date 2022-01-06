package temur.uz.product.payload;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;


public interface CustomerWithoutOrdersDto {

    String getName();

    String getCountry();

    String getAddress();

    String getPhone();

    LocalDate getDate();

}
