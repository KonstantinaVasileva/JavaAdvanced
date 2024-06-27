package Advanced.Generics.Lab.GenericScale_03;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        return left.compareTo(right) > 0 ? left
                : left.compareTo(right) < 0 ? right : null;
    }
}
