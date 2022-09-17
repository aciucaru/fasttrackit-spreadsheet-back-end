package ro.fasttrackit.backend.authentication.repository;

import ro.fasttrackit.backend.authentication.model.TablePermissionsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpreadsheetPermissionsRepository extends MongoRepository<TablePermissionsEntity, String>
{

}