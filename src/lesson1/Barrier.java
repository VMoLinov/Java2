package lesson1;

public class Barrier implements Obstacles{

    private int height;

    public Barrier(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getValue() {
        return getHeight();
    }
}
