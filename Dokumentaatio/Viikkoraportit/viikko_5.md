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
vk4   |      |
24.9  |  4   |
25.9. |  9   |
vk5   |	     |
30.9. |  3   |
1.10. |  5   |
2.10. |  9   |		
Yht.  |  60  |

## Raportti

Kirjoittelin testejä luokalle "Voittaminen", mutta luokan funktio itse asiassa sisältyy kätevämmin toiseen luokkaan niin menee testit vähän uusiksi.
Eli tavallaan takapakkia niissä. Myöskään checkstylen configuraatiossa on vieläkin häikkää, enkä käyttänyt siihen älyttömästi aikaa, kun itse ohjelma on
vielä sen verran vaiheessa. 

Sanoisin kuitenkin, että rakenteessa päästiin tällä viikolla paljon eteenpäin. Minmax algoritmin idea on
varmaan nyt oikein (toivottavasti). Mielelläni kuulisin, jos se on vieläkin perustavanlaatuisesti väärin. Yksityiskohdat on vielä tietysti pielessä esim mitä syvyys 0 tapahtuu. Lisäksi heurestinen pelitilanteen arvioiva luokka "PeliTilanteenArviointi" ei vielä
käsittele eri pelaajia kunnolla. Ohjelma sentään pyörii, mutta tosin sijoittaa vain yhteen koordinaattiin siirtonsa, mutta ainakin helpottaa sitten
testaamista, kun on muuten kunnossa.

Kuten jo alussa puhuttiin, pelitilanteen arvio on selkeästi vaikein asia ja tällä hetkellä pisteytykseni on aika mielivaltainen. Esimerkiksi saako kolmen suorasta enemmän pisteitä kuin kahden haarukasta. Paljon tajuamisia tapahtui kuitenkin tällä viikolla.

Seuraavana vuorossa on saada tekoälyltä jonkinlainen tulos, aina parempi jos siinä on mitään järkeä. Varmaan sitä ennen kirjoitan testit pelitilanteen arvioinnille,
ettei tuhlaannu aikaa väärien juttujen korjaamiseen. Checkstyle kuntoon, jos ehtii. 
