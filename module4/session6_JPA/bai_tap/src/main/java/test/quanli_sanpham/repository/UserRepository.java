package test.quanli_sanpham.repository;

import org.springframework.data.repository.CrudRepository;
import test.quanli_sanpham.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
