package logic;

public class TreeNode <T>{
    private T info;
    private TreeNode<T> left; //referencia a un elemento por izquierda
    private TreeNode<T> right; //referencia a un elemento por derecha

    public TreeNode(T info) {
        this.info = info;
        this.left = null; // se iniciliza como null por buenas practicas (explicita)
        this.right = null; // se iniciliza como null por buenas practicas (explicita)
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
