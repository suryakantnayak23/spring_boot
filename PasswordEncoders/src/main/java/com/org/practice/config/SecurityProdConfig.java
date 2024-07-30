package com.org.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("prod")
public class SecurityProdConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(smc->smc.invalidSessionUrl("/invalid-session"))
                .requiresChannel(rcc->rcc.anyRequest().requiresSecure())// only allow https requests
        .csrf(csrf->csrf.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/my-account","/my-loans","/my-balance","/my-cards").authenticated()
                        .requestMatchers("/notices","/contacts","/register","/invalid-session").permitAll());
        http.formLogin(fbc->fbc.disable());
        http.httpBasic(withDefaults());
        return http.build();
    }
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
/*        UserDetails user = User.withUsername("user")
                .password("{noop}12345")
                .authorities("read")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("
                $2a$12$lJxaXXV8hz.xB9vI27rvDe3BSQgb71xMQI638mz/n2W.GwgA8h28.")
                .authorities("admin")
                .build();
        return new InMemoryUserDetailsManager(user, admin);*/ //using inmemory storage
//        return new JdbcUserDetailsManager(dataSource);
   // }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }


}
