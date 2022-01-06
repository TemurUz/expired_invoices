package temur.uz.product.entity;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id", referencedColumnName = "order")
    private Order order;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Date issued; //format 2021-09-16

    @Column(nullable = false)
    private Date due; //format 2021-09-16

}
