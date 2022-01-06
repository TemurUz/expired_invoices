package temur.uz.product.entity;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp time;

    private Double amount;

    @ManyToOne
    private Invoice inv_id;

}
