package lesson1;

public class Track implements Obstacles{

    private int range;

    public Track(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    @Override
    public int getValue() {
        return getRange();
    }
}
