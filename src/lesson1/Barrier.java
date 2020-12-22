package lesson1;

public class Barrier extends Obstacles {

    private final int HEIGHT;

    public Barrier(int height) {
        this.HEIGHT = height;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    @Override
    public int getValue() {
        return getHEIGHT();
    }
}
