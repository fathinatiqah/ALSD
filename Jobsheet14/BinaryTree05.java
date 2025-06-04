public class BinaryTree05 {
    Node05 root;

    public BinaryTree05() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa05 mahasiswa) {
        Node05 newNode = new Node05(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node05 current = root;
            Node05 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void addRekursif(Mahasiswa05 mahasiswa) {
        root = tambahRekursif(root, mahasiswa);
    }
    
    private Node05 tambahRekursif(Node05 current, Mahasiswa05 data) {
        if (current == null) {
            return new Node05(data);
        }
        if (data.ipk < current.mahasiswa.ipk) {
            current.left = tambahRekursif(current.left, data);
        } else {
            current.right = tambahRekursif(current.right, data);
        }
        return current;
    }

    public void cariMinIPK() {
        Node05 current = root;
        if (current == null) {
            System.out.println("Tree kosong");
            return;
        }
    
        while (current.left != null) {
            current = current.left;
        }
        System.out.println("Data Mahasiswa dengan IPK terkecil:");
        current.mahasiswa.tampilInformasi();
    }
    
    public void cariMaxIPK() {
        Node05 current = root;
        if (current == null) {
            System.out.println("Tree kosong");
            return;
        }
    
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("Data Mahasiswa dengan IPK terbesar:");
        current.mahasiswa.tampilInformasi();
    }
    
    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        tampilIPKdiAtas(root, ipkBatas);
    }
    
    private void tampilIPKdiAtas(Node05 node, double ipkBatas) {
        if (node != null) {
            tampilIPKdiAtas(node.left, ipkBatas);
            if (node.mahasiswa.ipk > ipkBatas) {
                node.mahasiswa.tampilInformasi();
            }
            tampilIPKdiAtas(node.right, ipkBatas);
        }
    }    
    
    boolean find(double ipk) {
        boolean result = false;
        Node05 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
    
        return result;
    }    

    void traversePreOrder(Node05 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node05 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node05 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    Node05 getSuccessor(Node05 del) {
        Node05 successor = del.right;
        Node05 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }
        // cari node (current) yang akan dihapus
        Node05 parent = root;
        Node05 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk){
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        // penghapusan
        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            // Jika tidak ada anak (leaf, maka node dihapus
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild){
                        parent.left = null;
                    } else {
                    parent.right = null;
                }
            }
        }else if (current.left == null) { // Jika hanya punya 1 anak (kanan)
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        }else if (current.right == null) { // Jika hanya punya 1 anak (kiri)
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                    parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            }else { // Jika punya 2 anak
                    Node05 successor = getSuccessor(current);
                    System.out.println("Jika 2 anak, current = ");
                    successor.mahasiswa.tampilInformasi();
                    if (current == root) {
                        root = successor;
                    } else {
                        if (isLeftChild) {
                        parent.left = successor;
                        } else {
                            parent.right = successor;
                        }
                    }
                    successor.left = current.left;
            }
        }
    }
}