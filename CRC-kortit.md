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
| Vastuualueet:                        | - Seura                              |
|                                      |                                      |
| - Huolehtii tuloskorttien tiedoista  |                                      |
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
| Vastuualueet:                        | - Tuloskortti                        |
|                                      | - Kayttaja                           |
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
| Vastuualueet:                        | - Seura                              |
|                                      | - Tuloskortti                        |
| - Pitää yllä varsinaista tuloskortti-| - Seurat                             |
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
| Vastuualueet:                        | - Kayttaja                           |
|                                      | - Tuloskortti                        |
| - Pitää yllä varsinaista kierrokset- | - Tuloskortit                        |
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
| Vastuualueet:                        | - Kayttaja                           |
|                                      | - Seura                              |
| - Hoitaa kaiken näyttöön tulevan     | - Tuloskortti                        |
|   tekstin                            | - Kierros                            |
| - Hoitaa kaiken tiedon pyytämisen    |                                      |
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
