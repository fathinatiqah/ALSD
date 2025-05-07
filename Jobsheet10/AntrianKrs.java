public class AntrianKrs {

    MahasiswaKrs[] data;
    int front, rear, size, max;
    int jumlahProsesKRS = 0;

    public AntrianKrs(int max) {
        this.max = max;
        data = new MahasiswaKrs[max];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian dikosongkan.");
    }

    public void tambahAntrian(MahasiswaKrs mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambahkan mahasiswa.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }

    public void prosesKRS() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2, tidak bisa proses KRS.");
            return;
        }
        System.out.println("\nMemproses 2 mahasiswa untuk KRS:");
        for (int i = 0; i < 2; i++) {
            MahasiswaKrs mhs = data[front];
            System.out.print(" - ");
            mhs.tampilkanData();
            front = (front + 1) % max;
            size--;
            jumlahProsesKRS++;
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("\nDaftar Mahasiswa dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanDuaTerdepan() {
        if (size == 0) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("\n2 Mahasiswa terdepan:");
            for (int i = 0; i < Math.min(2, size); i++) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                data[index].tampilkanData();
            }
        }
    }

    public void lihatBelakang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling belakang:");
            data[rear].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getJumlahSudahKRS() {
        return jumlahProsesKRS;
    }

    public int getBelumKRS(int totalMaks) {
        return totalMaks - jumlahProsesKRS;
    }
}