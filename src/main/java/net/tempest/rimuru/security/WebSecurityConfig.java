package net.tempest.rimuru.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.tempest.rimuru.model.AuthenticatedUser;
import net.tempest.rimuru.service.userServ;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = AuthenticatedUser.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private userServ serv;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/nosecurity").hasAnyAuthority("ADMIN")
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and().formLogin().permitAll()
            .and().logout().permitAll();
    }
 
    @Bean
    public AuthenticationProvider authenticationProvider () throws Exception {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(serv);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

}