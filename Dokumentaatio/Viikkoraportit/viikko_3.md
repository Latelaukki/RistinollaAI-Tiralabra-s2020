## Työaika

pvm   | aika |
------|------|
v1    |      |
3.9.  |  2   |
4.9.  |  5   |
vk2   |      |
8.9.  |  3   |
9.9.  |  4   |
10.9. |  2   |
vk3   |      |
16.9. |  4   |
17.9. |  5   |
18.9. |  5   |
Yht.  |  30  |

## Raportti

Käytin aika paljon aikaa siihen, että yritin saada testejä toimimaan, mutta ilmeisesti build.gradlessa on jotain hämminkiä, sillä tulee aikamoinen kasa virheilmoituksia.
Löysin kyllä esimerkkiprojektista tämän rakenteen, mutta en saanut sitä sovellettua niin, että toimisi. Tulee mm. java.lang.noSuchFieldException: $jacocoAccess.
Pitänee pyytää pajassa apua. 
Tämän jälkeen lähdin jatkamaan ohjelman rakenteen toteutusta. Sain mielestäni ihan hyvälle alulle tekoälyn ja uskon, että ensi viikon palautuksessa tulee iso harppaus.

Olin ymmärtänyt minimaxin tosiaan hieman väärin. Vaikeinta on ollut konseptin toteuttaminen käytännössä, vaikka mielestäni ymmärsin aika hyvin nyt itse algoritmin.
Ohjelman optimointi tulee luultavasti olemaan haaste, sillä pelkään, että muisti tulee loppumaan aika nopeasti, mutta jääköön nähtäväksi.

Haasteena tajusin myös, että laajennettuun ristinollaan liittyy aika paljon pieniä yksityiskohtia, joita ei tarvitse ollenkaan käsitellä 3x3 ruudukossa. Edellisen
viikon palautteessa puhuttiinkin tästä, mutta siis jokaisen ruudun tilanteen pisteytys tulee olemaan luultavasti suuri haaste. 3x3 ruudukossa ei ole tätä ongelmaa, sillä
ei vaadi paljonkaan tietokoneelta laskea kaikki tapaukset, jotka vievät pelin päättymiseen, sillä ruudukko täyttyy niin nopeasti.

Eipä tässä mitään kovin konkreettista kysyttävää ole vieläkään. Ensi viikolla, jos saisi jonkinlaisen tekoälyn aikaiseksi ja testauksen kuntoon. Optimointi ja lisä-
älykkyys voidaan hoitaa myöhemmin.
