package lesson1;

public abstract class Obstacles {

    protected final int VALUE;
    protected String type;

    Obstacles(int value) {
        this.VALUE = value;
    }

    public abstract void attempt(Sportsmen participant);
}
