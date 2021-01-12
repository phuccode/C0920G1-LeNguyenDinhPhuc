package quanli_springboost.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quanli_springboost.demo.model.Province;
import quanli_springboost.demo.repository.ProvinceRepository;
import quanli_springboost.demo.service.ProvinceService;
@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
