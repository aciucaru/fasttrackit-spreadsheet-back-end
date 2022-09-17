package ro.fasttrackit.backend.authentication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ro.fasttrackit.backend.model.SpreadsheetEntity;

@Document(collection = "permissions")
public record TablePermissionsEntity(@Id String id,
                                     @DBRef SpreadsheetEntity table,
                                     Boolean read,
                                     Boolean write)
{

}
