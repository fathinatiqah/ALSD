import java.util.Scanner;
public class sllMain05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        singleLinkedList05 sll = new singleLinkedList05();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine();

            Mahasiswa05 mhs = new Mahasiswa05(nim, nama, kelas, ipk);

            sll.addLast(mhs);
            sll.print();
        }
        sc.close();
    }
}