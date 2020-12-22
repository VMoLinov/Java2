package lesson1;

public class Track extends Obstacles {

    public Track(int value) {
        super(value);
        super.type = "track";
    }

    @Override
    public void attempt(Sportsmen participant) {
        if (participant.isAction()) {
            if (VALUE <= participant.getMAX_RUN()) {
                System.out.printf("%s пробежал %d метров%n", participant.getNAME(), VALUE);
            } else {
                System.out.printf("%s%s сходит с дистанции%s%n", ANSI_RED, participant.getNAME(), ANSI_RESET);
                participant.setAction(false);
            }
        }
    }
}
