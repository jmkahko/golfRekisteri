## Käyttäjä-luokka (Kayttaja)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Kayttaja                | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        |                                      |
|                                      |                                      |
| - Huolehtii käyttäjän tiedoista      |                                      |
| - Ei tiedä käyttöliittymästä         |                                      |
| - Tietää käyttäjän kentät (id,       |                                      |
|   nimi, kotiseura, tasoitus, jne)    |                                      |
| - Osaa muuttaa merkkijonon           |                                      |
|   seurantiedoiksi                    |                                      |
| - Osaa lukea ja kirjoittaa käyttäjän |                                      |
|   tiedostoon                         |                                      |
| - Osaa antaa ja laittaa merkkijonon  |                                      |
|   i:n kentän tiedoksi ja i:neksi     |                                      |
|   kentäksi                           |                                      |
| - Yksi käyttäjä ainoastaan           |                                      |
+--------------------------------------+--------------------------------------+
```

## Seura-luokka (Seura)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Seura                   | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        |                                      |
|                                      |                                      |
| - Huolehtii golf seuran tiedoista    |                                      |
| - Ei tiedä käyttöliittymästä         |                                      |
| - Tietää seuran kentät (id,          |                                      |
|   seurannimi, osoitetiedot, jne)     |                                      |
| - Osaa antaa ja laittaa merkkijonon  |                                      |
|   i:n kentän tiedoksi ja i:neksi     |                                      |
|   kentäksi                           |                                      |
| - Osaa etsiä seuran                  |                                      |
| - Osaa lukea ja kirjoittaa seuran    |                                      |
|   tiedostoon                         |                                      |
|                                      |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```

## Tuloskortti-luokka (Tuloskortti)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Tulokortti              | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        |                                      |
|                                      |                                      |
| - Huolehtii tuloskortin tiedoista    |                                      |
| - Ei tiedä käyttöliittymästä         |                                      |
| - Tietää seuran kentät (id,          |                                      |
|   seuran, vaylan, pituudet, par, hcp)|                                      |
| - Osaa muuttaa merkkijonon           |                                      |
|   seurantiedoiksi                    |                                      |
| - Osaa muuttaa merkkijonon numeroksi |                                      |
|   ja numeron merkkijonoksi           |                                      |
| - Osaa lukea ja kirjoittaa           |                                      |
|   tuloskortti tiedostoon             |                                      |
| - Osaa pyytää apua avustajiltaan     |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```

## Kierros-luokka (Kierros)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Kierros                 | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        |                                      |
|                                      |                                      |
| - Huolehtii kierroksen tiedoista     |                                      |
| - Ei tiedä käyttöliittymästä         |                                      |
| - Tietää kierroksen kentät (id,      |                                      |
|   tuloskortti, kayttaja, paiva, jne) |                                      |
| - Osaa muuttaa merkkijonon           |                                      |
|   seurantiedoiksi                    |                                      |
| - Osaa lukea ja kirjoittaa kierros   |                                      |
|   tiedostoon                         |                                      |
| - Osaa antaa ja laittaa merkkijonon  |                                      |
|   i:n kentän tiedoksi ja i:neksi     |                                      |
|   kentäksi                           |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```

## GolfRekisteri-luokka (GolfRekisteri)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: GolfRekisteri           | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        | - Kayttaja                           |
|                                      | - Seura                              |
| - Huolehtii Kayttaja, Seura,         | - Tuloskortti                        |
|   Tuloskortti ja Kierros -luokkien   | - Kierros                            |
|   välisestä yhteistyöstä ja välittää |                                      |
|   näitä tietoja pyydettäessä         |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```

## Kayttajat-luokka (Kayttajat)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Kayttajat               | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        | - Kayttaja                           |
|                                      |                                      |
| - Pitää yllä varsinaista kayttaja-   |                                      |
|   rekisteriä, eli lisätä ja          |                                      |
|   poistaa seuran                     |                                      |
| - Osaa lukea ja kirjoittaa kayttaja  |                                      |
|   tiedostoon                         |                                      |
| - Osaa etsiä ja lajitella            |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```

## Seurat-luokka (Seurat)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Seurat                  | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        | - Seura                              |
|                                      |                                      |
| - Pitää yllä varsinaista seura-      |                                      |
|   rekisteriä, eli lisätä ja          |                                      |
|   poistaa seuran                     |                                      |
| - Osaa lukea ja kirjoittaa seuran    |                                      |
|   tiedostoon                         |                                      |
| - Osaa etsiä ja lajitella            |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```

## Tuloskortit-luokka (Tuloskortit)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Tuloskortit             | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        | - Tuloskortti                        |
|                                      |                                      |
| - Pitää yllä varsinaista tuloskortti-|                                      |
|   rekisteriä, eli lisätä ja          |                                      |
|   poistaa tuloskortin                |                                      |
| - Osaa lukea ja kirjoittaa tulos-    |                                      |
|   kortti tiedostoon                  |                                      |
| - Osaa etsiä ja lajitella            |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```

## Kierrokset-luokka (Kierrokset)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Kierrokset              | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        | - Kierrokset                         |
|                                      |                                      |
| - Pitää yllä varsinaista kierrokset- |                                      |
|   rekisteriä, eli lisätä ja          |                                      |
|   poistaa kierroksen                 |                                      |
| - Osaa lukea ja kirjoittaa kierros   |                                      |
|   tiedostoon                         |                                      |
| - Osaa etsiä ja lajitella            |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```

## Käyttöliittymä-luokka (Naytto)
```
+--------------------------------------+--------------------------------------+
| Luokan nimi: Naytto                  | Avustajat:                           |
+--------------------------------------+--------------------------------------+
| Vastuualueet:                        | - GolfRekisteri                      |
|                                      | - Kayttaja                           |
| - Hoitaa kaiken näyttöön tulevan     | - Seura                              |
|   tekstin                            | - Tuloskortti                        |
| - Hoitaa kaiken tiedon pyytämisen    | - Kierros                            |
|   käyttäjältä (ei tiedä kayttajan    |                                      |
|   seuran, tuloskortin eikä kierroksen|                                      |
|   yksityiskohtia)                    |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
|                                      |                                      |
+--------------------------------------+--------------------------------------+
```
