package ro.fasttrackit.backend.authentication.service;

import org.springframework.stereotype.Service;

import ro.fasttrackit.backend.authentication.model.SimplifiedUser;
import ro.fasttrackit.backend.authentication.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService
{
    private final UserRepository repo;

    public UserService(UserRepository repo)
    {
        this.repo = repo;
    }

    public List<SimplifiedUser> getAll()
    {
        return repo.findAll().stream()
                .map(userEntity -> new SimplifiedUser(userEntity.username()))
                .collect(Collectors.toList());
    }
}
