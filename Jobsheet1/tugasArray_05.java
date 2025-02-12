import java.util.Scanner;

public class tugasArray_05 {

    public static void main(String[] args) {

        //Array untuk kode plat mobil
        char[] KODE = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};

        //Array dua dimensi untuk nama kota
        char[][] KOTA = {
                {'B', 'A', 'N', 'T', 'E', 'N'},
                {'J', 'A', 'K', 'A', 'R', 'T', 'A'},
                {'B', 'A', 'N', 'D', 'U', 'N', 'G'},
                {'C', 'I', 'R', 'E', 'B', 'O', 'N'},
                {'B', 'O', 'G', 'O', 'R'},
                {'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N'},
                {'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G'},
                {'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A'},
                {'M', 'A', 'L', 'A', 'N', 'G'},
                {'T', 'E', 'G', 'A', 'L'}
        };

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Masukkan kode plat nomor (huruf kapital, atau ketik 'keluar' untuk selesai): ");
            String kodeInput = input.nextLine();

            if (kodeInput.equalsIgnoreCase("keluar")) {
                break; //keluar
            }

            if (kodeInput.length() != 1) {
                System.out.println("Kode plat nomor harus terdiri dari satu huruf kapital.");
                continue; //input lagi
            }

            char kode = kodeInput.charAt(0);

            boolean ditemukan = false;
            for (int i = 0; i < KODE.length; i++) {
                if (KODE[i] == kode) {
                    ditemukan = true;
                    System.out.print("Kota: ");
                    for (int j = 0; j < KOTA[i].length; j++) {
                        System.out.print(KOTA[i][j]);
                    }
                    System.out.println();
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Kode plat nomor tidak ditemukan.");
            }
        }

        System.out.println("Terima kasih telah menggunakan program ini.");
        input.close();
    }
}
