package ro.fasttrackit.backend.model;

/* Clasa (record) e modeleaza conceptul de celula.
   Fiecare celula poate avea o valoare 'value' si un stil grafic propriu 'CellStyle'.
   Un spreadsheet va fi un sir de randuri (Row), iar un rand va fi un sir de celule (Cell).
   Celula pastreaza cate o valoare pentru fiecare tip posibil al sau ( STRING< NUMBER sau BOOL) si
   la orice moment dat, este folosita doar una dintre aceste valori, in functie de tipul concret al
   celulei.
*/
public record Cell(String stringValue,
                   Double numberValue,
                   Boolean boolValue,
                   CellStyle style)
{

}
