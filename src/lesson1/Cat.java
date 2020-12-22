package lesson1;

public class Cat implements Actionable {

    private final String NAME;
    private final int AGE;
    private final int MAX_JUMP;
    private final int MAX_RUN;
    private boolean action;

    public Cat(String name, int age, int maxJump, int maxRun) {
        this.NAME = name;
        this.AGE = age;
        this.MAX_JUMP = maxJump;
        this.MAX_RUN = maxRun;
        action = true;
    }

    @Override
    public boolean isAction() {
        return action;
    }

    @Override
    public String getNAME() {
        return NAME;
    }

    @Override
    public int getMAX_JUMP() {
        return MAX_JUMP;
    }

    @Override
    public int getMAX_RUN() {
        return MAX_RUN;
    }

    @Override
    public void setAction(boolean action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + NAME + '\'' +
                ", age=" + AGE +
                ", maxJump=" + MAX_JUMP +
                ", maxRun=" + MAX_RUN +
                '}';
    }
}
