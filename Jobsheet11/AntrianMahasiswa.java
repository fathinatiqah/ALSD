class AntrianMahasiswa {
    private tugasMahasiswa head, tail;
    private int size;

    public AntrianMahasiswa() {
        head = tail = null;
        size = 0;
    }

    // Cek apakah antrian kosong
    public boolean isEmpty() {
        return head == null;
    }

    public void tambahAntrian(String nama) {
        tugasMahasiswa baru = new tugasMahasiswa(nama);
        if (isEmpty()) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        size++;
        System.out.println("Mahasiswa " + nama + " berhasil ditambahkan ke antrian.");
    }

    public void panggilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Memanggil Mahasiswa: " + head.nama);
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        tugasMahasiswa current = head;
        System.out.println("Daftar Antrian Mahasiswa:");
        while (current != null) {
            System.out.println("- " + current.nama);
            current = current.next;
        }
    }

    public void kosongkanAntrian() {
        head = tail = null;
        size = 0;
        System.out.println("Antrian telah dikosongkan.");
    }

    public void tampilkanDepanBelakang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Mahasiswa terdepan : " + head.nama);
            System.out.println("Mahasiswa terakhir  : " + tail.nama);
        }
    }

    public void jumlahAntrian() {
        System.out.println("Jumlah mahasiswa dalam antrian: " + size);
    }
}