**Aihe:** Ohjelma, joka helpottaa Diabeetikon elämää. Pääasiassa ohjelma perustuu insuliinimäärien laskemiseen ja tallentamiseen. Diabeetikko voi kirjoittaa verensokeriarvonsa kenttään ja valinnaisesti muokata mittauksen päivämäärää. Tämän jälkeen mittaus tallentuu ja Diabeetikko voi kirjoittaa hiilihydraattimäärän jolloin ohjelma laskee pistettävän insuliinimäärän.

Ohjelma esittää myös statistiikkoja mm. keskiarvoja ja arvojen ääripäitä. Kaikki tiedot ohjelmasta voi tallentaa JSON -tiedostoon joka mahdollistaa tietojen varmuuskopioinnin ja siirtämisen.

**Käyttäjät:** 1. tyypin Diabeetikko

**Toiminnot:**
* insuliinien CRUD
* verensokereiden CRUD
* ajastettujen insuliinien CRUD

##Luokkakaavio
![Luokkakaavio](http://yuml.me/37c0dd68)
[Muokkaa](http://yuml.me/edit/37c0dd68)

##Sekvenssikaaviot
![Verensokerin mittaus](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgTWVhc3VyZSBCbG9vZFN1Z2FyCgpHVUktPkRhdGFiYXNlOiBHaXZlIGlucHV0IHRvIGNyZWF0ACMNACIILT4AOwo6IEMADRsAUgpTYXZlADYLR1VJOiBHZXQgYWxsAIEIC3M&s=napkin)
```
title Measure BloodSugar

GUI->Database: Give input to create BloodSugar
Database->BloodSugar: Create BloodSugar
Database->Database: Save
Database->GUI: Get all BloodSugars
```
![Insuliinin ottaminen Verensokerimittauksesta](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=dGl0bGUgVGFrZSBCbG9vZFN1Z2FyJ3MgSW5zdWxpbgoKRGF0YWJhc2UtPgAWCjogQWNjZXNzACgLCgA0Ci0-ADYHOgBSBgBDCAAWDABOCDogU2F2ZSBjaGFuZ2Vz&s=napkin)
```
title Take BloodSugar's Insulin

Database->BloodSugar: Access BloodSugar
BloodSugar->Insulin: Take Insulin
BloodSugar->Database: Save changes
```