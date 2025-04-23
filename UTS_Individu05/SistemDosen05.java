import java.util.*;

public class SistemDosen05 {

    static void insertionSortByNIDN(List<Dosen05> daftar) {
        for (int i = 1; i < daftar.size(); i++) {
            Dosen05 key = daftar.get(i);
            int j = i - 1;
            while (j >= 0 && daftar.get(j).nidn.compareTo(key.nidn) > 0) {
                daftar.set(j + 1, daftar.get(j));
                j--;
            }
            daftar.set(j + 1, key);
        }
    } //insertion sort : ascending

    static Dosen05 linearSearchByName(List<Dosen05> daftar, String namaCari) {
        for (Dosen05 d : daftar) {
            if (d.nama.equalsIgnoreCase(namaCari)) {
                return d;
            }
        }
        return null;
    } //linear search

    static void tampilkanDaftar(List<Dosen05> daftar) {
        if (daftar.isEmpty()) {
            System.out.println("Belum ada data Dosen.");
        } else {
            for (Dosen05 d : daftar) {
                d.tampilkan();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Dosen05> daftarDosen = new ArrayList<>();

        // Data Dosen Dideklarasikan
        daftarDosen.add(new Dosen05("12345", "Budi", "budi@polinema.ac.id", 2015, "Teknik Informatika"));
        daftarDosen.add(new Dosen05("11223", "Ani", "ani@polinema.ac.id", 2012, "Teknik Sipil"));
        daftarDosen.add(new Dosen05("33445", "Citra", "citra@polinema.ac.id", 2018, "Teknik Elektro"));

        int pilihan;
        do {
            System.out.println("\n=== MENU SISTEM DOSEN ===");
            System.out.println("1. Tampilkan Daftar Dosen");
            System.out.println("2. Urutkan Dosen Berdasarkan NIDN (Ascending)");
            System.out.println("3. Cari Dosen Berdasarkan Nama");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            while (!input.hasNextInt()) {
                System.out.print("Masukkan angka: ");
                input.next();
            }
            pilihan = input.nextInt();
            input.nextLine(); // Buang newline

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Daftar Dosen ---");
                    tampilkanDaftar(daftarDosen);
                    break;
                case 2:
                    insertionSortByNIDN(daftarDosen);
                    System.out.println("\n--- Data Diurutkan Berdasarkan NIDN ---");
                    tampilkanDaftar(daftarDosen);
                    break;
                case 3:
                    System.out.print("Masukkan nama Dosen yang dicari: ");
                    String nama = input.nextLine();
                    Dosen05 hasil = linearSearchByName(daftarDosen, nama);
                    if (hasil != null) {
                        System.out.println("\n--- Dosen Ditemukan ---");
                        hasil.tampilkan();
                    } else {
                        System.out.println("Dosen tidak ditemukan.");
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih, keluar dari sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        input.close();
    }
}