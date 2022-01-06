package temur.uz.product.service.detail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import temur.uz.product.repository.DetailRepository;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService{

    private final DetailRepository detailRepository;


}
