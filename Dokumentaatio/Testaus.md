# Testaaminen


Ohjelma on testattu JUnit yksikkötesteillä sekä vertailemalla empiirisesti suoritusaikoja. Yksikkötestit on kohdistettu ennen kaikkea metodeihin, joiden 
toimintavarmuus ei ilmene välttämättä käytössä. 

Ohjelma pitää kirjaa laskettujen tekoälyn ennalta laskemien siirtojen määrästä. Ilman alfa-beeta -karsintaa ohjelma toimii 4x4 ruudukolla syvyyteen 6 kohtuullisella nopeudella.
Syvyydessä 7 ohjelma laskee noin 18s sekuntia. Alfa-beeta -karsinta laskee tämän ajan noin yhteen sekuntiin, joten ero on merkittävä.
Kuvassa näkyy laskettujen siirtomäärien ero ilman karsintaa ja sen kanssa. Nähdään suoraan, että karsinta vaikuttaa merkittävästi suoritustehoon.

Alfa-beeta -karsinnalla syvyydessä 7 7x7 ruudukossa botti laskee siirtoa noin 15s, joten ruudukon koon kasvaessa raja tulee vastaan nopeasti suurissa syvyyksissä.
Jos lasketaan syvyys 5, botti laskee 14x14 ruudukossa 16s. Syvyydessä 4, 15x15 ruudukossa 2s eli syvyydellä on selkeästi suurin merkitys laskentatehossa.
Ohjelmassa olisi siis paljon optimointi varaa, jos halutaan nostaa täyden 15x15 ruudukon laskentasyvyyttä, joka samalla vaikuttaa merkittävästi tekoälyn älykkyyteen.

![tehokkuusvertailu](https://github.com/Latelaukki/Tiralabra/blob/master/Dokumentaatio/Images/tehokkuusvertailu.png)

