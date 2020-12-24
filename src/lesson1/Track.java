package lesson1;

public class Track extends Obstacles {

    public Track(int value) {
        super(value);
        super.type = "track";
    }

    @Override
    public void attempt(Sportsmen participant) {
        participant.run(VALUE);
    }
}

