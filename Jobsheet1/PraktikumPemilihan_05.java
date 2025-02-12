import java.util.Scanner;

public class PraktikumPemilihan_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        double tugas, kuis, uts, uas;

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("===============================");
        System.out.print("Masukkan Nilai Tugas : ");
        tugas = scanner.nextDouble();
        System.out.print("Masukkan Nilai Kuis : ");
        kuis = scanner.nextDouble();
        System.out.print("Masukkan Nilai UTS : ");
        uts = scanner.nextDouble();
        System.out.print("Masukkan Nilai UAS : ");
        uas = scanner.nextDouble();
        System.out.println("===============================");
        System.out.println("===============================");

        if (tugas < 0 || tugas > 100 || kuis < 0 || kuis > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            System.out.println("Nilai tidak valid");
            System.out.println("===============================");
            System.out.println("===============================");
        }else {

        //hitung nilai
        double nilaiAkhir = (0.2 * tugas) + (0.2 * kuis) + (0.3 * uts) + (0.3 * uas);
        
        String nilaiHuruf;
        if (nilaiAkhir > 80) {
            nilaiHuruf = "A";
        } else if (nilaiAkhir > 73 || nilaiAkhir >= 80) {
            nilaiHuruf = "B+";
        } else if (nilaiAkhir > 65 || nilaiAkhir >= 73) {
            nilaiHuruf = "B";
        } else if (nilaiAkhir > 60 || nilaiAkhir >= 65) {
            nilaiHuruf = "C+";
        } else if (nilaiAkhir > 50 || nilaiAkhir >= 60) {
            nilaiHuruf = "C";
        } else if (nilaiAkhir > 39 || nilaiAkhir >= 50) {
            nilaiHuruf = "D";
        } else {
            nilaiHuruf = "E";
        }

        //status lulus atau tidak
        String status = (nilaiHuruf.equals("A") || nilaiHuruf.equals("B+") || nilaiHuruf.equals("B") ||
                        nilaiHuruf.equals("C+") || nilaiHuruf.equals("C")) ? "SELAMAT ANDA LULUS" : "MAAF ANDA TIDAK LULUS";
        
        System.out.println("Nilai Akhir: " + nilaiAkhir);
        System.out.println("Nilai Huruf: " + nilaiHuruf);
        System.out.println("===============================");
        System.out.println("===============================");
        System.out.println(status);
    }
    scanner.close();
}
}      