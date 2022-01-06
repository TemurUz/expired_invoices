package temur.uz.product.entity;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 10, message = "Not to exceed 10 characters")
    private String name;

    @ManyToOne
    private Category categories;

    @Size(max = 20, message = "Not to exceed 20 characters")
    private String description;

    private Double price;

    @Size(max = 1024)
    private String photo;

}
