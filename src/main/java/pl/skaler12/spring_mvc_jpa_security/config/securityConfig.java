package pl.skaler12.spring_mvc_jpa_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity security) throws  Exception{
        //jezeli cos nie jest zapronione to znaczy ze user moze tam wejsc :)
        security.authorizeRequests()
                .antMatchers("/students").hasAnyRole("USER","ADMIN")
                .antMatchers("/addStudent").hasAnyRole("ADMIN")
                .antMatchers("/student/delete/{id}").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/students")
                .and()
                .exceptionHandling().accessDeniedPage("/403");

    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth )throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

}
