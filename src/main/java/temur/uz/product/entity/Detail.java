package temur.uz.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name = "detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @ManyToOne
    @JoinColumn(name = "pr_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "or_id")
    private Order order;

    @Column(nullable = false)
    private int quantity;

}
