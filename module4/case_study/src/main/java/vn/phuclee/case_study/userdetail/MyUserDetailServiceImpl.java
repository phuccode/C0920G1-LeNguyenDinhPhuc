package vn.phuclee.case_study.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.phuclee.case_study.model.MyUserDetail;
import vn.phuclee.case_study.model.User;
import vn.phuclee.case_study.repository.employee.UserRepository;

@Service
@Transactional
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw  new UsernameNotFoundException("user name not found: "+ username);
        }
        return new MyUserDetail(user);
    }
}
