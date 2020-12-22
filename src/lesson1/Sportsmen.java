package lesson1;

public abstract class Sportsmen {


    private final String NAME;
    private final int MAX_RUN;
    private final int MAX_JUMP;
    protected String type;
    boolean action;

    Sportsmen(String name, int maxRun, int maxJump) {
        this.NAME = name;
        this.MAX_RUN = maxRun;
        this.MAX_JUMP = maxJump;
        action = true;
    }

    public String getNAME() {
        return NAME;
    }

    public int getMAX_RUN() {
        return MAX_RUN;
    }

    public int getMAX_JUMP() {
        return MAX_JUMP;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }
//    public void run(int range) {
//        if (action) {
//            if (range <= MAX_RUN) {
//                System.out.printf("%s пробежал %d метров%n", NAME, range);
//            } else {
//                System.out.printf("%s%s сходит с дистанции%s%n", ANSI_RED, NAME, ANSI_RESET);
//                action = false;
//            }
//        }
//    }
//
//    public void jump(int range) {
//        if (action) {
//            if (range <= MAX_JUMP) {
//                System.out.printf("%s перепрыгнул препятствие %d сантиметров%n", NAME, range);
//            } else {
//                System.out.printf("%s%s сходит с дистанции%s%n", ANSI_RED, NAME, ANSI_RESET);
//                action = false;
//            }
//        }
//    }

    @Override
    public String toString() {
        return type + "{" +
                "name='" + NAME + '\'' +
                ", maxRun=" + MAX_RUN +
                ", maxJump=" + MAX_JUMP +
                '}';
    }
}
