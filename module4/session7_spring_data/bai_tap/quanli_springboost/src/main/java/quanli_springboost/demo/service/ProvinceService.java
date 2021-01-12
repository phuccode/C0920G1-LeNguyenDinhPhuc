package quanli_springboost.demo.service;


import org.springframework.stereotype.Service;
import quanli_springboost.demo.model.Province;
@Service
public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
