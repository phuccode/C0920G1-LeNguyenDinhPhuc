package vn.phuclee.case_study.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {

    @Id
    @GeneratedValue()
    private int serviceTypeId;

    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceTypeId", cascade = CascadeType.ALL)
    private List<Service> services;

    public ServiceType() {
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
