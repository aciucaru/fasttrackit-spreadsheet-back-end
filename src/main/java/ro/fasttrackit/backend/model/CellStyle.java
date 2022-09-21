package ro.fasttrackit.backend.model;

// clasa (record) ce modeleaza conceptul de stil grafic al unei singure celule
// fiecare instanta de tip 'Cell' va avea si o proprietate 'CellStyle', unde sunt inmgazinate
// proprietatile grafice
public record CellStyle(Boolean hasCustomBGColor, // daca celula are un background propriu, diferit de cel default
                        String rgbBGColor, // valoare HTML hex a culorii proprii de background

                        Boolean hasCustomFGColor, // daca celula are text cu culoare proprie, diferita de cea default
                        String rgbFGColor, // valaore HTML hex a culorii proprii pt. text

                        Boolean hasCustomFont, // daca celula are font propriu, diferit de cel default
                        String font, // fontul propriu
                        Boolean isBold, // daca textul celulei este bold
                        Boolean isItalic, // daca textul celulei este italic

                        Boolean hasCustomBorderColor, // daca celula are culoare proprie a marginilor
                        String borderColor, // valoare HTML hex a culorii proprii a marginilor

                        Boolean hasCustomBorderThickness, // daca celula are grosime proprie a marginilor
                        Integer borderThickness // valoare grosimii proprii a marginilor celulei
)
{

}
