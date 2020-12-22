package lesson1;

public abstract class Obstacles {

    private final int VALUE;
    protected String type;

    Obstacles(int value) {
        this.VALUE = value;
    }

    public int getValue() {
        return VALUE;
    }
}
