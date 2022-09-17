package ro.fasttrackit.backend.authentication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import ro.fasttrackit.backend.model.SpreadsheetEntity;

/* Record ce modeleaza o permisiune pt. un singur spreadsheet, permisiune stocata in utilizator (UserEntity).
* Un utilizator (UserEntity) poate avea mai multe permisiuni, cate una pt. fiecare spreadsheet.
* Daca un utilizator nu are specificata o permisiune pt. un  spreadsheet anume, atunci se considera ca
* utilizatorul respectiv nu are nici o penisiune pt. acel spreadsheet. */
@Document(collection = "permissions")
public record SpreadsheetPermissionsEntity(@Id String id,
                                           @DBRef SpreadsheetEntity spreadsheet, // spreadsheet-ul pt. care se seteaza aceasta permisiune
                                           Boolean read, // daca se da permisiune de read pt. acel spreadsheet
                                           Boolean write) // daca se da permisiune de write pt. acel spreadsheet
{

}
