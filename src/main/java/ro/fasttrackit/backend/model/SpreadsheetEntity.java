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

}
