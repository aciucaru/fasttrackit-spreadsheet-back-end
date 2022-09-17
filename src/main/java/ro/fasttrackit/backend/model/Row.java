package ro.fasttrackit.backend.model;

import java.util.List;

/* Record ce modeleaza conceptul de rand (linie) al unui spreadsheet.
   Un Spreadsheet se considera a fi format dintr-un sir de randuri, randurile pornind de sus in jos.
   Un rand este la randul lui un sir de celule. Ca Spreadsheet-ul sa fie uniform, este necesar ca toate
   randurile sa aiba acelasi numar de celule.
* */
public record Row(List<Cell> cells)
{
}
