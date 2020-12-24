package lesson1;

public class Barrier extends Obstacles {

    public Barrier(int value) {
        super(value);
        super.type = "barrier";
    }

    @Override
    public void attempt(Sportsmen participant) {
        participant.jump(VALUE);
    }
}
