package quanli_springboost.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import quanli_springboost.demo.model.Province;
@Repository
public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
