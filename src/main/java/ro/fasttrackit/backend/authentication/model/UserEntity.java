package ro.fasttrackit.backend.authentication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

import ro.fasttrackit.backend.model.SpreadsheetEntity;

@Document(collection = "users")
public record UserEntity(@Id String id,
                         @Indexed(unique = true) String username,
                         String password,
                         Boolean accountNonExpired,
                         Boolean accountNonLocked,
                         Boolean credentialsNonExpired,
                         Boolean enabled,
                         List<String> authorities,
                         @Indexed(unique = true) String email,
                         @DBRef List<SpreadsheetEntity> personalSpreadsheets
)
{

}
