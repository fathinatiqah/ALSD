public class Dosen05 {
    String nidn;
    String nama;
    String email;
    int tahunMasuk;
    String prodi;

    public Dosen05(String nidn, String nama, String email, int tahunMasuk, String prodi) {
        this.nidn = nidn;
        this.nama = nama;
        this.email = email;
        this.tahunMasuk = tahunMasuk;
        this.prodi = prodi;
    }

    public int getMasaKerja() {
        int tahunSekarang = 2025;
        return tahunSekarang - this.tahunMasuk;
    }

    public void tampilkan() {
        System.out.println("NIDN         : " + nidn);
        System.out.println("Nama         : " + nama);
        System.out.println("Email        : " + email);
        System.out.println("Masa Kerja   : " + getMasaKerja() + " tahun");
        System.out.println("Program Studi: " + prodi);
        System.out.println();
    }
}