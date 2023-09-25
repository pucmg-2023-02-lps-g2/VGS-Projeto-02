package project.system.VGS.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import project.system.VGS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private UserRepository UserRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/homepage", true)
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Optional<project.system.VGS.models.User> userOptional = UserRepository.findById(username);
            project.system.VGS.models.User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            return User.withDefaultPasswordEncoder()
                    .username(user.getId())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        };
    }

}