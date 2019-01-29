package uk.co.datadisk.security2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

            // in Spring Security 5 you by default cannot use plain passwords, so used a noop password encoder
            // you can also use .password("{noop}password"}) instead of above
            auth
                .inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user")
                  .password("password")
                  .roles("USER")
                  .authorities("USER")
                    .and()
                .withUser("admin")
                  .password("admin")
                  .roles("USER", "ADMIN")
                  .authorities("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                  .and()
                .httpBasic();
    }
}
