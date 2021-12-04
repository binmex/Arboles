package logic;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;

public class BinaryTree<T> {
    private Comparator<T> comparator;
    private TreeNode<T> root;
    ArrayList<T> out;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void addNode(T info) {
        TreeNode<T> node = new TreeNode<>(info);
        if (isEmpty()) {
            root = node; //la raiz va a ser igual al nodo
        } else {
            TreeNode<T> aux = root; //aux que inicia en raiz
            TreeNode<T> ant = null; //un anterior que inicia como nulo
            while (aux != null) {
                ant = aux;
                aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight(); // si info es menor
            }
            if (comparator.compare(info, ant.getInfo()) < 0) {
                ant.setLeft(node);
            } else {
                ant.setRight(node);
            }
        }

    }

    public TreeNode<T> findNode(T info){
        TreeNode<T> aux = root;
        while (aux != null){
            if (comparator.compare(info, aux.getInfo()) == 0){
                return aux;
            }
            aux = comparator.compare(info, aux.getInfo()) <0 ? aux.getLeft() : aux.getRight(); // para iterar y
        }
        return null;
    }

    public ArrayList<T> listPresort() {
        out = new ArrayList<>();
        presort(root);
        return out;
    }

    private void presort(TreeNode<T> root) {
        if (root != null) {
            out.add(root.getInfo());
            presort(root.getLeft());
            presort(root.getRight());
        }
    }



    public ArrayList<T> listInsort() {
        out = new ArrayList<>();
        insort(root);
        return out;
    }

    private void insort(TreeNode<T> root) {
        if (root != null) {
            insort(root.getLeft());
            out.add(root.getInfo());
            insort(root.getRight());
        }
    }

    public ArrayList<T> listPosSort(){
        out = new ArrayList<>();
        posort(root);
        return out;
    }

    private void posort(TreeNode<T> root){
        if (root != null) {
            insort(root.getLeft());
            insort(root.getRight());
            out.add(root.getInfo());
        }
    }

    public boolean isLeaf(TreeNode<T> root){
        TreeNode<T> aux = root;
        while (aux != null){
            if (aux.getLeft() == null && aux.getRight()== null){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public byte gradeNode(TreeNode<T> root){
        TreeNode<T> aux = root;
        byte cont = 0;
        while (aux != null){ //empieza a recorrer
            if (aux.getLeft() != null && aux.getRight() != null){
                cont += 2;
                //cont++;
                return cont;
            }else if (aux.getLeft() != null || aux.getRight() != null){
                cont++;
                return cont;
            }else {
                return 0;
            }
        }

        return 0;
    }

}
