package com.org.practice.config;

import com.org.practice.exceptionhandling.CustomAccessDeniedHandler;
import com.org.practice.exceptionhandling.CustomBasicAuthenticationEntryPoint;
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
@Profile("!prod")
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(smc->smc.invalidSessionUrl("/invalid-session").maximumSessions(3).maxSessionsPreventsLogin(true)) //if session is invalid then it will redirect to invalid-session
                .requiresChannel(rcc->rcc.anyRequest().requiresInsecure()) //it will allow http requests
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/my-account","/my-loans","/my-balance","/my-cards").authenticated()
                        .requestMatchers("/notices","/contacts/**","/register","/invalid-session").permitAll());
        http.formLogin(withDefaults()); //inside form login we canont basic authentication entrypoint bcz it doesnt deal with json
        http.httpBasic(hbc -> hbc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));//custom configuration fr basic authentication entry point
        http.exceptionHandling(ehc->ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));
// for session fixation through smc we can call sessionFixation().migrateSession() or sessionFixation().none()

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
