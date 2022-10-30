package ro.fasttrackit.backend.loader;

import org.springframework.boot.CommandLineRunner;
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

    public DataLoader(SpreadsheetRepository tableRepo, UserRepository userRepo)
    {
        this.tableRepo = tableRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception
    {
        SpreadsheetEntity spreadsheet1 = generateSpreadsheet1();
        SpreadsheetEntity spreadsheet2 = generateSpreadsheet2();
        SpreadsheetEntity spreadsheet3 = generateSpreadsheet3();

        tableRepo.save(spreadsheet1);
        tableRepo.save(spreadsheet2);
        tableRepo.save(spreadsheet3);

        userRepo.save(generateUser1(spreadsheet1));
        userRepo.save(generateUser2(spreadsheet2));
        userRepo.save(generateUser3(spreadsheet3));
    }

    private CellStyle generateDefaultCellStyle()
    {
        CellStyle cellStyle = new CellStyle
                                        (
                                            "#ffffff", // bg color
                                            "#000000", // fg color
                                            "#000000", // border color

                                            "Arial, sans-serif", // font
                                            false, // bold
                                            false // italic
                                        );
        return cellStyle;
    }

    private SpreadsheetEntity generateSpreadsheet1()
    {
        List<ColumnInfo> columnInfos =
                List.of(
                        new ColumnInfo("EEID",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "eeid",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Full Name",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "fullName",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Job Title",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "jobTitle",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Department",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "department",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Gender",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "gender",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Age",
                                ColumnType.NUMBER,
                                GeneratingMethod.FROM_USER_INPUT,
                                "age",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Annual Salary",
                                ColumnType.NUMBER,
                                GeneratingMethod.FROM_USER_INPUT,
                                "salary",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Bonus %",
                                ColumnType.NUMBER,
                                GeneratingMethod.FROM_USER_INPUT,
                                "bonus",
                                "", // formula
                                70) // latimea in pixeli a coloanei
                                );
        List<ChartInfo> charts = new ArrayList<ChartInfo>();

        Row row1 = new Row(List.of(
                                new Cell("E04105", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Theodore Dinh", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Technical Architect", 0.0, true, generateDefaultCellStyle()),
                                new Cell("IT", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("59", 59.0, true, generateDefaultCellStyle()),
                                new Cell("99975", 99975.0, true, generateDefaultCellStyle()),
                                new Cell("0", 0.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row2 = new Row(List.of(
                                new Cell("E04332", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Luke Martin", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Analyst", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Finance", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("25", 25.0, true, generateDefaultCellStyle()),
                                new Cell("41336", 41336.0, true, generateDefaultCellStyle()),
                                new Cell("0", 0.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row3 = new Row(List.of(
                                new Cell("E03344", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Camila Rogers", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Controls Engineer", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Engineering", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Female", 0.0, true, generateDefaultCellStyle()),
                                new Cell("27", 27.0, true, generateDefaultCellStyle()),
                                new Cell("109851", 109851.0, true, generateDefaultCellStyle()),
                                new Cell("0", 0.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row4 = new Row(List.of(
                                new Cell("E03496", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Robert Yang", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Sr. Analyst", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Accounting", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("31", 31.0, true, generateDefaultCellStyle()),
                                new Cell("97078", 97078.0, true, generateDefaultCellStyle()),
                                new Cell("0", 0.0, true, generateDefaultCellStyle())
                                )
                            );
        Row row5 = new Row(List.of(
                                new Cell("E04116", 0.0, true, generateDefaultCellStyle()),
                                new Cell("David Barnes", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Director", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Human Resources", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("64", 59.0, true, generateDefaultCellStyle()),
                                new Cell("186503", 186503.0, true, generateDefaultCellStyle()),
                                new Cell("24", 24.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row6 = new Row(List.of(
                                new Cell("E04152", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Adeline Huang", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Controls Engineer", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Engineering", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Female", 0.0, true, generateDefaultCellStyle()),
                                new Cell("34", 34.0, true, generateDefaultCellStyle()),
                                new Cell("109989", 109989.0, true, generateDefaultCellStyle()),
                                new Cell("5", 5.0, true, generateDefaultCellStyle())
                                )
                            );
        Row row7 = new Row(List.of(
                                new Cell("E03574", 0.0, true, generateDefaultCellStyle()),
                                new Cell("John Moore", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Vice President", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Sales", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("52", 52.0, true, generateDefaultCellStyle()),
                                new Cell("199808", 199808.0, true, generateDefaultCellStyle()),
                                new Cell("32", 32.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row8 = new Row(List.of(
                                new Cell("E03720", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Dominic Clark", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Quality Engineer", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Engineering", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("52", 52.0, true, generateDefaultCellStyle()),
                                new Cell("71476", 71476.0, true, generateDefaultCellStyle()),
                                new Cell("3", 3.0, true, generateDefaultCellStyle())
                                )
                            );
        Row row9 = new Row(List.of(
                                new Cell("E01839", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Stella Alexander", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Operations Engineer", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Engineering", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Female", 0.0, true, generateDefaultCellStyle()),
                                new Cell("38", 38.0, true, generateDefaultCellStyle()),
                                new Cell("102043", 102043.0, true, generateDefaultCellStyle()),
                                new Cell("2", 2.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row10 = new Row(List.of(
                                new Cell("E00791", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Thomas Padilla", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Vice President", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Marketing", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("57", 57.0, true, generateDefaultCellStyle()),
                                new Cell("206624", 206624.0, true, generateDefaultCellStyle()),
                                new Cell("40", 40.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row11 = new Row(List.of(
                                new Cell("E02166", 0.0, true, generateDefaultCellStyle()),
                                new Cell("John Soto", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Sr. Manger", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Finance", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("60", 60.0, true, generateDefaultCellStyle()),
                                new Cell("141899", 141899.0, true, generateDefaultCellStyle()),
                                new Cell("15", 15.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row12 = new Row(List.of(
                                new Cell("E00386", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Parker James", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Quality Engineer", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Engineering", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("45", 45.0, true, generateDefaultCellStyle()),
                                new Cell("70505", 70505.0, true, generateDefaultCellStyle()),
                                new Cell("0", 0.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row13 = new Row(List.of(
                                new Cell("E04562", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Xavier Zheng", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Account Representative", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Sales", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("31", 31.0, true, generateDefaultCellStyle()),
                                new Cell("55854", 55854.0, true, generateDefaultCellStyle()),
                                new Cell("0", 0.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row14 = new Row(List.of(
                                new Cell("E00443", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Nolan Bui", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Computer Systems Manager", 0.0, true, generateDefaultCellStyle()),
                                new Cell("IT", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("28", 28.0, true, generateDefaultCellStyle()),
                                new Cell("67925", 67925.0, true, generateDefaultCellStyle()),
                                new Cell("8", 8.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row15 = new Row(List.of(
                                new Cell("E02939", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Julian Fong", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Quality Engineer", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Engineering", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Male", 0.0, true, generateDefaultCellStyle()),
                                new Cell("61", 61.0, true, generateDefaultCellStyle()),
                                new Cell("80950", 80950.0, true, generateDefaultCellStyle()),
                                new Cell("0", 0.0, true, generateDefaultCellStyle())
                                )
                            );

        SpreadsheetEntity spreadsheet = new SpreadsheetEntity(randomUUID().toString(),
                "Employees",
                columnInfos,
                List.of(row1, row2, row3, row4, row5,
                        row6, row7, row8, row9, row10,
                        row11, row12, row13, row14, row15),
                40, // indexColWidthPx
                charts
        );

        return spreadsheet;
    }

    private SpreadsheetEntity generateSpreadsheet2()
    {
        List<ColumnInfo> columnInfos =
                List.of(
                        new ColumnInfo("Order Date",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "orderDate",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Region",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "region",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Representative",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "repr",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Item",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "item",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Units",
                                ColumnType.NUMBER,
                                GeneratingMethod.FROM_USER_INPUT,
                                "units",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Unit Cost",
                                ColumnType.NUMBER,
                                GeneratingMethod.FROM_USER_INPUT,
                                "unitCost",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Total",
                                ColumnType.NUMBER,
                                GeneratingMethod.FROM_USER_INPUT,
                                "total",
                                "units * unitCost", // formula
                                70) // latimea in pixeli a coloanei
                );
        List<ChartInfo> charts = new ArrayList<ChartInfo>();

        Row row1 = new Row(List.of(
                                new Cell("1/6/21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("East", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Jones", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Pencil", 0.0, true, generateDefaultCellStyle()),
                                new Cell("95", 95.0, true, generateDefaultCellStyle()),
                                new Cell("1.99", 1.99, true, generateDefaultCellStyle()),
                                new Cell("189.05", 189.05, true, generateDefaultCellStyle())
                                )
                            );

        Row row2 = new Row(List.of(
                                new Cell("1/23/21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Central", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Kivell", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Binder", 0.0, true, generateDefaultCellStyle()),
                                new Cell("50", 50.0, true, generateDefaultCellStyle()),
                                new Cell("19.99", 19.99, true, generateDefaultCellStyle()),
                                new Cell("999.50", 999.50, true, generateDefaultCellStyle())
                                )
                            );

        Row row3 = new Row(List.of(
                                new Cell("4/1/21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("East", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Jones", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Binder", 0.0, true, generateDefaultCellStyle()),
                                new Cell("60", 60.0, true, generateDefaultCellStyle()),
                                new Cell("4.99", 4.99, true, generateDefaultCellStyle()),
                                new Cell("299.40", 299.40, true, generateDefaultCellStyle())
                                )
                            );

        Row row4 = new Row(List.of(
                                new Cell("9/1/21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Central", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Smith", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Desk", 0.0, true, generateDefaultCellStyle()),
                                new Cell("2", 2.0, true, generateDefaultCellStyle()),
                                new Cell("125.00", 125.00, true, generateDefaultCellStyle()),
                                new Cell("250.00", 250.00, true, generateDefaultCellStyle())
                                )
                            );

        Row row5 = new Row(List.of(
                                new Cell("9/18/21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("East", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Jones", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Pen Set", 0.0, true, generateDefaultCellStyle()),
                                new Cell("16", 16.0, true, generateDefaultCellStyle()),
                                new Cell("15.99", 15.99, true, generateDefaultCellStyle()),
                                new Cell("255.84", 255.84, true, generateDefaultCellStyle())
                                )
                            );

        Row row6 = new Row(List.of(
                                new Cell("12/12/21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Central", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Smith", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Pencil", 0.0, true, generateDefaultCellStyle()),
                                new Cell("67", 67.0, true, generateDefaultCellStyle()),
                                new Cell("1.29", 1.29, true, generateDefaultCellStyle()),
                                new Cell("86.43", 86.43, true, generateDefaultCellStyle())
                                )
                            );

        Row row7 = new Row(List.of(
                                new Cell("3/7/22", 0.0, true, generateDefaultCellStyle()),
                                new Cell("West", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Sorvino", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Binder", 0.0, true, generateDefaultCellStyle()),
                                new Cell("7", 7.0, true, generateDefaultCellStyle()),
                                new Cell("19.99", 19.99, true, generateDefaultCellStyle()),
                                new Cell("139.93", 139.93, true, generateDefaultCellStyle())
                                )
                            );

        Row row8 = new Row(List.of(
                                new Cell("4/27/22", 0.0, true, generateDefaultCellStyle()),
                                new Cell("East", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Howard", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Pen", 0.0, true, generateDefaultCellStyle()),
                                new Cell("96", 96.0, true, generateDefaultCellStyle()),
                                new Cell("4.99", 4.99, true, generateDefaultCellStyle()),
                                new Cell("479.04", 479.04, true, generateDefaultCellStyle())
                                )
                            );

        Row row9 = new Row(List.of(
                                new Cell("6/17/22", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Central", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Kivell", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Desk", 0.0, true, generateDefaultCellStyle()),
                                new Cell("5", 5.0, true, generateDefaultCellStyle()),
                                new Cell("125.0", 125.0, true, generateDefaultCellStyle()),
                                new Cell("625.0", 625.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row10 = new Row(List.of(
                                new Cell("8/24/22", 0.0, true, generateDefaultCellStyle()),
                                new Cell("West", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Sorvino", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Desk", 0.0, true, generateDefaultCellStyle()),
                                new Cell("3", 3.0, true, generateDefaultCellStyle()),
                                new Cell("275.0", 125.0, true, generateDefaultCellStyle()),
                                new Cell("825.00", 825.00, true, generateDefaultCellStyle())
                                )
                            );

        SpreadsheetEntity spreadsheet = new SpreadsheetEntity(randomUUID().toString(),
                "Sales orders",
                columnInfos,
                List.of(row1, row2, row3, row4, row5,
                        row6, row7, row8, row9, row10),
                40, // indexColWidthPx
                charts
        );

        return spreadsheet;
    }

    private SpreadsheetEntity generateSpreadsheet3()
    {
        List<ColumnInfo> columnInfos =
                List.of(
                        new ColumnInfo("Policy",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "policy",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Expiry",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "expiry",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Location",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "location",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("State",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "state",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Region",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "region",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Insured Value",
                                ColumnType.NUMBER,
                                GeneratingMethod.FROM_USER_INPUT,
                                "insuredValue",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Construction",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "construction",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Business Type",
                                ColumnType.STRING,
                                GeneratingMethod.FROM_USER_INPUT,
                                "businessType",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Earthquake",
                                ColumnType.BOOL,
                                GeneratingMethod.FROM_USER_INPUT,
                                "earthquake",
                                "", // formula
                                70), // latimea in pixeli a coloanei
                        new ColumnInfo("Flood",
                                ColumnType.BOOL,
                                GeneratingMethod.FROM_USER_INPUT,
                                "flood",
                                "", // formula
                                70) // latimea in pixeli a coloanei
                );
        List<ChartInfo> charts = new ArrayList<ChartInfo>();

        Row row1 = new Row(List.of(
                                new Cell("100242", 0.0, true, generateDefaultCellStyle()),
                                new Cell("2-Jan-21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Urban", 0.0, true, generateDefaultCellStyle()),
                                new Cell("NY", 0.0, true, generateDefaultCellStyle()),

                                new Cell("East", 0.0, true, generateDefaultCellStyle()),
                                new Cell("1617630", 1617630.0, true, generateDefaultCellStyle()),
                                new Cell("Frame", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Retail", 0.0, true, generateDefaultCellStyle()),

                                new Cell("false", 0.0, false, generateDefaultCellStyle()),
                                new Cell("false", 0.0, false, generateDefaultCellStyle())
                                )
                            );

        Row row2 = new Row(List.of(
                                new Cell("100314", 0.0, true, generateDefaultCellStyle()),
                                new Cell("3-Mar-21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Urban", 0.0, true, generateDefaultCellStyle()),
                                new Cell("NY", 0.0, true, generateDefaultCellStyle()),

                                new Cell("East", 0.0, true, generateDefaultCellStyle()),
                                new Cell("8678500", 8678500.0, true, generateDefaultCellStyle()),
                                new Cell("Fire Resist", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Apartment", 0.0, true, generateDefaultCellStyle()),

                                new Cell("true", 1.0, true, generateDefaultCellStyle()),
                                new Cell("true", 1.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row3 = new Row(List.of(
                                new Cell("100359", 0.0, true, generateDefaultCellStyle()),
                                new Cell("2-Jan-21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Rural", 0.0, true, generateDefaultCellStyle()),
                                new Cell("WI", 0.0, true, generateDefaultCellStyle()),

                                new Cell("Midwest", 0.0, true, generateDefaultCellStyle()),
                                new Cell("2052660", 2052660.0, true, generateDefaultCellStyle()),
                                new Cell("Frame", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Farming", 0.0, true, generateDefaultCellStyle()),

                                new Cell("false", 0.0, false, generateDefaultCellStyle()),
                                new Cell("false", 0.0, false, generateDefaultCellStyle())
                                )
                            );

        Row row4 = new Row(List.of(
                                new Cell("100429", 0.0, true, generateDefaultCellStyle()),
                                new Cell("9-Jan-21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Urban", 0.0, true, generateDefaultCellStyle()),
                                new Cell("IL", 0.0, true, generateDefaultCellStyle()),

                                new Cell("Midwest", 0.0, true, generateDefaultCellStyle()),
                                new Cell("4036000", 4036000.0, true, generateDefaultCellStyle()),
                                new Cell("Masonry", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Retail", 0.0, true, generateDefaultCellStyle()),

                                new Cell("true", 1.0, true, generateDefaultCellStyle()),
                                new Cell("false", 0.0, false, generateDefaultCellStyle())
                                )
                            );

        Row row5 = new Row(List.of(
                                new Cell("100426", 0.0, true, generateDefaultCellStyle()),
                                new Cell("16-Jan-20", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Urban", 0.0, true, generateDefaultCellStyle()),
                                new Cell("VT", 0.0, true, generateDefaultCellStyle()),

                                new Cell("Northeast", 0.0, true, generateDefaultCellStyle()),
                                new Cell("2432875", 2432875.0, true, generateDefaultCellStyle()),
                                new Cell("Fire Resist", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Apartment", 0.0, true, generateDefaultCellStyle()),

                                new Cell("false", 0.0, false, generateDefaultCellStyle()),
                                new Cell("false", 0.0, false, generateDefaultCellStyle())
                                )
                            );

        Row row6 = new Row(List.of(
                                new Cell("100252", 0.0, true, generateDefaultCellStyle()),
                                new Cell("17-Oct-19", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Urban", 0.0, true, generateDefaultCellStyle()),
                                new Cell("OH", 0.0, true, generateDefaultCellStyle()),

                                new Cell("Central", 0.0, true, generateDefaultCellStyle()),
                                new Cell("1529600", 1529600.0, true, generateDefaultCellStyle()),
                                new Cell("Masonry", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Apartment", 0.0, true, generateDefaultCellStyle()),

                                new Cell("false", 0.0, false, generateDefaultCellStyle()),
                                new Cell("true", 1.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row7 = new Row(List.of(
                                new Cell("100382", 0.0, true, generateDefaultCellStyle()),
                                new Cell("19-Jan-21", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Urban", 0.0, true, generateDefaultCellStyle()),
                                new Cell("NJ", 0.0, true, generateDefaultCellStyle()),

                                new Cell("East", 0.0, true, generateDefaultCellStyle()),
                                new Cell("2328650", 2328650.0, true, generateDefaultCellStyle()),
                                new Cell("Frame", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Organization", 0.0, true, generateDefaultCellStyle()),

                                new Cell("false", 0.0, false, generateDefaultCellStyle()),
                                new Cell("false", 0.0, false, generateDefaultCellStyle())
                                )
                            );

        Row row8 = new Row(List.of(
                                new Cell("100381", 0.0, true, generateDefaultCellStyle()),
                                new Cell("23-Jul-18", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Urban", 0.0, true, generateDefaultCellStyle()),
                                new Cell("VT", 0.0, true, generateDefaultCellStyle()),

                                new Cell("Northeast", 0.0, true, generateDefaultCellStyle()),
                                new Cell("7203500", 7203500.0, true, generateDefaultCellStyle()),
                                new Cell("Frame", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Office Bldg", 0.0, true, generateDefaultCellStyle()),

                                new Cell("true", 1.0, true, generateDefaultCellStyle()),
                                new Cell("true", 1.0, true, generateDefaultCellStyle())
                                )
                            );

        Row row9 = new Row(List.of(
                                new Cell("100312", 0.0, true, generateDefaultCellStyle()),
                                new Cell("25-Jan-17", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Rural", 0.0, true, generateDefaultCellStyle()),
                                new Cell("IL", 0.0, true, generateDefaultCellStyle()),

                                new Cell("Midwest", 0.0, true, generateDefaultCellStyle()),
                                new Cell("3145700", 3145700.0, true, generateDefaultCellStyle()),
                                new Cell("Frame", 0.0, true, generateDefaultCellStyle()),
                                new Cell("Education", 0.0, true, generateDefaultCellStyle()),

                                new Cell("true", 1.0, true, generateDefaultCellStyle()),
                                new Cell("false", 0.0, false, generateDefaultCellStyle())
                                )
                            );

        Row row10 = new Row(List.of(
                new Cell("100656", 0.0, true, generateDefaultCellStyle()),
                new Cell("6-May-15", 0.0, true, generateDefaultCellStyle()),
                new Cell("Urban", 0.0, true, generateDefaultCellStyle()),
                new Cell("MN", 0.0, true, generateDefaultCellStyle()),

                new Cell("Midwest", 0.0, true, generateDefaultCellStyle()),
                new Cell("1834200", 1834200.0, true, generateDefaultCellStyle()),
                new Cell("Frame", 0.0, true, generateDefaultCellStyle()),
                new Cell("Construction", 0.0, true, generateDefaultCellStyle()),

                new Cell("true", 1.0, true, generateDefaultCellStyle()),
                new Cell("true", 1.0, true, generateDefaultCellStyle())
        )
        );

        SpreadsheetEntity spreadsheet = new SpreadsheetEntity(randomUUID().toString(),
                "Insurance",
                columnInfos,
                List.of(row1, row2, row3, row4, row5,
                        row6, row7, row8, row9, row10),
                40, // indexColWidthPx
                charts
        );

        return spreadsheet;
    }

    private UserEntity generateUser1(SpreadsheetEntity spreadsheet)
    {
        UserEntity user = new UserEntity(
                                        randomUUID().toString(),
                                        "admin",
                                        "secret",
                                        true, true, true, true,
                                        List.of("READ", "WRITE"),
                                        "admin@sheets.com",
                                        List.of(spreadsheet)
                                        );

        return user;
    }

    private UserEntity generateUser2(SpreadsheetEntity spreadsheet)
    {
        UserEntity user = new UserEntity(
                                        randomUUID().toString(),
                                        "andrei",
                                        "secret",
                                        true, true, true, true,
                                        List.of("READ", "WRITE"),
                                        "andrei123@gmail.com",
                                        List.of(spreadsheet)
                                        );

        return user;
    }

    private UserEntity generateUser3(SpreadsheetEntity spreadsheet)
    {
        UserEntity user = new UserEntity(
                                        randomUUID().toString(),
                                        "alex",
                                        "secret",
                                        true, true, true, true,
                                        List.of("READ", "WRITE"),
                                        "alex2000@test.com",
                                        List.of(spreadsheet)
                                        );

        return user;
    }
}
