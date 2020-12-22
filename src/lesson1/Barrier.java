package lesson1;

public class Barrier extends Obstacles {

    public Barrier(int value) {
        super(value);
        super.type = "barrier";
    }

    @Override
    public void attempt(Sportsmen participant) {
        if (participant.isAction()) {
            if (VALUE <= participant.getMAX_JUMP()) {
                System.out.printf("%s перепрыгнул препятствие %d сантиметров%n", participant.getNAME(), VALUE);
            } else {
                System.out.printf("%s%s сходит с дистанции%s%n", ANSI_RED, participant.getNAME(), ANSI_RESET);
                participant.setAction(false);
            }
        }
    }
}
