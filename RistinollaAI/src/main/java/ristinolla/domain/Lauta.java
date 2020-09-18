package ristinolla.domain;

public class Lauta {
   int [][] lauta;
   
   public Lauta(int n) {
       this.lauta = new int[n][n];
   }
   
   public void asetaLuku(int pelaajan_id, int y, int x) {
       lauta[y-1][x-1] = pelaajan_id; 
   }
   
   public int[][] getLauta() {
       return lauta;
   }
}
