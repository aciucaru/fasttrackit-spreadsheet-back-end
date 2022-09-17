package ro.fasttrackit.backend.model;

/* Enum ce specifica ce tip de date pot stoca celulele unei coloane.
Tipul este pentru o intreaga coloana de celule, nu pentru fiecare celula in parte, adica coloanele
sunt tipizate, toate celuleleor unei coloane au acelasi tip.
Tipurile posibile sunt:
- STRING: coloana ce contine numai celule de tip text
- NUMBER: coloana ce contine numai celule de tip numeric (integer, double)
- BOOL: coloana ce contine numai celule de tip boolean

Observatie: chiar daca tipul este specificat pe coloane, spreadsheet-ul este de fapt organizat pe randuri,
adica un Spreadsheet este un List<Row>, iar un rand este un sir de celule List<Cell>.
Ca sa se determine de care coloana ar apartine o celula, se foloseste pozitia (indexul) celulei, adica:
celula aflata la indexul 3 va apartine de coloana a 4-a, indiferent din randul din care face parte.
 */
public enum ColumnType
{
    STRING,
    NUMBER,
    BOOL
}
