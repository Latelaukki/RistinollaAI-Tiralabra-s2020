# Vaatimusmäärittely

## Aiheen esittely
Toteutan työssäni ristinollaa pelaavan tekoälyn. Tavoitteena on, että tekoäly toimii eri kokoisilla alustoilla.

## Työssä käytetyt algoritmit ja tietorakenteet
Tekoäly perustuu minimax-algoritmille, joka perustuu peruuttavaan hakuun. Mahdolliset siirrot ja niiden analyysi tapahtuu siis keko-tietorakenteessa.
Lisäksi algoritmia voidaan optimoida alfa-beeta-karsinnalla. Algoritmi on hyvin yleisesti käytetty tekoälyissä, sillä sen idea on sama pelistä riippumatta. 
Tarkoituksena on saada aikaan tekoäly, joka voittaa tavallisen älykkään aikuisen, tässä tapauksessa riittäköön koodaajan itse. 
Kyseisellä algoritmilla voidaan säädellä kätevästi tekoälyn älykkyyttä kasvattamalla määrää, kuinka monta siirtoa se laskee ennakkoon.
Jos algoritmista tulee liian hidas, voidaan laskettujen siirtojen määrää vähentää ja/tai lisätä alfa-beeta karsinta, jossa vähennetään algoritmin puurakenteessa käytyjen oksien määrää.

Itse pelilauta tallennetaan nxn kokoisena kaksiulotteisena taulukkona, jossa kunkin pelaajan tekemät siirrot. Jos aika sallii, toteutan graafisen käyttöliittymän, mikä helpottaisi
huomattavasti pelin pelaamista. 

Lisäksi peli arpoo aloittajan, mikä perustuu luultavimmin System.nanotime() metodiin.


## Syötteet
Ohjelma on vuoropohjainen peli, jossa kumpikin pelaajista kertoo vuorollaan, mihin kohtaan lautaa tekee siirtonsa. Siirto tallennetaan taulukkoon numeroilla 1 ja 2 
viitaten eri pelaajiin. Lisäksi ajan salliessa pelaaja saa itse valita pelilaudan koon, joka myös otettaisiin syötteenä.

## Aika- ja tilavaativuudet
Näillä näkymin taulukon läpikäyminen vie aikaa O(n^2), jossa n on laudan sivun pituus ja minimax-algoritmi O(2^m), jossa m on ennalta laskettavien siirtojen määrä.
Alfa-beeta-karsinta kuitenkin tehostaa tätä, mutta en ole ihan varma vielä kuinka paljon käytännössä.

Tilavaativuus on myös O(2^m)(?), sillä algoritmi tallentaa kekoon mahdollisten siirtojen arvot, jotta se voi laskea niiden perusteella parhaimman mahdollisen siirron.

## Lähteet
 * Antti Laaksonen. (2020). Tietorakenteet ja algoritmit. Tietorakenteet ja algoritmit -kurssi. Helsingin yliopisto

## Kurssiin liittyviä tietoja
Työ tulee tietojenkäsittelytieteen kandidaatin tutkintoa varten

Ohjelmakieli on Java

Projektin dokumentaation ja ohjelma koodin kielenä on suomi
