package ro.fasttrackit.backend.authentication.service;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ro.fasttrackit.backend.authentication.model.UserEntity;
import ro.fasttrackit.backend.authentication.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    //    @Autowired
    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        UserEntity user = userRepo.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);

        UserDetails userDetails = User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER")
                .build();
        return userDetails;
    }
}
