package lesson1;

public class Track extends Obstacles {

    private final int RANGE;

    public Track(int range) {
        this.RANGE = range;
    }

    public int getRANGE() {
        return RANGE;
    }

    @Override
    public int getValue() {
        return getRANGE();
    }
}
