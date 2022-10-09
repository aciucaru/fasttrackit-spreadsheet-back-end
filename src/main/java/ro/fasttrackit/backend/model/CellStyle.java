package ro.fasttrackit.backend.model;

// clasa (record) ce modeleaza conceptul de stil grafic al unei singure celule
// fiecare instanta de tip 'Cell' va avea si o proprietate 'CellStyle', unde sunt inmgazinate
// proprietatile grafice
public record CellStyle(String rgbBGColor, // valoare HTML hex a culorii de background
                        String rgbFGColor, // valaore HTML hex a culorii pt. text
                        String borderColor, // valoare HTML hex a culorii a marginilor

                        String font, // fontul
                        Boolean isBold, // daca textul celulei este bold
                        Boolean isItalic) // daca textul celulei este italic
{

}
