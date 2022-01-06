package temur.uz.product;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class Response {

    private  Integer code;
    private String message;
    private Object[] body;

}
