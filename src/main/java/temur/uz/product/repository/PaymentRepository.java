package temur.uz.product.repository;
/**
 * Author - Temirmalik Nomozov Hakimovich
 * @TUITsecurity04
 */
import org.springframework.data.jpa.repository.JpaRepository;
import temur.uz.product.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
