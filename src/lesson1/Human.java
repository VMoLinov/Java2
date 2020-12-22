package lesson1;

public class Human implements Actionable {

    private final String NAME;
    private final int AGE;
    private final int MAX_JUMP;
    private final int MAX_RUN;
    private boolean action;

    public Human(String name, int age, int maxJump, int maxRun) {
        this.NAME = name;
        this.AGE = age;
        this.MAX_JUMP = maxJump;
        this.MAX_RUN = maxRun;
        action = true;
    }

    public boolean isAction() {
        return action;
    }

    public String getNAME() {
        return NAME;
    }

    public int getMAX_JUMP() {
        return MAX_JUMP;
    }

    public int getMAX_RUN() {
        return MAX_RUN;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + NAME + '\'' +
                ", age=" + AGE +
                ", maxJump=" + MAX_JUMP +
                ", maxRun=" + MAX_RUN +
                '}';
    }
}
