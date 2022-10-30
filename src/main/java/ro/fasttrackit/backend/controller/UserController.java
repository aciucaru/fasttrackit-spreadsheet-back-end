package ro.fasttrackit.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ro.fasttrackit.backend.authentication.model.SimplifiedUser;
import ro.fasttrackit.backend.authentication.service.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController
{
    private final UserService service;

    public UserController(UserService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<SimplifiedUser> getAll()
    {
        return service.getAll();
    }
}
