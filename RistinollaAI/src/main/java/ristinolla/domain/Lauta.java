package ristinolla.domain;

public class Lauta {
   int [][] lauta;
   
   public Lauta(int n) {
       this.lauta = new int[n][n];
   }
   
   public void teeSiirto(int y, int x, int tunnus) {
       this.lauta[y][x] = tunnus;
   }
   
   public int[][] getLauta() {
       return lauta;
   }
}
