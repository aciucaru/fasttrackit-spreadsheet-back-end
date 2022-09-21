package ro.fasttrackit.backend.model;

/* Clasa (record) ce stocheaza informatiile despre o intreaga coloana de celule, o singura data pentru intreaga coloana.
   Scopul acestei clase este ca anumite informatii sa se stocheze o singura data pentru o
   intreaga coloana de celule, nu pt. fiecare celula in parte, ca sa se economiseasca spatiu de stocare si RAM.
   Informatiile sunt:
   - name: numele (titlul) coloanei, poate avea mai multe cuvinte, este ca un fel de header din tabele HTML
   - colType: tipul tuturor celulelor din inteaga coloana; coloanele spreadsheetului sunt tipizate, adica
            fiecare coloana are un anumit tip exact, iar orice celula a coloanei nu poate fi de alt tip;
            tipurile posibile sunt: STRING, NUMBER, BOOL

Atentie! Spreadsheetul este format din randuri, nu coloane, adica este un sir de randuri: List<Row>.
Motivul pt. care exista aceasta clasa este pentru a nu stoca informatiile din aceasta clasa in fiecare
celula in parte (adica tipul celulei, formula celulei), ca sa se economiseasca memorie.

Tipul celulei va fi "mostenit" de la tipul coloanei de care ar apartine celula respectiva (daca spreadsheetul
ar fi pe coloane, nu pe linii), iar acest lucru se determina dupa indexul celulei, de ex. celula de
index 2 (adica a 3-a) ar apartine coloanei 3, s.a.m.d.

Metoda de generare a valorii celulei este mostenita tot de la coloana de care ar apartine celula.
Valoarea unei celule poate fi generata in doua moduri:
- FROM_USER_INPUT - introdusa (scrisa) de utilizator
- FROM_FORMULA - generate automat dupa formula asociata coloanei din care ar face parte celula

Formula celulei va fi si ea "mosteninta" de la formula coloanei de care ar apartine celula, adica formula
se specifica o singura data, pt. o coloana, si apoi se considera ca se aplica tuturor celulelor corespunzatoare
acelei coloane.

Daca valoarea celulelor coloanei este generata de o formula, atunci coloana trebuie sa aiba un "nume de variabila",
adica un nume dintr-un singur cuvant si fara caractere speciale, exact ca pt. o variabila Java.
Numele de variabila al unei culule va fi obtinut prin adaugarea indexului (pe coloana) al celulei, ca si cum
coloana ar fi un sir, iar celula un element al sirului.
Exemplu:
- nume de variabila pt. coloana: adresa_servici
- nume de variabila pt. celula 2: adresa_servici[1]
- nume de variabila pt. celula 8: adresa_servici[9]
 Indexul se refera la pozitia celulei in cadrul coloanei, adica de sus in jos, nu la pozitia celulei in cadrul
randului din care face.
* */
public record ColumnInfo(String name, // numele afisat al coloanei (un fel de "header" sau "caption")
                         ColumnType colType, // tipul tuturor celulelor coloanei
                         GeneratingMethod genMethod, // modul in care se genereaza valoarea celulelor coloanei
                         String varName, // numele coloanei folosit in formule
                         Integer widthPx // latimea in pixeli a coloanei (si a tuturor celuleor din ea)
                        )
{
}
