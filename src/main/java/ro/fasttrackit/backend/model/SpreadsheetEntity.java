package ro.fasttrackit.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "spreadsheets")
public record SpreadsheetEntity(@Id String id,
                                String name,
                                List<ColumnInfo> columnInfos,
                                List<Row> rows,
                                Integer indexColWidthPx,
                                List<ChartInfo> charts)
{
    // metoda ce returneaza un nou record cu un alt id dar cu aceleasi proprietati
    public SpreadsheetEntity withId(String id)
    {
        return new SpreadsheetEntity(id,
                this.name(),
                this.columnInfos(),
                this.rows(),
                this.indexColWidthPx(),
                this.charts());
    }

    // metoda ce returneaza un nou record cu acelasi id dar alte proprietati
    public SpreadsheetEntity withData(String name,
                    List<ColumnInfo> columnInfos,
                    List<Row> rows,
                    Integer indexColWidthPx,
                    List<ChartInfo> charts)
    {
        return new SpreadsheetEntity(this.id(),
                                    name,
                                    columnInfos,
                                    rows,
                                    indexColWidthPx,
                                    charts);
    }

    // metoda ce returneaza un nou record cu acelasi id dar proprietatile altui spreadsheet
    public SpreadsheetEntity withDataFrom(SpreadsheetEntity newSpreadsheet)
    {
        return new SpreadsheetEntity(this.id(),
                newSpreadsheet.name(),
                newSpreadsheet.columnInfos(),
                newSpreadsheet.rows(),
                newSpreadsheet.indexColWidthPx(),
                newSpreadsheet.charts()
        );
    }
}
