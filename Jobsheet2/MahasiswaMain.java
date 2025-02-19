public class MahasiswaMain {
    public static void main(String[] args) {

        Mahasiswa05 mhs1 = new Mahasiswa05();
        mhs1.nama = "Muhammad ali Farhan";
        mhs1.nim = "244107060031";
        mhs1.kelas = "SI 2J";
        mhs1.ipk = 3.55;

        mhs1.tampilkanInformasi();
        mhs1.ubahKelas("SI 2K");
        mhs1.updateIpk(3.60);
        mhs1.tampilkanInformasi();
    }
}