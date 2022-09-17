package ro.fasttrackit.backend.authentication.model;

/* Record pentru a trimite useri prin http catre front-end.
   Este practic o versiune simplificata a UserEntity, ca sa nu se trimita informatii confidentiale
   despre utilizatorii stocati in baza de date (parola, email, etc.). */
public record SimplifiedUser(String username)
{
}

