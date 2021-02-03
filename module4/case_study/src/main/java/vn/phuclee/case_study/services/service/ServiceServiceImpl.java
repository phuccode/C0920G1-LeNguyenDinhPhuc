package vn.phuclee.case_study.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.phuclee.case_study.model.Service;
import vn.phuclee.case_study.repository.service.ServiceRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;


    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void update(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(String id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Service> search(String searchName, Pageable pageable) {
        return serviceRepository.findByServiceNameContaining(searchName, pageable);
    }
}
