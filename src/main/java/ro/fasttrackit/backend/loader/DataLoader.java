package ro.fasttrackit.backend.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
                    "#ffffff", // bg color
                    "#000000", // fg color
                    "#000000", // border color

                    "Arial, sans-serif", // font
                    false, // bold
                    false // italic
                );

        Row row1 = new Row(List.of(new Cell("abc", 0.0, false, defaultCellStyle),
                                    new Cell("abc", 0.0, false, defaultCellStyle),
                                    new Cell("abc", 0.0, false, defaultCellStyle)
                                    )
                            );

        Row row2 = new Row(List.of(new Cell("def", 1.0, true, defaultCellStyle),
                                    new Cell("def", 1.0, true, defaultCellStyle),
                                    new Cell("def", 1.0, true, defaultCellStyle)
                                    )
                            );

        Row row3 = new Row(List.of(new Cell("ghi", 2.0, false, defaultCellStyle),
                                    new Cell("ghi", 2.0, false, defaultCellStyle),
                                    new Cell("ghi", 2.0, false, defaultCellStyle)
                                    )
                            );

        Row row4 = new Row(List.of(new Cell("jkl", 3.0, false, defaultCellStyle),
                                    new Cell("jkl", 3.0, false, defaultCellStyle),
                                    new Cell("jkl", 3.0, false, defaultCellStyle)
                                    )
                            );

        Row row5 = new Row(List.of(new Cell("mno", 4.0, true, defaultCellStyle),
                                    new Cell("mno", 4.0, true, defaultCellStyle),
                                    new Cell("mno", 4.0, true, defaultCellStyle)
                                    )
                            );

        List<ColumnInfo> columnInfos =
                List.of(
                        new ColumnInfo("Numbers",
                                        ColumnType.NUMBER,
                                        GeneratingMethod.FROM_USER_INPUT,
                                        "numCol",
                                        "",
                                        70), // latimea in pixeli a coloanei
                        new ColumnInfo("Strings",
                                        ColumnType.STRING,
                                        GeneratingMethod.FROM_USER_INPUT,
                                        "stringCol",
                                        "",
                                        70), // latimea in pixeli a coloanei
                        new ColumnInfo("Booleans",
                                        ColumnType.BOOL,
                                        GeneratingMethod.FROM_USER_INPUT,
                                        "boolCol",
                                        "",
                                        70) // latimea in pixeli a coloanei
                    );
        List<ChartInfo> charts = new ArrayList<ChartInfo>();
        SpreadsheetEntity tableEntity = new SpreadsheetEntity(randomUUID().toString(),
                "Test table",
                columnInfos,
                List.of(row1, row2, row3, row4, row5),
                40, // indexColWidthPx
                charts
                );
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
