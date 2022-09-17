package ro.fasttrackit.backend.authentication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ro.fasttrackit.backend.authentication.model.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String>
{
    UserEntity findByUsername(String username);
}
