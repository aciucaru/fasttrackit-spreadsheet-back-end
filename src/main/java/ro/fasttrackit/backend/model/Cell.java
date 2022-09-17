package ro.fasttrackit.backend.model;

// clasa (record) e modeleaza conceptul de celula
// fiecare celula poate avea o valoare 'value' si un stil grafic propriu 'CellStyle'
// un spreadsheet va fi un sir de randuri (Row), iar un rand va fi un sir de celule
public record Cell(String value, CellStyle style)
{

}
