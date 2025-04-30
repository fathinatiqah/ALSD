import java.util.Scanner;
public class suratDemo05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        stackSurat05 stack = new stackSurat05(10);

        int pilih;
        do {
            System.out.println("\n-------------------------------------------");
            System.out.println("          MENU SURAT IZIN MAHASISWA        ");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat Izin (berdasarkan nama)");
            System.out.println("0. Keluar");
            System.out.print("\nPilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat         : ");
                    String id = sc.nextLine();
                    System.out.print("Nama Mahasiswa   : ");
                    String nama = sc.nextLine();
                    System.out.print("Kelas            : ");
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Izin (S/I) : ");
                    char jenis = sc.nextLine().toUpperCase().charAt(0);
                    System.out.print("Durasi (hari)    : ");
                    int durasi = sc.nextInt();
                    sc.nextLine();


                    Surat05 srt = new Surat05(id, nama, kelas, jenis, durasi);
                    stack.push(srt);
                    System.out.println("Surat berhasil ditambahkan.");
                    break;


                case 2:
                    Surat05 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("Memproses surat:");
                        diproses.tampil();
                    }
                    break;


                case 3:
                    Surat05 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Surat izin terakhir:");
                        lihat.tampil();
                    } else {
                        System.out.println("Tidak ada surat.");
                    }
                    break;


                case 4:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String cari = sc.nextLine();
                    boolean ditemukan = stack.cariSurat(cari);
                    if (ditemukan) {
                        System.out.println("Surat dari " + cari + " ditemukan.");
                    } else {
                        System.out.println("Surat dari " + cari + " tidak ditemukan.");
                    }
                    break;


                case 0:
                    System.out.println("Terima kasih.");
                    break;


                default:
                    System.out.println("Menu tidak valid.");
            }


        } while (pilih != 0);


        sc.close();
    }
}