# Boxers
Exercise with arrays

Boxolók
Egy adatbázis bokszolók testsúlyát tartalmazza. Az englishBoxers tömb angol boxolókét, a frenchBoxers tömb pedig franciákét.

int[] englishBoxers = {73, 64, 81, 54, 82, 73, 62, 91, 83}
int[] frenchBoxers = {51, 82, 58, 67, 85, 100, 78, 91, 130, 72}

Van egy weightCategories tömb is, ami a súlycsoportokat tartalmazza
int[] weightCategories = {52, 57, 63, 71, 79, 91}
Ez a tömb a következő módon értelmezendő. A 0. súlycsoport 0 és 52 kg közötti (aki pont 52 kg az még ide tartozik), az 1. súlycsoport 52 és 57 kg közötti (ha 52 < súly <= 57, akkor tartozik ide egy boxoló), stb…

Egy mérkőzésen az összes francia és az összes angol boxoló részt vesz. Mindenki boxol mindenkivel, aki vele egy súlycsoportban van.

Írj programot, ami válaszol az alábbi kérdésekre:
1. Mennyi az angol boxolók átlagos testsúlya?
2. Hángy kg-s a legnehezebb boxoló?
3. Van két olyan boxoló, akik együtt is könnyebbek mint a legnehezebb boxoló? KIk ők (hány kg-sak)?
4. Hányan boxolnak az egyes súlycsoportokban?
5. Van-e olyan boxoló, aki mérkőzés nélkül is nyerni fog (mert egyedül van a súlycsoportjában)?
6. Van-e olyan súlycsoport, ahol garantált a francia aranyérem (mert csak franciák indulnak)? Ha igen melyek ezek?
7. Hány azonos súlyú angol boxoló van? Írd ki a súlyukat!
8. Hány olyan francia boxoló van, aki pontosan azonos súlyú egy angol boxolóval? Írd ki a súlyukat!
9. Írd ki, hogy súlycsoportonként milyen mérkőzések lesznek (hogy milyen súlyú boxolók küzdenek egymással).

Tipp: sok feladat megoldásánát egyszerűsíti, ha van egy olyan tömböd, amiben a francia és az angol boxolók együtt szerepelnek. Írj egy metódust, ami egy tömbbe rakja a két nép boxolóit!
