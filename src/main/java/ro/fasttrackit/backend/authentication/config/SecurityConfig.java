package ro.fasttrackit.backend.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ro.fasttrackit.backend.authentication.service.CustomUserDetailsService;
import ro.fasttrackit.backend.authentication.model.UserEntity;
import ro.fasttrackit.backend.authentication.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;

/* Clasa pentru toate configurarile de securitate.
*  Se folosesc useri 'in-memory', dar acesti useri sunt mai intai populati in data loader si pusi in baza
*  de date, iar de abia apoi acei useri sunt luati din baza de date MongoDB si sunt folositi pt. a crea
*  useri in memory de tip Spring. Dezavantajul utilizarii userilor in memory este ca nu se pot adauga
*  useri noi, ramana doar cei generati la inceput. */
@Configuration
//@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    SecurityFilterChain httpSecurityConfig(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.cors()
                        .and()
                    .authorizeHttpRequests(
                            authz -> authz.mvcMatchers("/**").permitAll()
                    );

        return httpSecurity.build();

//        httpSecurity.authorizeHttpRequests(
//                authz -> authz.anyRequest()
//                                .authenticated()
//        );

//        httpSecurity
//                    .cors()
//                        .and()
//                    .authorizeRequests()
//                        .antMatchers("/admin/**").hasRole("ADMIN")
//                        .antMatchers("/anonymous*").anonymous()
//                        .antMatchers("/", "/home", "/login*").permitAll()
//                        .anyRequest().authenticated()
//                        .and()
//                    .formLogin()
////                        .loginPage("/login.html") // pagina personalizata de login
////                        .loginProcessingUrl("/perform_login")
////                        .defaultSuccessUrl("/homepage.html", true)
////                        .failureUrl("/login.html?error=true")
//                        .permitAll() // oricine are voie sa faca login
//                        .and()
//                    .logout()
//                        .logoutUrl("/perform_logout")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                        .and()
//                    .csrf().disable();
//        return httpSecurity.build();
    }

    @Bean
//    @Autowired // pentru UserRepository, optional?
    InMemoryUserDetailsManager userDetailManager(UserRepository userRepo)
    {
        ArrayList<UserDetails> userDetails = new ArrayList<UserDetails>();

        for(UserEntity user : userRepo.findAll())
        {
            userDetails.add(User.builder()
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .authorities(user.getAuthorities())
                                .build()
                            );
        }

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(12);
//        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public DaoAuthenticationProvider authProvider(CustomUserDetailsService userDetailsService)
    {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService);

        return authProvider;
    }
}
