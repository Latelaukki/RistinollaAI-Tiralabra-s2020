## Toteutus

### Rakenne

Ohjelma on jaettu domain, logic ja ui paketteihin. Domain sisältää lauta-luokan, josta luodaan olio heti pelin alussa. Kaikki operaatiot tapahtuvat
tällä laudalla. Logiikka sisältää pelin kulkuun liittyvät fuktiot, pelitilanteen arvioinnin sekä tekoälyn. Ui sisältää käyttöliittymän sekä Main-luokan.

Pelin rakenne on vielä liikkuva ja luokkajako saattaa hyvinkin muuttua. Aika- ja tilavaativuudet ovat myös vielä epätiedossa.

On todennäköistä, että graafinen käyttöliittymä jää puutteeksi riippuen ajasta.


### Tila- ja aikavaativuudet

Aika- ja tilavaativuudeltaan ohjelma on hyvin raskas, sillä se perustuu jatkuvaan rekursioon, jonka syvyys korreloi suoraan ohjelman käyttökelpoisuuteen. Molemmiksi
vaativuuksiksi muodostuu (k*k)^n(?), jossa n on taulukon koko ja k on ruudukon sivun pituus. 
