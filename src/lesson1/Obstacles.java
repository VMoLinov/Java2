package lesson1;

public abstract class Obstacles {

    protected final String ANSI_RED = "\u001B[31m";
    protected final String ANSI_RESET = "\u001B[0m";
    protected final int VALUE;
    protected String type;

    Obstacles(int value) {
        this.VALUE = value;
    }

    public abstract void attempt(Sportsmen participate);
}
