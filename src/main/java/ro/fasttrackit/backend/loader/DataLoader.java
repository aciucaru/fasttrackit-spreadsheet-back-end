package ro.fasttrackit.backend.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

import ro.fasttrackit.backend.authentication.model.*;
import ro.fasttrackit.backend.authentication.repository.*;
import ro.fasttrackit.backend.model.*;
import ro.fasttrackit.backend.repository.*;

import static java.util.UUID.randomUUID;

@Component
public class DataLoader implements CommandLineRunner
{
    private final SpreadsheetRepository tableRepo;
    private final UserRepository userRepo;
    private final SpreadsheetPermissionsRepository tablePermissionsRepo;
    //    @Autowired
    private final PasswordEncoder passwordEncoder;

    public DataLoader(SpreadsheetRepository tableRepo,
                      UserRepository userRepo,
                      SpreadsheetPermissionsRepository tablePermissionsRepo,
                      PasswordEncoder passwordEncoder)
    {
        this.tableRepo = tableRepo;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.tablePermissionsRepo = tablePermissionsRepo;
    }

    @Override
    public void run(String... args) throws Exception
    {
        CellStyle defaultCellStyle = new CellStyle
                (
                        false,
                        "#bbffff",

                        false,
                        "#000000",

                        false,
                        "Arial, sans-serif",

                        false,
                        false,

                        false,
                        "#000000",

                        false,
                        1
                );

        Row row1 = new Row(List.of(new Cell("0", defaultCellStyle),
                new Cell("a", defaultCellStyle),
                new Cell("true", defaultCellStyle)
        ));

        Row row2 = new Row(List.of(new Cell("1", defaultCellStyle),
                new Cell("b", defaultCellStyle),
                new Cell("false", defaultCellStyle)
        ));

        Row row3 = new Row(List.of(new Cell("2", defaultCellStyle),
                new Cell("c", defaultCellStyle),
                new Cell("true", defaultCellStyle)
        ));

        Row row4 = new Row(List.of(new Cell("3", defaultCellStyle),
                new Cell("d", defaultCellStyle),
                new Cell("true", defaultCellStyle)
        ));

        Row row5 = new Row(List.of(new Cell("4", defaultCellStyle),
                new Cell("e", defaultCellStyle),
                new Cell("false", defaultCellStyle)
        ));

        List<ColumnInfo> columnInfos =
                List.of(
                    new ColumnInfo("Numbers", ColumnType.NUMBER, GeneratingMethod.FROM_USER_INPUT, "string_col"),
                    new ColumnInfo("Strings", ColumnType.STRING, GeneratingMethod.FROM_USER_INPUT, "string_col"),
                    new ColumnInfo("Booleans", ColumnType.BOOL, GeneratingMethod.FROM_USER_INPUT, "bool_col")
                );
        SpreadsheetEntity tableEntity = new SpreadsheetEntity(randomUUID().toString(),
                "Test table",
                columnInfos,
                List.of(row1, row2, row3));
        tableRepo.save(tableEntity);

        SpreadsheetPermissionsEntity user1Permissions = new SpreadsheetPermissionsEntity(randomUUID().toString(),
                tableEntity, true, true);
        SpreadsheetPermissionsEntity user2Permissions = new SpreadsheetPermissionsEntity(randomUUID().toString(),
                tableEntity, true, false);
        SpreadsheetPermissionsEntity user3Permissions = new SpreadsheetPermissionsEntity(randomUUID().toString(),
                tableEntity, false, false);
        tablePermissionsRepo.saveAll(List.of(user1Permissions, user2Permissions, user3Permissions));

        UserEntity user1 = new UserEntity(randomUUID().toString(),
                                        "admin",
                                        passwordEncoder.encode("secret"),
                                        true, true, true, true,
                                        List.of(new SimpleGrantedAuthority("READ"),
                                                new SimpleGrantedAuthority("WRITE")),
                                        "admin@sheets.com",
                                        List.of(user1Permissions));

        UserEntity user2 = new UserEntity(randomUUID().toString(),
                                        "andrei",
                                        passwordEncoder.encode("secret"),
                                        true, true, true, true,
                                        List.of(new SimpleGrantedAuthority("READ"),
                                                new SimpleGrantedAuthority("WRITE")),
                                        "andrei123@gmail.com",
                                        List.of(user2Permissions));

        UserEntity user3 = new UserEntity(randomUUID().toString(),
                                        "alex",
                                        passwordEncoder.encode("secret"),
                                        true, true, true, true,
                                        List.of(new SimpleGrantedAuthority("READ"),
                                                new SimpleGrantedAuthority("WRITE")),
                                        "alex2000@test.com",
                                        List.of(user3Permissions));

        userRepo.saveAll(List.of(user1, user2, user3));
    }
}
