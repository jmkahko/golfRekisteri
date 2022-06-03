Golf tuloskortti

Ohjelma käynnistyy suoraan, jos käyttäjää ei ole niin pyydetään käyttäjänlisäys ensimmäisenä minimissään nimi.
Luodaan golf seura ja seuran kentälle tuloskortti.

Tietorakennetta:

- kayttaja:
	- nimi
	- kotiseura
	- Tasoitus
	- Aloitusvuosi

- seura:
	- seurannimi
	- katuosoite
	- postinumero
	- postiosoite
	- puhelinnumero

- tuloskortti:
	- väylä
	- pituus
		- 62
		- 55
		- 51
		- 48
	- par
	- hcp

- kierros:
	- jokaisen väylän tulos. Väyliä 18 kpl
	- kierrospäivä
	- miltä teeltä pelattu (62, 55, 51, 48)


Taulujen/tiedostojen suhteet keskenään:
- kayttaja - kierros (suhde 1:n) käyttäjällä on useita kierroksia, mutta kierroksella on yksi käyttäjä
- seura - tuloskortti (suhde 1:1) seuralla voi olla yksi tuloskortti ja yksi tuloskortti kuuluu yhteenseuraan
- kierros - tuloskortti  (suhde 1:n) kierroksella on yksi tuloskortti ja tuloskortilla voi olla useita kierroksia 


Pääikkunan menurakenne

Tiedosto	Muokkaa			Apua
=======		=======			====
Tallenna	Muokkaa jäsentä...	Apua
Lopeta		Luo/Päivä seura...	Tietoja...
		Luo/Päivä tuloskortti..
		Poista tuloskortti...
		Poista seura...
