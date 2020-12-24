package lesson1;

public abstract class Sportsmen {

    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";
    private final String NAME;
    private final int MAX_RUN;
    private final int MAX_JUMP;
    protected String type;
    private boolean action;

    Sportsmen(String name, int maxRun, int maxJump) {
        this.NAME = name;
        this.MAX_RUN = maxRun;
        this.MAX_JUMP = maxJump;
        action = true;
    }

    public boolean isAction() {
        return action;
    }

    public void run(int range) {
        if (range <= MAX_RUN) {
            System.out.printf("%s пробежал %d метров%n", NAME, range);
        } else {
            System.out.printf("%s%s сходит с дистанции%s%n", ANSI_RED, NAME, ANSI_RESET);
            action = false;
        }
    }

    public void jump(int range) {
        if (range <= MAX_JUMP) {
            System.out.printf("%s перепрыгнул препятствие %d сантиметров%n", NAME, range);
        } else {
            System.out.printf("%s%s сходит с дистанции%s%n", ANSI_RED, NAME, ANSI_RESET);
            action = false;
        }
    }

    @Override
    public String toString() {
        return type + "{" +
                "name='" + NAME + '\'' +
                ", maxRun=" + MAX_RUN +
                ", maxJump=" + MAX_JUMP +
                '}';
    }
}
