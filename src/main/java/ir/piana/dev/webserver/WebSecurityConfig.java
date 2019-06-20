package ir.piana.dev.webserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebFluxSecurity
//@Profile({"server", "development"})
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/varzesh3", "/varzesh3/**").hasRole("admin")
                .anyRequest()
                .permitAll()
                .and()
                .csrf().disable()
                .formLogin()
                .and().
                httpBasic()
                .and()
                .exceptionHandling();
    }
}