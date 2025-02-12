import java.util.Scanner;

public class PraktikumFungsi_05 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int[][] stock = {
            {10, 5, 15, 7}, //RoyalGarden 1
            {6, 11, 9, 12}, //RoyalGarden 2
            {2, 10, 10, 5}, //RoyalGarden 3
            {5, 7, 12, 9}   //RoyalGarden 4
        };
        
        System.out.println("----- Pendapatan setiap cabang jika semua bunga habis terjual -----");
        
        int[] harga = {75000, 50000, 60000, 10000};
        
        for (int i = 0; i < stock.length; i ++) {
            int pendapatan = 0;
            for (int j = 0; j < stock[i].length; j++) {
                pendapatan += stock[i][j] * harga[j];
            }
            System.out.println("RoyalGarden " + (i + 1) + " : Rp " + pendapatan);
        }
        
        System.out.println("===================================================================");
        
        System.out.println("-- Total stock setiap jenis bunga setelah pengurangan bunga mati --");

        int[] stockMati = {-1, -2, -0, -5};
        int[] totalStock = new int[4];

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < stock.length; i++) {
                totalStock[j] += stock[i][j];
            }
            totalStock[j] += stockMati[j];
        }

        System.out.println("Aglonema : " + totalStock[0]);
        System.out.println("Keladi   : " + totalStock[1]);
        System.out.println("Alocasia : " + totalStock[2]);
        System.out.println("Mawar    : " + totalStock[3]);

        scanner.close();

    }
}