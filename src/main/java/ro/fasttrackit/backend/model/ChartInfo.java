package ro.fasttrackit.backend.model;

import java.util.List;

public record ChartInfo(ChartType chartType,
                        ChartColumnLabelInfo labelColumn,
                        List<ChartColumnDataInfo> dataColumns
                        )
{
}
