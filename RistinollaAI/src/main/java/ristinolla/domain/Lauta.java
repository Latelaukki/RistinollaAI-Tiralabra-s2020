package ristinolla.domain;

public class Lauta {
    private int [][] lauta;
   
    public Lauta(/*int n*/) {
        this.lauta = new int[5][5];
    }
   
    public void asetaLuku(int y, int x, int pelaajan_id) {
        lauta[y][x] = pelaajan_id; 
    }
   
    public int[][] getLauta() {
        return lauta;
    }
   
    public int getKoko() {
        return lauta.length;
    }
   
    public int getLuku(int y, int x) {
        return lauta[y][x];
    }
   
    public void tulostaLauta() {
        int luku;
        System.out.print(" ");
        for (int k = 0; k < lauta.length; k++) {
            System.out.print(" " + (k + 1));
        }
        System.out.println("");
        for (int i = 0; i < lauta.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < lauta.length; j++) {
                luku = lauta[i][j];
                System.out.print(merkkiTulostukseen(luku));
            }
            System.out.println("");
        }
    }
    
    public String merkkiTulostukseen(int luku) {
        switch (luku) {
            case 1:
                return "X ";
            case 2:
                return "O ";
            default:
                return "* ";
        }       
    }
}
