package vn.phuclee.case_study.services.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.phuclee.case_study.model.AttachService;
import vn.phuclee.case_study.repository.contract.AttachServiceRepository;

import java.util.List;

@Service
public class AttachServiceImpl implements AttachServiceService{
    @Autowired
    AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
