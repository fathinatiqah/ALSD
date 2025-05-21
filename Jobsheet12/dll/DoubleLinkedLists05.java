package dll;

public class DoubleLinkedLists05 {
    Node05 head;
    Node05 tail;

    public DoubleLinkedLists05() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa05 data) {
        Node05 newNode = new Node05(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addLast(Mahasiswa05 data) {
        Node05 newNode = new Node05(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void add(Mahasiswa05 data, int index) {
        if (index < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
    
        Node05 newNode = new Node05(data);
        if (index == 0) {
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            return;
        }
    
        Node05 current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
    
        if (current == null) {
            addLast(data); // Tambahkan di akhir jika index lebih besar dari size
        } else {
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
    }
    
    public void insertAfter(String keyNim, Mahasiswa05 data) {
        Node05 current = head;
    
        // Cari node dengan nim = keyNim
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
    
        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }
    
        Node05 newNode = new Node05(data);
    
        // Jika current adalah tail, cukup tambahkan di akhir
        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            // Sisipkan di tengah
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    
        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        Node05 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }


    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        System.out.println("Data yang terhapus adalah:");
        head.data.tampil();

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    
        System.out.println("Data sudah berhasil dihapus.");
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        System.out.println("Data yang terhapus adalah:");
        tail.data.tampil();
    
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    
        System.out.println("Data sudah berhasil dihapus.");
    }

    public void removeAfter(String keyNim) {
        Node05 current = head;
    
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
    
        if (current == null || current.next == null) {
            System.out.println("Node setelah NIM " + keyNim + " tidak ditemukan atau tidak ada.");
            return;
        }
    
        Node05 toDelete = current.next;
        System.out.println("Data yang dihapus setelah " + keyNim + ":");
        toDelete.data.tampil();
    
        current.next = toDelete.next;
        if (toDelete.next != null) {
            toDelete.next.prev = current;
        } else {
            tail = current;
        }
    }

    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }
    
        if (index == 0) {
            removeFirst();
            return;
        }
    
        Node05 current = head;
        int count = 0;
    
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
    
        if (current == null) {
            System.out.println("Index melebihi jumlah data.");
            return;
        }
    
        System.out.println("Data yang dihapus pada indeks " + index + ":");
        current.data.tampil();
    
        if (current == tail) {
            removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.println("Data pertama:");
            head.data.tampil();
        }
    }
    
    public void getLast() {
        if (isEmpty()) {
            System.out.println("List kosong.");
        } else {
            System.out.println("Data terakhir:");
            tail.data.tampil();
        }
    }
    
    public void getIndex(int index) {
        Node05 current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
    
        if (current == null) {
            System.out.println("Index tidak ditemukan.");
        } else {
            System.out.println("Data pada indeks " + index + ":");
            current.data.tampil();
        }
    }

    public Node05 search(String nim) {
        Node05 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int size() {
        int count = 0;
        Node05 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
