package ro.fasttrackit.backend.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import ro.fasttrackit.backend.authentication.service.CustomUserDetailsService;
import ro.fasttrackit.backend.authentication.model.UserEntity;
import ro.fasttrackit.backend.authentication.repository.UserRepository;

import java.util.ArrayList;

@Configuration
public class SecurityConfig
{
    @Bean
    SecurityFilterChain httpSecurityConfig(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                authz -> authz.mvcMatchers("/**").permitAll()
        );

        return httpSecurity.build();
    }

    @Bean
//    @Autowired // pentru UserRepository, optional?
    InMemoryUserDetailsManager userDetailManager(UserRepository userRepo) {
        ArrayList<UserDetails> userDetails = new ArrayList<UserDetails>();

        for (UserEntity user : userRepo.findAll()) {
            userDetails.add(User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .authorities(user.getAuthorities())
                    .build());
        }

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
//        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public DaoAuthenticationProvider authProvider(CustomUserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService);

        return authProvider;
    }
}
