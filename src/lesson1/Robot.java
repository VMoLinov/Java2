package lesson1;

public class Robot implements Action {

    private final String NAME;
    private final int MAX_JUMP;
    private final int MAX_RUN;
    private boolean action;

    public Robot(String name, int maxJump, int maxRun) {
        this.NAME = name;
        this.MAX_JUMP = maxJump;
        this.MAX_RUN = maxRun;
        action = true;
    }

    @Override
    public void run(int range) {
        if (action) {
            if (range <= MAX_RUN) {
                System.out.printf("%s пробежал %d метров%n", NAME, range);
            } else {
                System.out.printf("%s не пробежал %d метров и сходит с дистанции%n", NAME, range);
                action = false;
            }
        }
    }

    @Override
    public void jump(int height) {
        if (action) {
            if (height <= MAX_JUMP) {
                System.out.printf("%s перепрыгнул %d сантиметров%n", NAME, height);
            } else {
                System.out.printf("%s не преодолел препятствие и сходит с дистанции%n", NAME);
                action = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + NAME + '\'' +
                ", maxJump=" + MAX_JUMP +
                ", maxRun=" + MAX_RUN +
                '}';
    }
}
