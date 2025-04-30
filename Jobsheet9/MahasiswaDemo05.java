import java.util.Scanner;

public class MahasiswaDemo05 {
    public static void main(String[] args) {

        stackTugasMahasiswa05 stack = new stackTugasMahasiswa05(5);

        Scanner scan = new Scanner(System.in);

        int pilih;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Daftar Tugas");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama  : ");
                    String nama = scan.nextLine();
                    System.out.print("NIM   : ");
                    String nim = scan.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = scan.nextLine();

                    Mahasiswa05 mhs = new Mahasiswa05(nama, nim, kelas);
                    stack.push(mhs);
                    System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
                    break;

                case 2:
                    Mahasiswa05 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Menilai tugas dari " + dinilai.nama);
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = scan.nextInt();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf("Nilai tugas %s adalah %d\n", dinilai.nama, nilai);
                    }
                    break;

                case 3:
                    Mahasiswa05 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.nama);
                    }
                    break;

                case 4:
                    System.out.println("Daftar semua tugas");
                    System.out.println("Nama\tNIM\tKelas");
                    stack.print();
                    break;

                case 5:
                    Mahasiswa05 bawah = stack.lihatTugasTerbawah();
                    if (bawah != null) {
                        System.out.println("Tugas Terbawah: " + bawah);
                    } else {
                        System.out.println("Stack kosong");
                    }
                    break;

                case 6:
                    System.out.println("Jumlah tugas yang dikumpulkan: " + stack.jumlahTugas());
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih >= 1 && pilih <= 4);

        scan.close();
    }
}