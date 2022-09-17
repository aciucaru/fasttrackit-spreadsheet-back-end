package ro.fasttrackit.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ro.fasttrackit.backend.model.SpreadsheetEntity;

public interface SpreadsheetRepository extends MongoRepository<SpreadsheetEntity, String>
{

}
