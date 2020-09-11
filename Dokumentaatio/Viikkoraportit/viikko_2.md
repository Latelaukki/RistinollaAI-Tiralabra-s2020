## Työaika

pvm   | aika |
------|------|
v1    |      |
------|------|
3.9.  |  2   |
4.9.  |  5   |
------|------|
vk2   |      |
------|------|
8.9.  |  3   |
9.9.  |  4   |
10.9. |  2   |
------|------|
Yht.  |  16  |


Viikko 2 kului aika paljon vielä googlettelun parissa. Aloitin tietorakententeiden tekemisen, mutta jäi vielä aika
vaiheeseen. Viime projektissani lähdin koodamaan liian aikasin ja jouduin uusimaan melkein kaiken, kun olin lähtenyt
väärin toteuttamaan. En halua tehdä samaa virhettä tällä kertaa. Opiskelin lisää minimax-algoritmin käytännön toteuksesta 
ja tein alustavan suunnitelman paperille tekoälyn pisteytysjärjestelmästä. Minimax-algoritmihan perustuu laudan tilanteen
arvioimiselle ja koska kyseessä on laajennettu ristinolla (+5x5 ruudukko), niin täytyy luoda fundamentaalisia sääntöjä, jotka johtavat hyviin
tilanteisiin. Päädyin toistaiseksi seuraaviin prioriteetteihin:

1. Voita (pelaa neljän suoraan viides)
2. Estä vastustajaa voittamasta (reagoi jokaiseen kolmen suoraan estämällä vapaa neljän suora, johon on liian myöhäistä reagoida)
3. Luo haarukka (kaksi mahdollisuutta voittaa)
4. Estä toisen pelaajan haarukka
5. Pelaa oman viereen
6. Pelaa samalla suoralla kuin aiemmat, vaikka ei olisikaan vieressä
7. Pelaa lähemmäs keskustaa kuin reunoja (enemmän tilaa saada suora)
x. Pelaa kasaan, lisäpisteitä saa, jos on useamman vieressä (tästä säännöstä en ole vielä aivan varma, varsinkaan siitä mihin kohtaan laittaisin sen)

Opin tosiaan lisää minimax-algoritmista ja katselin paljon pseudokoodeja sen toteuttamisesta. Lisäksi suunnitelin myös jo
tulevia optimointimahdollisuuksia, sillä laaja ristinolla tulee tarvitsemaan kohtuuttomasti laskentatehoa, jos jokainen ruutu
lasketaan. Tätä ongelmaa ei juuri synny 3x3  ristikoissa. Yksi mahdollisuus olisi varmaan luoda erillisiä listoja täytetyistä
riveistä tai edellisestä siirrosta, jolloin voidaan jättää käsittelemättä jokaikinen nurkka ja sivu. Jo 5x5 ruudukossa syntyy
nimittäin aika monta oksaa, jos lähdetään laskemaan monta siirtoa eteenpäin.

Toistaiseksi ei ole vielä varsinaisia ongelmia tullut, kun itse ohjelmointipuoli on vielä niin vaiheessa. Googletessa kuitenkin
huomasin, että laajennettulla ristinollalla tarkoitetaan aika usein 9x3x3 ruudukkoa ja toistaiseksi en ole löytänyt
"jätkänshakista" (suurempi kuin 3x3) materiaalia, mutta uskon, että aika pitkälle samat periaatteet pätevät siinä laskennalle.

Ensi viikon tavoite onkin sitten ruveta toteuttamaan käytännössä näitä ideoita. Tarkoitus on luoda kentän käsittelyfunktiot
ja päättää pistejärjestelmä edellisten prioriteettien mukaisesti. En nähnyt vielä hirveästi mieltä javadocille ja
testaukselle, kun koodiakaan ei ole vielä juuri yhtään.  

