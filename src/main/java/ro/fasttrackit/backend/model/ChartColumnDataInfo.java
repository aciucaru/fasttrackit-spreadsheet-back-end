package ro.fasttrackit.backend.model;

public record ChartColumnDataInfo(String dataColumnVarName, // numele coloanei cu label-urile chartului
                                  String rgbBGColor, // valoare HTML hex a culorii de background
                                  String rgbFGColor, // valaore HTML hex a culorii pt. text
                                  String borderColor // valoare HTML hex a culorii a marginilor
                                )
{
}
