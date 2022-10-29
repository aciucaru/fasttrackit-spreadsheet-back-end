package ro.fasttrackit.backend.authentication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
                         List<GrantedAuthority> authorities,
                         @Indexed(unique = true) String email,
                         @DBRef List<SpreadsheetEntity> personalSpreadsheets
) implements UserDetails
{
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() { return username; }

    @Override
    public boolean isAccountNonExpired() { return accountNonExpired; }

    @Override
    public boolean isAccountNonLocked() { return accountNonLocked; }

    @Override
    public boolean isCredentialsNonExpired() { return credentialsNonExpired; }

    @Override
    public boolean isEnabled() { return enabled; }
}
