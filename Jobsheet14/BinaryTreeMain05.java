public class BinaryTreeMain05 {
    public static void main(String[] args) {
        BinaryTree05 bst = new BinaryTree05();

        // Menambahkan data mahasiswa
        bst.add(new Mahasiswa05("244160121", "Ali", "A", 3.57));
        bst.add(new Mahasiswa05("244160221", "Badar", "B", 3.85));
        bst.add(new Mahasiswa05("244160185", "Candra", "C", 3.21));
        bst.add(new Mahasiswa05("244160220", "Dewi", "B", 3.54));

        // Menampilkan data secara in-order
        System.out.println("\nDaftar semua mahasiswa (in-order traversal):");
        bst.traverseInOrder(bst.root);

        // Pencarian data mahasiswa
        System.out.println("\nPencarian data mahasiswa:");
        System.out.print("Cari mahasiswa dengan IPK 3.54: ");
        String hasilCari = bst.find(3.54) ? "Ditemukan" : "Tidak ditemukan";
        System.out.println(hasilCari);

        System.out.print("Cari mahasiswa dengan IPK 3.22: ");
        hasilCari = bst.find(3.22) ? "Ditemukan" : "Tidak ditemukan";
        System.out.println(hasilCari);

        // Menambahkan lagi 3 mahasiswa
        bst.add(new Mahasiswa05("244160131", "Devi", "A", 3.72));
        bst.add(new Mahasiswa05("244160205", "Ehsan", "D", 3.37));
        bst.add(new Mahasiswa05("244160170", "Fizi", "B", 3.46));

        System.out.println("\nDaftar semua mahasiswa setelah penambahan 3 mahasiswa:");
        System.out.println("InOrder Traversal:");
        bst.traverseInOrder(bst.root);
        System.out.println();

        System.out.println("PreOrder Traversal:");
        bst.traversePreOrder(bst.root);
        System.out.println();

        System.out.println("PostOrder Traversal:");
        bst.traversePostOrder(bst.root);
        System.out.println();

        // Penghapusan data mahasiswa
        System.out.println("\nPenghapusan data mahasiswa");
        System.out.println();
        bst.delete(3.57); // hapus Ali
        System.out.println("Daftar semua mahasiswa setelah penghapusan 1 mahasiswa (in-order traversal):");
        bst.traverseInOrder(bst.root);
    }
}