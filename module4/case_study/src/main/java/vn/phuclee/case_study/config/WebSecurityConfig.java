package vn.phuclee.case_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import vn.phuclee.case_study.userdetail.MyUserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailServiceImpl myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/loginPage")
                .defaultSuccessUrl("/home")
                .failureUrl("/loginPage?error=true")
                .permitAll()
                .and()
                .logout().and()
                .authorizeRequests().antMatchers("/home","/css/**","/js/**","/img/**").permitAll()
                .antMatchers("/employee/*", "/employee/*/*").hasRole("ADMIN")
                .anyRequest().authenticated();
//        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);
//                .and().exceptionHandling().accessDeniedPage("/403")



        // Cấu hình Remember Me . Ở form login bước 3, ta có 1 nút remember me. Nếu người dùng tick vào đó ta sẽ dung cookie lưu lại trong 24h
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }
}
